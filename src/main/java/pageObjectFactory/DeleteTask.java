package pageObjectFactory;

import com.spbstu.webMantis.Mantis;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by anna on 09.04.17.
 */
public class DeleteTask {

    @FindBy(xpath = "//*[@id=\"update_bug_form\"]/div/div[3]/input")
    WebElement buttonChangeData;

    @FindBy(xpath = "//input[@type='submit' and contains (@value,'Удалить')]")
    WebElement buttonDelete;

    @FindBy(xpath = "//input[@type='submit' and contains (@value,'Удалить задачи')]")
    WebElement buttonDeleteTasks;

    public void pushPencilMark(int trNumber){
        Mantis.getDriver().findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr["+trNumber+"]/td[2]/a/i")).click();
    }

    public void pushButtonChangeData(){
        this.buttonChangeData.click();
    }

    public void pushButtonDelete(){
        this.buttonDelete.click();
    }

    public void pushButtonDeleteTasks(){
        this.buttonDeleteTasks.click();
    }
}
