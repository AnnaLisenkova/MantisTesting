package pageObjectFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by anna on 09.04.17.
 */
public class CheckTask {

    @FindAll({@FindBy (xpath = "//td[@class='column-summary']")})
    List<WebElement> elements;

    @FindAll({@FindBy (xpath = "//span//a[.='MadeWithFactory']")})
    List<WebElement> appointedTasks;

    public  List<WebElement> getList(){
        return elements;
    }

    public boolean checkWhetherTaskContainsInList(String expected) {
        return elements.stream()
                       .anyMatch((row -> row.findElement(By.xpath("//td[@class='column-summary']"))
                                            .getText()
                                            .equals(expected)));
    }

    public boolean checkWhetherTaskWasAppointed(String expected) {
        return appointedTasks.stream()
                             .anyMatch(row -> row.findElement(By.xpath("//span//a[.='" + expected + "']"))
                                                 .getText()
                                                 .equals(expected));

    }
}
