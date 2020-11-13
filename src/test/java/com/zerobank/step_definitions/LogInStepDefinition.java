package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogInStepDefinition {

    LoginPage loginPage = new LoginPage();

    @Given("the user on the login page")
    public void the_user_on_the_login_page() {
        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
    }

    @When("the user logs in with user credentials")
    public void the_user_logs_in_with_user_credentials() {
        loginPage.login();
    }

    @Then("Account summary page is displayed")
    public void account_summary_page_is_displayed() {
        Assert.assertEquals("Zero - Account Summary", Driver.getDriver().getTitle());
    }
}
