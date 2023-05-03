package StepDefinitions;

import Pages.DialogContent;
import io.cucumber.java.en.Then;

public class _03_HomePage {
    DialogContent dc=new DialogContent();

    @Then("Click on Əmanətlər, then Müddətli and confirm success message")
    public void clickOnƏmanətlərThenMüddətliAndConfirmSuccessMessage() {
        dc.findAndClick("emanetler");
        dc.findAndClick("muddetli");
        dc.findAndContainsText("sMessage","Müddətli");
    }
}


//      //*[contains(@class,'frontbanner__header')]