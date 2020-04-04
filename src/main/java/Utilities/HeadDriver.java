package Utilities;

import org.openqa.selenium.WebDriver;

public class HeadDriver {

 public WebDriver driver = null;

    public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();


    public  void setWebDriver(WebDriver driver) {

        dr.set(driver);
    }

    public   WebDriver getDriver() {

        return dr.get();

    }



}
