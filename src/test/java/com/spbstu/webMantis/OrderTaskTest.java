package com.spbstu.webMantis;

import com.spbstu.webMantis.helper.ResourceLoader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectFactory.Mantis;

/**
 * Created by anna on 12.04.17.
 */
public class OrderTaskTest extends Init {

    @Test
    public void MantisTest() throws Exception {
        Mantis.open();

        Mantis.loginPage.fillContactForm(ResourceLoader.getUser("administrator"));

        Mantis.commonForms.pushCreateTaskOnHomePage();

        Mantis.newTaskPage.fillTaskForm(ResourceLoader.getTask("task_1"));
        Mantis.newTaskPage.submitTaskForm();

        Assert.assertTrue(Mantis.checkTask.getList().stream().anyMatch(e -> e.getText().contains(ResourceLoader.getTask("task_1").getSummary())));

        Mantis.changeTask.findAndClickCreatedTask(ResourceLoader.getTask("task_1").getSummary());
        Mantis.changeTask.clickOnChosenUser();
        Mantis.changeTask.pushAppointButton();

        Mantis.commonForms.clickOnUser();
        Mantis.commonForms.clickLogOut();

        Mantis.loginPage.fillContactForm(ResourceLoader.getUser("user_1"));

        Assert.assertTrue(Mantis.checkTask.checkWhetherTaskWasAppointed(ResourceLoader.getTask("task_1").getSummary()));

        Thread.sleep(2000);
    }
}

