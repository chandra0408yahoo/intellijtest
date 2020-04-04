package methods;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.util;

public class homepagemethods extends util {

    //repository for elements

    @FindBy(css = "img.logo.img-responsive")
    public static WebElement homepage;

    @FindBy(id = "search_query_top")
    public static WebElement SearchTab;

    @FindBy(xpath = "//ul[@id='homefeatured']//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line']//img[@class='replace-2x img-responsive']")
    public static WebElement clickOnitem;

    @FindBy(xpath = "//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]/span")
    public static WebElement subelement;

    @FindBy(css = "div.layer_cart_product.col-xs-12.col-md-6>h2")
    public static WebElement VerifyTxt;

    @FindBy(xpath = "//span[@class='cross']")
    public static WebElement cross;


    @FindBy(css = "a.sf-with-ul[title='Women']")
    public static WebElement WomenTab;

    @FindBy(xpath = "//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'T-shirts')]")
    public static WebElement TShirt_WomenTab;

    @FindBy(css = ".cat-name")
    public static WebElement TshirtText;


    @FindBy(xpath = "//div[@id='htmlcontent_home']//li[@class='htmlcontent-item-1 col-xs-4']//a[@class='item-link']")
    public static WebElement linksFilters;


    public void gotohomepage() {


        waitforelementtoappear(homepage);
        homepage.click();


    }


    public void typeSummerDress(String str) {


        waitforelementtoappear(SearchTab);
        SearchTab.sendKeys(str);
        SearchTab.sendKeys(Keys.ENTER);

    }

    public void verifyUserNavigatedToSummerDress() {


        Assert.assertTrue(getDriver().getCurrentUrl().contains("dress"));


    }

    public void clickOnitem() {


        waitforelementtoappear(clickOnitem);
        navigatetoelementandclicksubelement(clickOnitem, subelement);

    }


    public void verifyItemAddedToCart() {


        waitforelementtoappear(VerifyTxt);
        Assert.assertTrue(VerifyTxt.getText().contains("Product successfully added to your shopping cart"));
        waitforelementtoappear(cross);
        cross.click();

    }

    public void ClickOnTshirtWomenSection() {


       waitforelementtoappear(WomenTab);
     navigatetoelementandclicksubelement(WomenTab, TShirt_WomenTab);

    }


    public void VerifyImOnTShirtWomenSection() {


        waitforelementtoappear(TshirtText);
        Assert.assertTrue(TshirtText.getText().equals("T-SHIRTS "));

    }


    public void ClickOnlinksicons() {


        waitforelementtoappear(linksFilters);
        linksFilters.click();

    }

    public void verifyIamonfilteredIcons() {


        Assert.assertTrue(getDriver().getCurrentUrl().contains("prestashop"));

    }


}







	

