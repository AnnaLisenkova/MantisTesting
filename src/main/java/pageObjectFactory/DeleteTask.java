package pageObjectFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by anna on 09.04.17.
 */
public class DeleteTask {
    @FindBy(xpath = "//input[@type='submit' and contains (@value,'Удалить')]")
    WebElement buttonDelete;

    @FindBy(xpath = "//input[@type='submit' and contains (@value,'Удалить задачи')]")
    WebElement buttonDeleteTasks;

    public void pushButtonDelete(){
        this.buttonDelete.click();
    }

    public void pushButtonDeleteTasks(){
        this.buttonDeleteTasks.click();
    }

}
