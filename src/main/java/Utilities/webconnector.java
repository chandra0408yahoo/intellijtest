package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class webconnector {

    // intitalising files and driver

    public static WebDriver driver = null;
    public static String browser = null;
    public static FileInputStream configfile = null;
    public static Properties prop = null;

    // intialise the config file

    public static void intialise() throws IOException, BiffException {
        configfile = new FileInputStream("src/main/java/resource/Config.properties");

        prop = new Properties();
        prop.load(configfile);

    }


    // getting browser from config file

    public static String getbrowser() {
        return browser = prop.getProperty("browser");

    }

    /////////////////////////////////////// OPEN BROWSER////////////////////////////////////////////////////////
    public static WebDriver open_browser() throws IOException, BiffException {

        if (driver == null) {


            // firefox browser
            if (getbrowser().equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().clearPreferences();
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

                // Chrome browser
            } else if (getbrowser().equalsIgnoreCase("chrome")) {

                WebDriverManager.chromedriver().clearPreferences();
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();


            }

        }

        return driver;
    }

    // navigating to website
    public static void gotowebsite() {

        if (!webconnector.driver.getCurrentUrl().contains("automationpractice")) {
            webconnector.driver.manage().window().maximize();
            webconnector.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webconnector.driver.get(prop.getProperty("url"));

        }
    }

    // quit browser
    public static void quitbrowser() {
        webconnector.driver.quit();
    }

}
