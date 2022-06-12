package by.it_academy.task.logic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import by.it_academy.task.bean.Note;
import by.it_academy.task.bean.Notebook;

public class NotebookLogic {

	public static void addNote(Notebook nb, String text, LocalDate date) {
		if (date == null) {
			date = LocalDate.now();
		}
		Note n = new Note(text, date);
		nb.getNote().add(n);
	}

	public static boolean removeNote(Notebook nb, int i) {
		if (nb.getNote().size() > i && i >= 0) {
			nb.getNote().remove(i);
			return true;
		} else {
			return false;
		}
	}

	public static boolean removeDate(Notebook nb, LocalDate date) {
		List<Note> ln = findDate(nb, date);
		boolean b = false;

		for (int i = 0; i < nb.getNote().size(); i++) {
			for (Note nRemove : ln) {
				if (nRemove.equals(nb.getNote().get(i))) {
					b = removeNote(nb, i);
				}
			}
		}
		return b;
	}

	public static List<Note> findText(Notebook nb, String text) {
		List<Note> ln = new ArrayList<>();
		for (int i = 0; i < nb.getNote().size(); i++) {
			if (nb.getNote().get(i).getText().indexOf(text) >= 0) {
				ln.add(nb.getNote().get(i));
			}
		}
		return ln;
	}

	public static List<Note> findDate(Notebook nb, LocalDate date) {
		List<Note> ln = new ArrayList<>();
		for (int i = 0; i < nb.getNote().size(); i++) {
			if (nb.getNote().get(i).getDate().equals(date)) {
				ln.add(nb.getNote().get(i));
			}
		}
		return ln;
	}

}
