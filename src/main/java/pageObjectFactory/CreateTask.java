package pageObjectFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by anna on 08.04.17.
 */
public class CreateTask {
    @FindBy(id = "summary")
    WebElement summary;

    @FindBy(id = "description")
    WebElement description;

    @FindBy(xpath = "//div[@id='sidebar']/ul/li[3]/a/i")
    WebElement buttonCreateTaskOnHomePage;

    @FindBy(css = "input[value='Создать задачу']")
    WebElement buttonCreateTaskOnTaskPage;



    public void pushCreateTaskOnHomePage(){
        this.buttonCreateTaskOnHomePage.click();
    }

    public void pushCreateTaskOnTaskpage(){
        this.buttonCreateTaskOnTaskPage.click();
    }

    public void fillTaskForm(String summary, String description){
        this.summary.sendKeys(summary);
        this.description.sendKeys(description);
    }
}
