package com.ejemplo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
//import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.annotations.DefaultUrl;
//import org.openqa.selenium.WebElement;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
public class LoginPage extends PageObject {

    @FindBy(name = "username")
    private WebElementFacade username;

    @FindBy(name = "password")
    private WebElementFacade password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElementFacade loginButton;

    public void loginAs(String user, String pass) {
        username.waitUntilVisible().clear();
        username.type(user);
        password.waitUntilVisible().clear();
        password.type(pass);
        loginButton.click();
    }
}