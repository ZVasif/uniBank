package StepDefinitions;

import Pages.DialogContent;
import Utilites.GWD;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _02_Kartlar {
    DialogContent dc = new DialogContent();

    @And("Check how many cards are in kartlar section")
    public void checkHowManyCardsAreInKartlarSection() {

        System.out.println("**************** Kartlar ****************");

        List<WebElement> kartlar=GWD.getDriver().findElements(By.cssSelector("[class='albalicard ']"));
        System.out.println("Kartların sayı "+kartlar.size()+" ədəddir.");

        if (kartlar.size() == 1) {
            System.out.println("Yeni kart əlavə olunmayıb!");
        } else if (kartlar.size() < 1) {
            System.out.println(" Kart siyahıdan çıxarılıb.");
        } else System.out.println((kartlar.size() - 1) + " ədəd yeni kart siyahıya əlavə olunub.");

        System.out.println("<.......... Kartların siyahısı ..........>");

        WebElement card1=GWD.getDriver().findElement(By.className("albalicard__heading"));
        String kart1="UCard";

        for (int i = 0; i < kartlar.size(); i++) {
            if (card1.getText().equalsIgnoreCase(kart1)){
                System.out.println((i+1)+"."+card1.getText()+". *** OK! ***");
                System.out.println("<---------------------------------------->");
            } else {
                System.out.println((i + 1) + "." + card1.getText() + ". *SOS* Yeni və ya dəyişiklik edilmiş kart *SOS*");
            }
        }
        System.out.println("");

        System.out.println("**************** Debet Kartlar ****************");

        List<WebElement> debetCards = GWD.getDriver().findElements(By.xpath("(//*[contains(@class,'commoncards ')])[1]/div"));
        System.out.println("Debet kartların sayı " + debetCards.size()+" ədəddir.");

        if (debetCards.size() == 5) {
            System.out.println("Yeni kart əlavə olunmayıb!");
        } else if (debetCards.size() < 5) {
            System.out.println((5 - debetCards.size()) + " ədəd kart siyahıdan çıxarılıb.");
        } else System.out.println((debetCards.size() - 5) + " ədəd yeni kart siyahıya əlavə olunub.");

        System.out.println("<---------------------------------------->");

        List<WebElement> card2 = GWD.getDriver().findElements(By.xpath("//*[@class='commoncards__name']"));

        String[] listCards = {"Visa Platinum", "Visa Infinite", "Unimiles", "Mastercard Black Edition", "Mastercard World Elite"};

        for (int i = 0; i < debetCards.size(); i++) {
            if (card2.get(i).getText().equalsIgnoreCase(listCards[i])) {

                System.out.println((i + 1) + "." + card2.get(i).getText() + ". *** OK! ***");
                System.out.println("<---------------------------------------->");
            } else {
                System.out.println((i + 1) + "." + card2.get(i).getText() + ". *SOS* Yeni və ya dəyişiklik edilmiş kart *SOS*");
                System.out.println("<---------------------------------------->");
            }

        }

        System.out.println("**************** Digər ****************");

        List<WebElement> diger =GWD.getDriver().findElements(By.xpath("(//*[contains(@class,'commoncards ')])[2]/div"));
        System.out.println("Digər kartların sayı " + diger.size()+" ədəddir.");

        if (diger.size()==4) {
            System.out.println("Yeni kart əlavə olunmayıb!");
        } else if (diger.size() < 4) {
            System.out.println((4 - diger.size()) + " ədəd kart siyahıdan çıxarılıb.");
        } else System.out.println((diger.size() - 4) + " ədəd yeni kart siyahıya əlavə olunub.");

        System.out.println("<---------------------------------------->");

        List<WebElement> card3 =GWD.getDriver().findElements(By.xpath("//*[@class='commoncards__name']"));

        String [] listCard3={"Albalı Debet","Albalı ","UCard Gift","Digital card "};

        for (int i = 9; i < card3.size() ; i--) {
            System.out.println(card3.get(i).getText());
//            if (card3.get(i).getText().equalsIgnoreCase(listCard3[i])){
//
//                System.out.println(card3.get(i).getText()+". *** OK! ***");
//                System.out.println("<---------------------------------------->");
//            } else {
//            System.out.println((i + 1) + "." + card3.get(i).getText() + ". *SOS* Yeni və ya dəyişiklik edilmiş kart *SOS*");
//            System.out.println("<---------------------------------------->");
//        }
        }
    }
}
