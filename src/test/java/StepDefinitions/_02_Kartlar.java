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
        List<WebElement> debetCards = GWD.getDriver().findElements(By.xpath("(//*[contains(@class,'commoncards ')])[1]/div"));
        System.out.println("Debet kartlarin sayi=" + debetCards.size());


        List<WebElement> cards = GWD.getDriver().findElements(By.xpath("//*[@class='commoncards__name']"));

        String[] listCards = {"Visa Platinum", "Visa Infinite", "Unimiles", "Mastercard Black Edition11", "Mastercard World Elite"};
        for (int i = 0; i < debetCards.size(); i++) {
                if (cards.get(i).getText().equalsIgnoreCase(listCards[i])) {

                    System.out.println((i+1)+"."+cards.get(i).getText()+". ( Yeni kart elave olunmayib )");
                    System.out.println("<---------------------------------------->");
                }else
                {System.out.println((i+1)+"."+cards.get(i).getText()+". ( Teze kart var )");
                System.out.println("<---------------------------------------->");}
//            String names=cards.get(i).getText();
//            System.out.println("adlarrrr="+names);

        }

                 // System.out.println("teze kart var");



    }
}
