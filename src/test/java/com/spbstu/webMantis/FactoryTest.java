package com.spbstu.webMantis;

import com.spbstu.webMantis.helper.ResourceLoader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectFactory.Mantis;


/**
 * Created by anna on 08.04.17.
 */
public class FactoryTest extends Init{

    @Test
    public void MantisTest() throws Exception {
        Mantis.open();

        Mantis.loginPage.fillContactForm(ResourceLoader.getUser("administrator"));

        Mantis.commonForms.pushCreateTaskOnHomePage();
        Mantis.newTaskPage.fillTaskForm(ResourceLoader.getTask("task_1"));
        Mantis.newTaskPage.submitTaskForm();
        Assert.assertTrue(Mantis.checkTask.getList().stream().anyMatch(e -> e.getText()
                         .contains(ResourceLoader.getTask("task_1").getSummary())));

        Mantis.deleteTask.deleteTask(ResourceLoader.getTask("task_1").getSummary());

    }
}

