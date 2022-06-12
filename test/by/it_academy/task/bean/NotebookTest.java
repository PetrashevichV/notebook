package by.it_academy.task.bean;

import java.util.Arrays;
import java.util.Collection;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import junit.framework.Assert;

@RunWith(value = Parameterized.class)
public class NotebookTest {
	
	private String name;
	
	
	@Parameters
	public static Collection<Object[]> noteTableValue(){
		return Arrays.asList(new Object[][] {
			{"GregorianCalendar"},
			{"Collection<Object[]>"},
			{"noteTableValue"},
			{"Arrays.asList"}
		});
	}


	public NotebookTest(String name) {
		this.name = name;
	}
	
	
	@Test
	public void notebookTest1() {
		Notebook nb = new Notebook();
		Assert.assertEquals("test", nb.getName());
	}
	@Test
	public void notebookTest2() {
		Notebook nb = new Notebook(name);
		Assert.assertEquals(name, nb.getName());
	}


}
