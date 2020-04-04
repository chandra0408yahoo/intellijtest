package StepDefinitions;

import Utilities.webconnector;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jxl.read.biff.BiffException;
import methods.LoginMethods;
import methods.homepagemethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class loginstepdefs extends webconnector {


    public LoginMethods LG;
    public homepagemethods homepage_method;

    //contructor initialising config file and login page method
    public loginstepdefs() throws IOException, BiffException {

        //no need to mention intialse again as its already called in first step which in turns call homestepdefs

        homepage_method = PageFactory.initElements(getDriver(), homepagemethods.class);
        LG = PageFactory.initElements(getDriver(), LoginMethods.class);


    }

    // enter username and password

    @When("^I enter incorrect username and password$")
    public void iEnterIncorrectUsernameAndPassword(DataTable dt) {


        List<String> list = dt.asList(String.class);

        LG.ClickSignin();
        LG.username(list.get(0));
        LG.password(list.get(1));
        LG.login();

    }

    //verify authetication fail

    @Then("^I verify user is not able to login in$")
    public void iVerifyUserIsNotAbleToLoginIn() {
        LG.verifyauthfail();
    }
}
