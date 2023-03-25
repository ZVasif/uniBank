package StepDefinitions;

import Pages.DialogContent;
import Utilites.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
        //GWD.Bekle(5);
    }

    @Then("Scroll to UBank Yukle and click")
    public void scrollToUBankYukleAndClick() {
        dc.findAndClick("UByukle");
    }

    @And("Click on GooglePlay")
    public void clickOnGooglePlay() {
        //dc.findAndClick("googlePlay");
    }
}
