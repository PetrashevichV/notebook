package by.it_academy.task.logic;

import java.util.Arrays;
import java.util.Collection;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import by.it_academy.task.bean.Notebook;
import junit.framework.Assert;

@RunWith(value = Parameterized.class)
public class NotebookLogicRemoveTest {
	
	private static Notebook nb = new Notebook();
	private String text;
	private LocalDate date;
	private LocalDate dateFind;
	private int idFind;
	private boolean expected;
	
	@Parameters
	public static Collection<Object[]> removeTableValue(){
		return Arrays.asList(new Object[][]{
			{ "LocalDate", LocalDate.of(2022,1,1), LocalDate.of(2022,1,1), 0, true},
			{ "Collection", LocalDate.now(), LocalDate.now(), 0, true}, 
			{ "Arrays.asList", LocalDate.now(), LocalDate.now(), 0, true},
			{ "LocalDate", LocalDate.of(2022,1,1), LocalDate.now(), 10, false}});
	}
	

	@Before
	public void createNotebook()
	{
		NotebookLogic.addNote(nb, text, date);
	}
	
	public NotebookLogicRemoveTest(String text, LocalDate date, LocalDate dateFind, int idFind, boolean expected) {
		this.text = text;
		this.date = date;
		this.expected = expected;
		this.idFind = idFind;
		this.dateFind = dateFind;
	}
	
	@Test
	public void removeTest() {
		Assert.assertEquals(expected, NotebookLogic.removeNote(nb, idFind));
	}
	
	@Test
	public void removeDateTest() {
		Assert.assertEquals(expected, NotebookLogic.removeDate(nb, dateFind));
	}
	

}
