package pageObjectFactory.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by anna on 12.04.17.
 */
public class CommonForms {
    @FindBy(css = "span[class='user-info']")
    WebElement userSpan;

    // TODO what the shame ?
    @FindBy(xpath = "//*[@id=\"navbar-container\"]/div[2]/ul/li[2]/ul/li[4]/a")
    WebElement logOut;

    @FindBy(xpath = "//div[@id='sidebar']//li[3]//span")
    WebElement buttonCreateTaskOnSidebar;

    public void clickOnUser(){
        this.userSpan.click();
    }

    public void clickLogOut(){
        this.logOut.click();
    }

    public void pushCreateTaskOnHomePage(){
        this.buttonCreateTaskOnSidebar.click();
    }
}
