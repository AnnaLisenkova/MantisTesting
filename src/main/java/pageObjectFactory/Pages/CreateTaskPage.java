package pageObjectFactory.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjectFactory.entities.Task;

/**
 * Created by anna on 08.04.17.
 */
public class CreateTaskPage {
    @FindBy(id = "summary")
    WebElement summary;

    @FindBy(id = "description")
    WebElement description;

    @FindBy(css = "input[value='Создать задачу']")
    WebElement submitTaskFormButton;

    public void submitTaskForm(){
        this.submitTaskFormButton.click();
    }

    public void fillTaskForm(Task issue){
        this.summary.sendKeys(issue.getSummary());
        this.description.sendKeys(issue.getDescription());
    }
}
