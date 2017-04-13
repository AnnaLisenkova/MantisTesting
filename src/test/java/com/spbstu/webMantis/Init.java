package com.spbstu.webMantis;

import com.spbstu.webMantis.helper.ResourceLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pageObjectFactory.Mantis;

import java.util.concurrent.TimeUnit;

public class Init {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.navigate().to("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Mantis.init(driver);
    }

    @AfterMethod
    public void afterMethod() throws Exception {
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
    }

    @AfterSuite
    public void afterSuite(){
        driver.close();
    }

}