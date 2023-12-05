package StepDefinitions;

import Pages.DialogContent;
import Utilites.GWD;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class _03_HomePage {
    DialogContent dc=new DialogContent();

    @Then("Click on Əmanətlər, then Müddətli and confirm success message")
    public void clickOnƏmanətlərThenMüddətliAndConfirmSuccessMessage() throws AWTException {
        dc.findAndClick("emanetler");
        dc.findAndClick("muddetli");
        dc.findAndContainsText("sMessage","Müddətli");
        WebElement mebleq= GWD.getDriver().findElement(By.cssSelector("[type=\"number\"]"));

//        Robot robot=new Robot();
//        for (int i = 0; i < 27; i++) {
//            robot.keyPress(KeyEvent.VK_TAB);
//        }

        //mebleq.sendKeys("5000");
       // dc.findAndSend("mebleg","5000");
    }
}


//      //*[contains(@class,'frontbanner__header')]