package StepDefinitions;

import Pages.DialogContent;
import Utilites.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;

public class _01_uniBank {
    DialogContent dc=new DialogContent();
    @Given("Navigate to Uni Bank")
    public void navigateToUniBank() {
        GWD.getDriver().get("https://unibank.az/");
        GWD.getDriver().manage().window().maximize();
    }

    @When("Enter home page confirm success message")
    public void enterHomePageConfirmSuccessMessage() {
        dc.findAndContainsText("tele","117");
    }

    @Then("Click on the Kartlar on the main page")
    public void clickOnTheKartlarOnTheMainPage() {
        dc.findAndClick("cards");
    }

    @And("Click on the Etrafli in UCard")
    public void clickOnTheEtrafliInUCard() {
        dc.findAndClick("uCards");
    }

    @Then("Scroll to UBank Yukle and click")
    public void scrollToUBankYukleAndClick() {
        dc.findAndClick("UByukle");
    }

    @And("Click on GooglePlay")
    public void clickOnGooglePlay() {
        Set<String> secondW=GWD.getDriver().getWindowHandles();
        for (String window:secondW) {
            GWD.getDriver().switchTo().window(window);
        }
        dc.findAndClick("googlePlay");

    }


    @Then("Click on Install button for download")
    public void clickOnInstallButtonForDownload(){
        WebElement element=GWD.getDriver().findElement(By.cssSelector("[class='edaMIf']"));
        Actions actions=new Actions(GWD.getDriver());
        Action action=actions.moveToElement(element).click().build();
        action.perform();
        dc.findAndClick("singIn");
        dc.findAndSend("email","bond007cems@gmail.com");
        dc.findAndClick("next");

        WebElement finish=GWD.getDriver().findElement(By.id("headingText"));
        if (finish.isDisplayed()){
            System.out.println("*** Müəyyən səbəblərdən dolayı test tamamlandı. ***");
        }else {
            dc.findAndSend("password", "00bond7c");
            dc.findAndClick("nextPassword");
            dc.findAndClick("ok");
        }
    }
}
