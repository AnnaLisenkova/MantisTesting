package com.spbstu.webMantis.stepDefs;

import com.spbstu.webMantis.helper.ResourceLoader;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import pageObjectFactory.Mantis;

/**
 * Created by anna on 18.04.17.
 */
public class StepsForScenario1 {
    @Given("^Log in as \"([^\"]*)\"$")
    public void logInAs(String userID) throws Throwable {
        Mantis.open();
        Mantis.loginPage.fillContactForm(ResourceLoader.getUser(userID));
    }

    @And("^Open create Task page$")
    public void openCreateTaskPage() throws Throwable {
        Mantis.commonForms.pushCreateTaskOnHomePage();
    }

    @And("^Create Task using info from \"([^\"]*)\"$")
    public void createTaskUsingInfoFrom(String taskID) throws Throwable {
        Mantis.newTaskPage.fillTaskForm(ResourceLoader.getTask(taskID));
        Mantis.newTaskPage.submitTaskForm();
    }

    @And("^Check that \"([^\"]*)\" was created$")
    public void checkThatWasCreated(String taskID) throws Throwable {
        Assert.assertTrue(Mantis.checkTask.getList().stream().anyMatch(
                e -> e.getText().contains(ResourceLoader.getTask(taskID).getSummary())));
    }

    @And("^Order \"([^\"]*)\" to user \"([^\"]*)\"$")
    public void orderToUser(String taskID, String userID) throws Throwable {
        Mantis.changeTask.findAndClickCreatedTask(ResourceLoader.getTask(taskID).getSummary());
        Mantis.changeTask.clickOnUserInFallingList(ResourceLoader.getUser(userID).getLogin());
        Mantis.changeTask.pushAppointButton();
    }

    @And("^Log out$")
    public void logOut() throws Throwable {
        Mantis.commonForms.clickOnUser();
        Mantis.commonForms.clickLogOut();
    }


    @Then("^I should see that \"([^\"]*)\" was rightly ordered$")
    public void iShouldSeeThatWasRightlyOrdered(String taskID) throws Throwable {
        Assert.assertTrue(Mantis.checkTask.checkWhetherTaskWasAppointed(ResourceLoader.getTask(taskID).getSummary()));
    }


}
