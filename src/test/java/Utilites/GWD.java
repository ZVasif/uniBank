package Utilites;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GWD {

    public static WebDriver driver;

    private static  ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>(); //WebDriver 1 WebDriver2
    public static  ThreadLocal<String> threadBrowserName=new ThreadLocal<>(); // chrome , firefox ...





    public static WebDriver getDriver()
    {

        Locale.setDefault( new Locale("EN"));
        System.setProperty("user.language","EN");

        Logger.getLogger("").setLevel(Level.SEVERE);
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");

        if (threadBrowserName.get() == null) // paralel çalışmayan yani XML den parametreyle gelmeyen ler çağıran
            threadBrowserName.set("chrome"); // basic arayanlar için


        if (threadDriver.get() == null) {

            String browserName=threadBrowserName.get(); // bu thread deki browserName yi verdi
            switch (browserName)
            {
                case "chrome":
                    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
                    WebDriverManager.chromedriver().setup();
                    threadDriver.set(new ChromeDriver());
                    break;
//                case "opera":
//                   WebDriverManager.operadriver().setup();
//                   threadDriver.set(new OperaDriverManager());
//                    break;
                case "firefox":
                    System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver());
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    threadDriver.set(new SafariDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    threadDriver.set(new EdgeDriver());
                    break;
            }
        }

        return threadDriver.get();
    }

    public static void quitDriver()
    {
        Bekle(5);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        if (threadDriver.get() != null) { // driver varsa
            threadDriver.get().quit();

            WebDriver driver=threadDriver.get();
            driver=null;
            threadDriver.set(driver); // tekrar gelirse için boş olmuş olsun
        }
    }

    public static void Bekle(int saniye)
    {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
