package pageObjectFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by anna on 08.04.17.
 */
public class LogIn {
    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;


    public void fillContactForm(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password + Keys.ENTER);
    }

}