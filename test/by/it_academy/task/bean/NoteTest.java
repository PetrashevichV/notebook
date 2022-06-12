package by.it_academy.task.bean;

import java.util.Arrays;
import java.util.Collection;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import junit.framework.Assert;

@RunWith(value = Parameterized.class)
public class NoteTest {
	
	private String text;
	private LocalDate date;
	
	
	@Parameters
	public static Collection<Object[]> noteTableValue(){
		return Arrays.asList(new Object[][] {
			{"LocalDate",LocalDate.of(2022,1,12)},
			{"Collection<Object[]>",LocalDate.of(2021,12,2)},
			{"noteTableValue",LocalDate.of(2023,6,4)},
			{"Arrays.asList",LocalDate.of(2020,10,23)}
		});
	}


	public NoteTest(String text, LocalDate date) {
		this.text = text;
		this.date = date;
	}
	
	
	@Test
	public void noteTest1() {
		Note n = new Note();
		Assert.assertEquals("", n.getText());
	}
	@Test
	public void noteTest2() {
		Note n = new Note(text);
		Assert.assertEquals(text, n.getText());
	}
	@Test
	public void noteTest3() {
		Note n = new Note(text,date);
		Assert.assertEquals(date, n.getDate());
		Assert.assertEquals(text, n.getText());
	}
	
	
	

}
