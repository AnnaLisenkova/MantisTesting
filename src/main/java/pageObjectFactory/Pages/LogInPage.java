package pageObjectFactory.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjectFactory.entities.User;

/**
 * Created by anna on 08.04.17.
 */
public class LogInPage {
    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    public void fillContactForm(User user){
        this.username.sendKeys(user.getLogin());
        this.password.sendKeys(user.getPassword() + Keys.ENTER);
    }

}