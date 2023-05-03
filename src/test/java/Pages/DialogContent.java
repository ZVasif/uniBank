package Pages;

import Utilites.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends Parent {
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    //************************** _01_ UniBank **************************//
    @FindBy(css = "[style ='line-height: 15px']")
    private WebElement tele;
    @FindBy(xpath = "(//*[text()='Kartlar'])[1]")
            private WebElement cards;
    @FindBy(css = "[class ^='albalicard__btns']")
            private WebElement uCards;
    @FindBy(css = "[class='buy-card__wrapper']>:nth-child(1)")
            private WebElement UByukle;
    @FindBy(css = "[class$='playstore-label']")
            private WebElement googlePlay;
    @FindBy(xpath = "//*[contains(@class,'sM5MNb')]/button")
            private WebElement install;
    @FindBy(xpath = "(//*[@class='dIodBf']/button)[4]")
            private WebElement singIn;
    @FindBy(id = "identifierId")
            private WebElement email;
    @FindBy(xpath = "(//*[@jsname=\"V67aGc\"])[2]")
            private WebElement next;
    @FindBy(name = "Passwd")
            private WebElement password;
    @FindBy(id = "passwordNext")
            private WebElement nextPassword;
    @FindBy(className = "dIodBf")
            private WebElement ok;


    //************************** _02_ Kartlar **************************//
//    @FindBy(xpath = "//*[contains(text(),'Albalı Debet')]")
//            private WebElement Dcard_1;

    //************************** _03_ Home Page **************************//
    @FindBy(xpath = "(//*[@class='statisticsbar__links'])[2]")
            private WebElement emanetler;
    @FindBy(xpath = "(//*[@class='items-listing__btns']/a)[1]")
            private WebElement muddetli;
    @FindBy(xpath = "//h1[text()='Müddətli']")
            private WebElement sMessage;





    WebElement myElement;
    public void findAndSend (String strElement,String value){
       switch (strElement){
           case "email":myElement=email;break;
           case "password":myElement=password;break;

       }


        sendKeysFunction(myElement,value);

    }


    public void findAndClick (String strElement){
        switch (strElement){
            case "cards":myElement=cards;break;
            case "uCards":myElement=uCards;break;
            case "UByukle":myElement=UByukle;break;
            case "googlePlay":myElement=googlePlay;break;
            case "install":myElement=install;break;
            case "singIn":myElement=singIn;break;
            case "next":myElement=next;break;
            case "nextPassword":myElement=nextPassword;break;
            case "ok":myElement=ok;break;
            case "emanetler":myElement=emanetler;break;
            case "muddetli":myElement=muddetli;break;


        }
        clickFunction(myElement);
    }

    public void findAndContainsText (String strElement,String text){
        switch (strElement){
            case "tele":myElement=tele;break;
            case "sMessage":myElement=sMessage;break;


        }
        verifyContainsText(myElement,text);
    }

    public void SearchAndDelete(String searchText){
        findAndSend("searchBox",searchText);
        findAndClick("searchBTN");

       // WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.stalenessOf(deleteBTN));

        waitUntilLoading();
        findAndClick("deletebutton");
        findAndClick("deleteDialogbutton");

    }

}
