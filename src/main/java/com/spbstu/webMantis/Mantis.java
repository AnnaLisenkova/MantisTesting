package com.spbstu.webMantis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjectFactory.Check;
import pageObjectFactory.CreateTask;
import pageObjectFactory.DeleteTask;
import pageObjectFactory.LogIn;

/**
 * Created by anna on 08.04.17.
 */
public class Mantis {

    public static LogIn loginPage;
    public static CreateTask newTaskPage;
    public static DeleteTask deleteTask;
    public static Check checkTask;
    private static WebDriver driver;

    public static void init(WebDriver driver){
        Mantis.loginPage = PageFactory.initElements(driver, LogIn.class);
        Mantis.newTaskPage = PageFactory.initElements(driver,CreateTask.class);
        Mantis.deleteTask = PageFactory.initElements(driver,DeleteTask.class);
        Mantis.checkTask = PageFactory.initElements(driver,Check.class);
        Mantis.driver = driver;
    }

    public static void open(){
        driver.get("http://127.0.0.1/mantisbt");
    }

    public static WebDriver getDriver(){
        return driver;
    }
}