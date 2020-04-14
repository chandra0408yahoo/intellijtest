package Utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class util extends webconnector{

    // waiting for element to appear
    public  WebElement waitforelementtoappear(WebElement element) {

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        highLightElement(element);
        return wait.until(ExpectedConditions.elementToBeClickable(element));

    }


    //hoverover an element to click on its sub element

    public  void navigatetoelementandclicksubelement(WebElement mainElement, WebElement subelement) {
        Actions action = new Actions(getDriver());
        action.moveToElement(mainElement).moveToElement(subelement).click().build().perform();
    }


    public  void highLightElement( WebElement element)
    {
        JavascriptExecutor js=(JavascriptExecutor)getDriver();

        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {

            System.out.println(e.getMessage());
        }

        js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

    }


}
