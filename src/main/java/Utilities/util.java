package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class util extends webconnector{

    // waiting for element to appear
    public static WebElement waitforelementtoappear(WebElement element) {

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        return wait.until(ExpectedConditions.elementToBeClickable(element));

    }


    //hoverover an element to click on its sub element

    public static void navigatetoelementandclicksubelement(WebElement mainElement, WebElement subelement) {
        Actions action = new Actions(getDriver());
        action.moveToElement(mainElement).moveToElement(subelement).click().build().perform();
    }
}
