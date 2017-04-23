package pageObjectFactory.Pages;

import com.sun.xml.internal.ws.api.ResourceLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjectFactory.Mantis;

/**
 * Created by anna on 12.04.17.
 */
public class ChangeTaskDataPage {

    @FindBy(xpath = "//select[@class='input-sm']/option[.='user_1']")
    WebElement chosenUserInFallingList;

    @FindBy(xpath = "//input[@type='submit' and @value='Назначить:']")
    WebElement appointUser;

    public void findAndClickCreatedTask(String expected) throws Exception {
        Mantis.checkTask.getList().stream()
                .filter(row -> row.findElement(By.xpath("//td[@class='column-summary']")).getText().equals(expected))
                .findFirst()
                .orElseThrow(Exception :: new)
                .findElement(By.xpath("//td[@class='column-id']/a"))
                .click();
    }

    public void pushAppointButton(){
        this.appointUser.click();
    }

    public void clickOnChosenUser(){
           this.chosenUserInFallingList.click();
    }

    public void clickOnUserInFallingList(String userName){
        Mantis.getDriver().findElement(By.xpath("//select[@class='input-sm']/option[.='"+userName+"']")).click();
    }
}
