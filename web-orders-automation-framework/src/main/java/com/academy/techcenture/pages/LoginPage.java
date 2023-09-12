package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="ctl00_MainContent_username")
    protected  WebElement usernameInput;

    @FindBy(id = "ctl00_MainContent_password")
    protected WebElement passwordInput;

    @FindBy(id ="ctl00_MainContent_login_button")
    protected WebElement loginBtn;

    @FindBy(id = "ctl00_MainContent_status")
    protected WebElement loginErrorMessage;

    public void verifyUserIsOnLoginPage(){
        Assert.assertTrue(loginBtn.isDisplayed());
    }
    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        Assert.assertTrue(loginBtn.isEnabled(), "Login button is not enable");
        loginBtn.click();
    }

    public void verifyLoginError(){
        Assert.assertTrue(loginErrorMessage.isDisplayed());
    }


}
