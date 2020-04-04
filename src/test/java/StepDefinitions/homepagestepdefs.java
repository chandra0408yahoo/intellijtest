package StepDefinitions;

import java.io.IOException;

import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utilities.util;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import jxl.read.biff.BiffException;
import methods.homepagemethods;



public class homepagestepdefs extends util{

    //creating object for methods
    public homepagemethods homepage_method;

    //contructor initialising config file and homepage method
    public homepagestepdefs() throws IOException, BiffException {


      	System.out.println("first");
    	intialise();
    	open_browser();
        homepage_method  =PageFactory.initElements(getDriver(),homepagemethods.class);


    }


    //opening browser and navigating to website
    @Before()
    public void firstbefore() throws IOException, BiffException {
        System.out.println("IN BEFORE STEP");
        gotowebsite();
        System.out.println("before step");


    }

    //quiting browser
    @After()
    public void firstafter() throws IOException {

        quitbrowser();
        System.out.println("AFTER step");




    }


    @Given("^Navigate to website$")
    public void navigateToWebsite() {
        System.out.println("NAVIGATE TO WEBSITE STEp");
    }

    @When("^user enters summer (.*)$")
    public void userEntersSummerDress(String str) {
        homepage_method.typeSummerDress(str);
    }

    @Then("^User should be navigated to summer dress page$")
    public void userShouldBeNavigatedToSummerDressPage() {
        homepage_method.verifyUserNavigatedToSummerDress();
    }

    @When("^I Click on an item$")
    public void iClickOnAnItem() throws IOException, InterruptedException {
        homepage_method.clickOnitem();
        Thread.sleep(1000);

    }

    @Then("^I verify its in cart$")
    public void iVerifyItsInCart() {
        homepage_method.verifyItemAddedToCart();
        homepage_method.gotohomepage();

    }

    @When("^I Click on t shirt of women section$")
    public void iClickOnTShirtOfWomenSection() {
        homepage_method.ClickOnTshirtWomenSection();
    }

    @Then("^I verify am navigated to t shirt page$")
    public void iVerifyAmNavigatedToTShirtPage() {
        homepage_method.VerifyImOnTShirtWomenSection();
        homepage_method.gotohomepage();
    }

    @When("^I click on filter icons$")
    public void iClickOnFilterIcons() {
        homepage_method.ClickOnlinksicons();

    }

    @Then("^I verify I am navigated to filtered website$")
    public void iVerifyIAmNavigatedToFilteredWebsite() {
        homepage_method.verifyIamonfilteredIcons();
    }
}
