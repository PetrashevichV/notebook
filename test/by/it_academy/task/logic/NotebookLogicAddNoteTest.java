package by.it_academy.task.logic;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import by.it_academy.task.bean.Note;
import by.it_academy.task.bean.Notebook;

@RunWith(value = Parameterized.class)
public class NotebookLogicAddNoteTest {

	private static Notebook nb = new Notebook();
	private Note n;
	private String text;
	private LocalDate date;
	private boolean expected;

	@Parameters
	public static Collection<Object[]> addnoteTableValue() {
		return Arrays.asList(new Object[][] { 
			{ "LocalDate", LocalDate.now(), true},
			{ "Collection", LocalDate.now(), true }, 
			{ "Arrays.asList", LocalDate.now(), true } });
	}

	public NotebookLogicAddNoteTest(String text, LocalDate date, boolean expected) {
		this.text = text;
		this.date = date;
		this.expected = expected;
		n = new Note(text, date);
	}

	@Test
	public void addnoteTest() {
		NotebookLogic.addNote(nb, text, date);
		Assert.assertEquals(expected, nb.getNote().contains(n));
	}
	


}
