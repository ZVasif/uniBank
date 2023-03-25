package Pages;

import Utilites.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends Parent {
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    //************************** Login **************************//
    @FindBy(css = "[style ='line-height: 15px']")
    private WebElement tele;
    @FindBy(xpath = "(//*[text()='Kartlar'])[1]")
            private WebElement cards;
    @FindBy(css = "[class ^='albalicard__btns']")
            private WebElement uCards;
    @FindBy(css = "[class='buy-card__wrapper']>:nth-child(1)")
            private WebElement UByukle;
    @FindBy(xpath = "//*[contains(@class,'sprite--playstore-label')]")
            private WebElement googlePlay;

    //************************** Ortaq lcator **************************//



    WebElement myElement;
    public void findAndSend (String strElement,String value){
       switch (strElement){
           //case "username":myElement=username;break;

       }


        sendKeysFunction(myElement,value);

    }


    public void findAndClick (String strElement){
        switch (strElement){
            case "cards":myElement=cards;break;
            case "uCards":myElement=uCards;break;
            case "UByukle":myElement=UByukle;break;
            case "googlePlay":myElement=googlePlay;break;


        }
        clickFunction(myElement);
    }

    public void findAndContainsText (String strElement,String text){
        switch (strElement){
            case "tele":myElement=tele;break;
            //case "pageCards":myElement=pageCards;break;


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
