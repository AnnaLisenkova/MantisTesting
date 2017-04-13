package pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjectFactory.Pages.ChangeTaskDataPage;
import pageObjectFactory.Pages.CommonForms;
import pageObjectFactory.Pages.CreateTaskPage;
import pageObjectFactory.Pages.LogInPage;

/**
 * Created by anna on 08.04.17.
 */
public class Mantis {

    public static LogInPage loginPage;
    public static CreateTaskPage newTaskPage;
    public static DeleteTask deleteTask;
    public static CheckTask checkTask;
    public static ChangeTaskDataPage changeTask;
    public static CommonForms commonForms;
    private static WebDriver driver;

    public static void init(WebDriver driver) {
        Mantis.loginPage = PageFactory.initElements(driver, LogInPage.class);
        Mantis.newTaskPage = PageFactory.initElements(driver,CreateTaskPage.class);
        Mantis.deleteTask = PageFactory.initElements(driver,DeleteTask.class);
        Mantis.checkTask = PageFactory.initElements(driver, CheckTask.class);
        Mantis.changeTask = PageFactory.initElements(driver,ChangeTaskDataPage.class);
        Mantis.commonForms = PageFactory.initElements(driver,CommonForms.class);
        Mantis.driver = driver;
    }

    public static void open() {
        driver.get("http://127.0.0.1/mantisbt");
    }
    public static void openHomePage() {
        driver.get("http://127.0.0.1/mantisbt/view_all_bug_page.php");
    }
}