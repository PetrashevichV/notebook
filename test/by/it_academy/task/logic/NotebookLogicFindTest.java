package by.it_academy.task.logic;

import java.util.Arrays;
import java.util.Collection;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import by.it_academy.task.bean.Note;
import by.it_academy.task.bean.Notebook;
import junit.framework.Assert;

@RunWith(value = Parameterized.class)
public class NotebookLogicFindTest {

	private static Notebook nb = new Notebook();
	private Note n;
	private String text;
	private String textFind;
	private LocalDate date;
	private LocalDate dateFind;
	private boolean expected;

	@Before
	public void createNote() {
		NotebookLogic.addNote(nb, text, date);
		n = new Note(text, date);
	}

	@Parameters
	public static Collection<Object[]> findTableValue() {
		return Arrays.asList(new Object[][] { 
			{ "LocalDate", "Date", LocalDate.of(2022,1,31), LocalDate.of(2022,1,31), true },
			{ "Collection", "llec", LocalDate.now(), LocalDate.now(), true }, 
			{ "Arrays.asList", "List", LocalDate.now(), LocalDate.now(), true },
			{ "LocalDate", "List1", LocalDate.of(2021,1,1), LocalDate.now(), false }
			});
		
	}

	public NotebookLogicFindTest(String text, String textFind, LocalDate date, LocalDate dateFind, boolean expected) {
		this.text = text;
		this.date = date;
		this.textFind = textFind;
		this.dateFind = dateFind;
		this.expected = expected;
	}

	@Test
	public void findDateTest() {
		Assert.assertEquals(expected, NotebookLogic.findDate(nb, dateFind).contains(n));
	}

	@Test
	public void findTextTest() {
		Assert.assertEquals(expected, NotebookLogic.findText(nb, textFind).contains(n));
	}

}
