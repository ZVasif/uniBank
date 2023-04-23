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
        DialogContent dc=new DialogContent();

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
        System.out.println("");

        System.out.println("**************** Digər ****************");

        List<WebElement> diger =GWD.getDriver().findElements(By.xpath("(//*[contains(@class,'commoncards ')])[2]/div"));
        System.out.println("Digər kartların sayı " + diger.size()+" ədəddir.");

        if (diger.size()==4) {
            System.out.println("Yeni kart əlavə olunmayıb!");
        } else if (diger.size() < 4) {
            System.out.println((4 - diger.size()) + " ədəd kart siyahıdan çıxarılıb.");
        } else System.out.println((diger.size() - 4) + " ədəd yeni kart siyahıya əlavə olunub.");

        System.out.println("<---------------------------------------->");


        WebElement Dcard_1=GWD.getDriver().findElement(By.xpath("//*[contains(text(),'Albalı Debet')]"));
        if (Dcard_1.getText().equalsIgnoreCase("Albalı Debet")){
            System.out.println("1."+Dcard_1.getText()+". *** OK! ***");
            System.out.println("<---------------------------------------->");
        }else System.out.println("1."+Dcard_1.getText()+". *SOS* Yeni və ya dəyişiklik edilmiş kart *SOS*");

        WebElement Dcard_2=GWD.getDriver().findElement(By.xpath("(//*[contains(text(),'Albalı')])[2]"));
        if (Dcard_2.getText().equalsIgnoreCase("Albalı")){
            System.out.println("2."+Dcard_2.getText()+". *** OK! ***");
            System.out.println("<---------------------------------------->");
        }else System.out.println("2."+Dcard_2.getText()+". *SOS* Yeni və ya dəyişiklik edilmiş kart *SOS*");

        WebElement Dcard_3=GWD.getDriver().findElement(By.xpath("//*[contains(text(),'UCard Gift ')]"));
        if (Dcard_3.getText().equalsIgnoreCase("UCard Gift")){
            System.out.println("3."+Dcard_3.getText()+". *** OK! ***");
            System.out.println("<---------------------------------------->");
        }else System.out.println("3."+Dcard_3.getText()+". *SOS* Yeni və ya dəyişiklik edilmiş kart *SOS*");

        WebElement Dcard_4=GWD.getDriver().findElement(By.xpath("//*[contains(text(),'Digital card ')]"));
        if (Dcard_4.getText().equalsIgnoreCase("Digital card")){
            System.out.println("4."+Dcard_4.getText()+". *** OK! ***");
            System.out.println("<---------------------------------------->");
        }else System.out.println("4."+Dcard_4.getText()+". *SOS* Yeni və ya dəyişiklik edilmiş kart *SOS*");










//        List<WebElement> card3 =GWD.getDriver().findElements(By.xpath("//*[@class='commoncards__name']"));
//       String[] listCard3={"Albalı Debet","Albalı ","UCard Gift","Digital card "};
//        for (int i = 0; i < card3.size() ; i++) {
//
//            System.out.println("xxxx="+card3.get(i).getText().equalsIgnoreCase(listCard3[i]));
//        }


    }
}
