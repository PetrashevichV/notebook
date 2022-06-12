package by.it_academy.task.dataaccess;

import java.io.File;
import java.time.LocalDate;
import org.junit.Test;
import by.it_academy.task.bean.Notebook;
import by.it_academy.task.logic.NotebookLogic;
import junit.framework.Assert;

public class NotebookFileTest {

	public static Notebook nb = new Notebook();

	public NotebookFileTest() {
		NotebookLogic.addNote(nb, "test", LocalDate.now());
	}

	@Test
	public void writeTest() throws Exception {

		NotebookFile.fileWriter(nb, "test.txt");
		nb.getNote().remove(0);
		NotebookFile.fileReader(nb, "test.txt");
		Assert.assertEquals(false, nb.getNote().isEmpty());
	}

}
