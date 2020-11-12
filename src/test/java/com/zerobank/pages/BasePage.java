package com.zerobank.pages;

import static com.zerobank.utilities.BrowserUtils.*;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver , 10);

    public BasePage(){
        PageFactory.initElements(driver, this);
    }

    protected String headerItem = "//a[.='%s']";
    protected String tabItem = "//a[.='%s']";

    /**
     * click any header items (top)
     * @param item
     */
    public void click_header(String item){
        driver.findElement(By.xpath(String.format(headerItem,item))).click();
    }

    /**
     * click any tab items
     * @param item
     */
    public void click_tab(String item){
        clickOnElement(driver.findElement(By.xpath(String.format(tabItem,item))));
    }








}
