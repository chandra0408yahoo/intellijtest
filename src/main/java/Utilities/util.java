package Utilities;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class util extends webconnector{

    // waiting for element to appear
    public  WebElement waitforelementtoappear(WebElement element) {

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        return wait.until(ExpectedConditions.elementToBeClickable(element));

    }


    //hoverover an element to click on its sub element

    public  void navigatetoelementandclicksubelement(WebElement mainElement, WebElement subelement) {
        Actions action = new Actions(getDriver());
        action.moveToElement(mainElement).moveToElement(subelement).click().build().perform();
    }
}
