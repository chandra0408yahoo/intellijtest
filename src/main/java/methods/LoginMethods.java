package methods;

import Utilities.util;
import Utilities.webconnector;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.text.Utilities;

public class LoginMethods extends util {

    //repository for elements

    @FindBy(css = "a.login")
    public static WebElement signin;

    @FindBy(id = "email")
    public static WebElement username;

    @FindBy(id = "passwd")
    public static WebElement password;

    @FindBy(id = "SubmitLogin")
    public static WebElement login;

    @FindBy(css = "div.alert.alert-danger")
    public static WebElement authfail;




    public void ClickSignin() {


        waitforelementtoappear(signin);
        signin.click();

    }

    public void username(String str) {


        waitforelementtoappear(username);
        username.sendKeys(str);

    }

    public void password(String str) {
        waitforelementtoappear(password);
        password.sendKeys(str);

    }

    public void login() {
        waitforelementtoappear(login);
        login.click();

    }


    public void verifyauthfail() {
        waitforelementtoappear(authfail);
        Assert.assertTrue(authfail.getText().contains("Authentication failed"));

    }


}