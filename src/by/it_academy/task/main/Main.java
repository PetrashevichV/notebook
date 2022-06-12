package by.it_academy.task.main;

import by.it_academy.task.bean.Notebook;

import by.it_academy.task.view.NotebookView;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Notebook nb = new Notebook("Дневник");

		NotebookView.menuView(nb);

	}

}
