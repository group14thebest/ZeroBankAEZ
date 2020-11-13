package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user_login")
    private WebElement userNameInput;

    @FindBy(id = "user_password")
    private WebElement userPasswordInput;

    @FindBy(name = "submit")
    private WebElement signInButton;

    @FindBy(className = "alert alert-error")
    private WebElement wrongCredentialsMessage;

    public void login() {
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");

        userNameInput.sendKeys(username);
        userPasswordInput.sendKeys(password, Keys.ENTER);
    }






}
