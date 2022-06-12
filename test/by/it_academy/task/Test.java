package by.it_academy.task;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import by.it_academy.task.bean.NoteTest;
import by.it_academy.task.bean.NotebookTest;
import by.it_academy.task.dataaccess.NotebookFileTest;
import by.it_academy.task.logic.NotebookLogicAddNoteTest;
import by.it_academy.task.logic.NotebookLogicFindTest;
import by.it_academy.task.util.NotebookUtilStrToDateTest;

@Suite.SuiteClasses({ NotebookUtilStrToDateTest.class, NoteTest.class, NotebookTest.class, NotebookLogicAddNoteTest.class,
		NotebookLogicFindTest.class, NotebookFileTest.class })
@RunWith(Suite.class)
public class Test {

}