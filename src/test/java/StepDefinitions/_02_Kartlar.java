package StepDefinitions;

import Pages.DialogContent;
import Utilites.GWD;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _02_Kartlar {
    DialogContent dc=new DialogContent();
    @And("Check how many cards are in kartlar section")
    public void checkHowManyCardsAreInKartlarSection() {
        List<WebElement>debetCards= GWD.getDriver().findElements(By.xpath("(//*[contains(@class,'commoncards ')])[1]/div"));
        System.out.println("Debet kartlarin sayi="+debetCards.size());

//        for (int i = 0; i < debetCards.size(); i++) {
//            String cardsName=debetCards.get(i).getText();
//            System.out.println("Cards name="+cardsName);
//        }

        List<WebElement>cards=GWD.getDriver().findElements(By.xpath("//*[@class='commoncards__name']"));

        for (int i = 0; i < debetCards.size(); i++) {
            String names=cards.get(i).getText();
            System.out.println("adlarrrr="+names);
        }


    }
}
