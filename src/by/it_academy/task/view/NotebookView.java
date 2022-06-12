package by.it_academy.task.view;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import by.it_academy.task.util.NotebookUtil;
import by.it_academy.task.bean.Notebook;
import by.it_academy.task.dataaccess.NotebookFile;
import by.it_academy.task.logic.NotebookLogic;

public class NotebookView {

	public static final String MENU = "Выберите действие:\n" + 
			" 1-> Добавить запись\n" + 
			" 2-> Удалить запись\n" + 
			" 3-> Поиск по дате\n" + 
			" 4-> Поиск по тексту\n" + 
			" 5-> Список\n" + 
			" 6-> Выход";

	public static final String ADDDATE = "Введите дату(формат ГГГГ/ММ/ДД): ";

	public static final String ADDTEXT = "Введите текст: ";

	public static final String REMOVE = "Удалить по\n" + 
			" 1-> по дате\n" + 
			" 2-> по номеру";

	public static final String ADDNUMBER = "Введите номер записи:";

	public static final String ERROR = "Ошибка";

	public static void menuView(Notebook nb) throws Exception {
		NotebookFile.fileReader(nb, "note.txt");
		Scanner sc = new Scanner(System.in);
		LocalDate date = LocalDate.now();

		int pMenu = 0;
		boolean fMenu = true;
		String strDate = "01/01/2022";
		String strText = "";

		while (fMenu) {

			print(MENU);

			if (sc.hasNextInt()) {
				pMenu = sc.nextInt();
			} else {
				print(ERROR);

				sc.nextLine();
				pMenu = 0;
			}

			switch (pMenu) {
			case 1: {
				print(ADDDATE);

				strDate = sc.next();
				date = NotebookUtil.strToDate(strDate);

				print(ADDTEXT);

				strText = sc.next();

				NotebookLogic.addNote(nb, strText, date);
				break;
			}
			case 2: {
				print(REMOVE);

				int pRemove = 0;

				if (sc.hasNextInt()) {
					pRemove = sc.nextInt();
				} else {
					print(ERROR);

					sc.nextLine();
					pRemove = 0;
				}
				switch (pRemove) {
				case 1: {
					print(ADDDATE);

					strDate = sc.next();
					date = NotebookUtil.strToDate(strDate);

					if (NotebookLogic.removeDate(nb, date)) {
						printlist(nb.getNote());
					} else {
						print(ERROR);
					}
					break;
				}
				case 2: {
					printlist(nb.getNote());
					int i = 0;

					print(ADDNUMBER);

					if (sc.hasNextInt()) {
						i = sc.nextInt();
						if (NotebookLogic.removeNote(nb, i)) {
							printlist(nb.getNote());
						} else {
							print(ERROR);
						}
					} else {
						print(ERROR);
						sc.nextLine();
					}
					break;
				}
				default: {
					pRemove = 0;
					break;
				}
				}
				break;
			}
			case 3: {
				print(ADDDATE);

				strDate = sc.next();
				date = NotebookUtil.strToDate(strDate);

				printlist(NotebookLogic.findDate(nb, date));
				break;
			}
			case 4: {
				print(ADDTEXT);

				sc.nextLine();
				strText = sc.nextLine();

				printlist(NotebookLogic.findText(nb, strText));

				break;
			}
			case 5: {
				printlist(nb.getNote());
				break;
			}
			case 6: {
				fMenu = false;
				NotebookFile.fileWriter(nb, "note.txt");
				break;
			}
			default: {
				pMenu = 0;
				break;
			}
			}
		}

	}

	public static <T> void print(T s) {
		System.out.println(s);
	}

	public static <T> void printlist(List<T> ln) {
		int i = 0;
		for (T n : ln) {
			System.out.print(i + ":");
			System.out.println(n);
			i++;
		}
	} 


}
