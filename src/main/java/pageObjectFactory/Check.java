package pageObjectFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by anna on 09.04.17.
 */
public class Check {

    @FindAll({@FindBy (xpath = "//*[@id=\"buglist\"]/tbody/tr/td[11]")})
    List<WebElement> elements;

    public  List<WebElement> getList(){
        return elements;
    }

    public int findNumberOfTask(String expected){
        int seqNumb = 1;
        for (int i = 0;i < elements.size();i++){
            if(elements.get(i).getText().equals(expected)){
                seqNumb = i+1;
                break;
            }
        }
        return seqNumb;
    }
}
