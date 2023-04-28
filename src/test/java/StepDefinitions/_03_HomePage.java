package StepDefinitions;

import Utilites.GWD;
import com.google.common.annotations.GwtCompatible;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class _03_HomePage {
    @Then("Check if there is a new campaign")
    public void checkIfThereIsANewCampaign() {
        List<WebElement> campaigns= GWD.getDriver().findElements(By.xpath("//*[contains(@class,'frontbanner__header')]"));

        //GWD.Bekle(15);
        for (int i = 0; i < campaigns.size(); i++) {
            System.out.println("ddd="+campaigns.get(i).getText());
        }
        GWD.Bekle(15);

        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        WebElement element= GWD.getDriver().findElement(By.cssSelector("[class='fotorama__stage']"));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}


//      //*[contains(@class,'frontbanner__header')]