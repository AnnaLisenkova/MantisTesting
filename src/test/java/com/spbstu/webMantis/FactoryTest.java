package com.spbstu.webMantis;

//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by anna on 08.04.17.
 */
public class FactoryTest extends Init{

    @Test
    public void MantisTest(){
        Mantis.open();
        Mantis.loginPage.fillContactForm("administrator", "root");
        Mantis.newTaskPage.pushCreateTaskOnHomePage();
        String expected = "MadeWithFactory";
        Mantis.newTaskPage.fillTaskForm(expected,"Test task...");
        Mantis.newTaskPage.pushCreateTaskOnTaskpage();

        //Check created task
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[11]"));
        Assert.assertTrue(elements.stream().anyMatch(e -> e.getText().contains(expected)));

        //Find the number of created task
        int seqNumb = 1;
        for (int i = 0;i < elements.size();i++){
            if(elements.get(i).getText().equals(expected)){
                seqNumb = i+1;
                break;
            }
        }

        Mantis.deleteTask.pushPencilMark(seqNumb);
        Mantis.deleteTask.pushButtonChangeData();
        Mantis.deleteTask.pushButtonDelete();
        Mantis.deleteTask.pushButtonDeleteTasks();

        //Check deleted task
        List<WebElement> elements2 = driver.findElements(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[11]"));
        if(elements2.size()!=0) {
            Assert.assertFalse(elements2.stream().anyMatch(e -> e.getText().contains(expected)));
        }

    }
}

