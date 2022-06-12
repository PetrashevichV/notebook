package by.it_academy.task.util;

import java.time.LocalDate;

public class NotebookUtil {

	public static LocalDate strToDate(String strDate) {
		LocalDate date = LocalDate.now();
		String[] parts;

		if (strDate.indexOf("/") != -1) {
			parts = strDate.split("/");
			if (parts.length == 3) {
				date = LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])); // הה/לל/דדדד
			}
		}
		return date;
	}

}
