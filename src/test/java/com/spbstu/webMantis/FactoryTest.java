package com.spbstu.webMantis;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by anna on 08.04.17.
 */
public class FactoryTest extends Init{

    @Test
    public void MantisTest(){
        Mantis.open();

        Mantis.loginPage.fillContactForm("administrator", "root");

        Mantis.newTaskPage.pushCreateTaskOnHomePage();
        String expected = "MadeWithFactory";
        Mantis.newTaskPage.fillTaskForm(expected,"Test task...");
        Mantis.newTaskPage.pushCreateTaskOnTaskpage();

        int seqNumb = Mantis.checkTask.findNumberOfTask(expected);
        Assert.assertTrue(Mantis.checkTask.getList().stream().anyMatch(e -> e.getText().contains(expected)));

        Mantis.deleteTask.pushPencilMark(seqNumb);
        Mantis.deleteTask.pushButtonChangeData();
        Mantis.deleteTask.pushButtonDelete();
        Mantis.deleteTask.pushButtonDeleteTasks();

        //Check deleted task
        if(Mantis.checkTask.getList().size()!=0) {
            Assert.assertFalse(Mantis.checkTask.getList().stream().anyMatch(e -> e.getText().contains(expected)));
        }
    }
}

