package com.spbstu.webMantis.stepDefs;

import com.spbstu.webMantis.helper.ResourceLoader;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import pageObjectFactory.Mantis;

import java.util.concurrent.TimeUnit;

/**
 * Created by anna on 22.04.17.
 */
public class Hook {
    WebDriver driver;

    @Before
    public void before(Scenario scenario){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.navigate().to("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Mantis.init(driver);
    }

    @After
    public void after(Scenario scenario) throws Exception {
        Mantis.commonForms.clickOnUser();
        Mantis.commonForms.clickLogOut();
        Mantis.loginPage.fillContactForm(ResourceLoader.getUser("administrator"));

        Mantis.openHomePage();
        Mantis.checkTask.getList().stream()
                .filter(row -> row.findElement(By.xpath("//td[@class='column-summary']")).getText().equals(ResourceLoader.getTask("task_1").getSummary()))
                .findFirst()
                .orElseThrow(Exception :: new)
                .findElement(By.xpath("//td[@class='column-id']/a"))
                .click();
        Mantis.deleteTask.pushButtonDelete();
        Mantis.deleteTask.pushButtonDeleteTasks();
        Assert.assertFalse(Mantis.checkTask.checkWhetherTaskContainsInList(ResourceLoader.getTask("task_1").getSummary()));
        driver.close();
    }
}
