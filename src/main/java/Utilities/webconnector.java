package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.sun.codemodel.internal.fmt.JStaticFile;
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

public class webconnector extends DriverClass{

    // intitalising files and driver

  //  private  WebDriver driver = null;
    DriverClass dc = new DriverClass();
     FirstConfigFile FC= new FirstConfigFile();


   /* most impt if u make webdriver static above
     i.e   private static WebDriver driver = null;
    it will run only if you run all the tests continously
            if you want to run tests after closing browser after every scenario then we need to remove static
    i.e    private  WebDriver driver = null;*/

  /*  public  String browser = null;
    public  FileInputStream configfile = null;
    public  Properties prop = null;*/


    /*public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();


    public  void setWebDriver(WebDriver driver) {

        dr.set(driver);
    }

    public   WebDriver getDriver() {

        return dr.get();

    }*/


    // intialise the config file

    public  void intialise() throws IOException {
        /*configfile = new FileInputStream("src/main/java/resource/Config.properties");

        prop = new Properties();
        prop.load(configfile);
        System.out.println("intialised");*/

        FC.preFirstIntialise();
    }


    // getting browser from config file

   /* public  String getbrowser() {
        return browser = prop.getProperty("browser");

    }*/

    /////////////////////////////////////// OPEN BROWSER////////////////////////////////////////////////////////




    public  WebDriver open_browser() {
        System.out.println("openin brwer");


            if (driver == null) {

                System.out.println(FC.getBrowser+"<<<<<");
                System.out.println(FC.getLocation+"<<<<<");
                // firefox browser
                if (FC.getBrowser.equalsIgnoreCase("Firefox") && FC.getLocation.equalsIgnoreCase("local")) {
                    WebDriverManager.firefoxdriver().clearPreferences();
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    setWebDriver(driver);

                    // Chrome browser
                } else if (FC.getBrowser.equalsIgnoreCase("chrome") && FC.getLocation.equalsIgnoreCase("local")) {

                   /* WebDriverManager.chromedriver().clearPreferences();
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    setWebDriver(driver);*/
                    System.out.println("int chrome"); dc.chromecap();


                }

            }

            return driver;
        }




    public  void gotowebsite() {
        System.out.println("OPENING website");


            if (!getDriver().getCurrentUrl().contains("automationpractice")) {
                System.out.println("goingtoweb");
                getDriver().manage().window().maximize();
                getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                getDriver().get(FC.getURL);
            }
        }




    // quit browser
    public  void quitbrowser() {
        getDriver().quit();
    }

}
