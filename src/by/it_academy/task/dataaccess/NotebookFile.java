package by.it_academy.task.dataaccess;

import java.io.*;

import by.it_academy.task.bean.Note;
import by.it_academy.task.bean.Notebook;
import by.it_academy.task.logic.NotebookLogic;
import by.it_academy.task.util.NotebookUtil;

public class NotebookFile {

	private static final String TEXT = "[text]";
	private static final String DATE = "[date]";

	public static void fileWriter(Notebook nb, String s) throws Exception {

		File file = new File(s);
		FileWriter writer;

		if (file.canExecute()) {
			writer = new FileWriter(file, false);
		} else {
			file.createNewFile();
			writer = new FileWriter(file, false);
		}

		for (Note n : nb.getNote()) {
			writer.write(TEXT + n.getText() + DATE + n.getDate().getYear() + "/" + n.getDate().getMonthValue()
					+ "/" + n.getDate().getDayOfMonth() + "\n");
		}

		writer.close();
	}

	public static void fileReader(Notebook nb, String s) throws Exception {

		File file = new File(s);
		FileReader reader = new FileReader(file);

		String textNote = "";
		int c;
		String[] arr;

		while ((c = reader.read()) > 0) {
			textNote = textNote + Character.toString(c);
		}

		arr = textNote.split("\\n");

		for (String temp : arr) {
			String text = temp.substring(temp.indexOf(TEXT) + TEXT.length(), temp.indexOf(DATE));
			String date = temp.substring(temp.indexOf(DATE) + DATE.length());
			NotebookLogic.addNote(nb, text, NotebookUtil.strToDate(date));
		}

		reader.close();

	}

}
