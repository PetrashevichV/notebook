package by.it_academy.task.util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import junit.framework.Assert;

@RunWith(value = Parameterized.class)
public class NotebookUtilStrToDateTest {

	private int day;
	private int month;
	private int year;

	@Parameters
	public static Collection<Object[]> strToDateTableValues() {
		return Arrays.asList(new Object[][] { 
			{ 4, 8, 2021 }, 
			{ 25, 1, 2020 }, 
			{ 16, 10, 2022 }, 
			{ 6, 12, 2021 } });
	}

	public NotebookUtilStrToDateTest(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Test
	public void strToDateTest1() {
		String s = year + "/" + month + "/" + day;
		LocalDate date = NotebookUtil.strToDate(s);

		Assert.assertEquals(day, date.getDayOfMonth());
		Assert.assertEquals(month, date.getMonthValue());
		Assert.assertEquals(year, date.getYear());

	}
	
	@Test 
	public void strToDateTest2() {
		String s = "test";
		LocalDate date = NotebookUtil.strToDate(s);
		LocalDate dateTest = LocalDate.now();
		Assert.assertEquals(true,dateTest.equals(date));
		
	}

}
