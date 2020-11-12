package com.zerobank.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(),8);
    public static void wait (int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch(InterruptedException e){
            e.printStackTrace();  //it gives the reason of the exception
        }
    }
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }
    public static void clickWithJS(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].click();",element);

    }
    public static void clickOnElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public static List<String> getTextFromWebElements(List<WebElement> elements) {
        List<String> textValues = new ArrayList<>();
        for (WebElement element : elements) {
            if (!element.getText().isEmpty()) {
                textValues.add(element.getText());
            }
        }
        return textValues;
    }
    public static void enterText(WebElement element , String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        System.out.println("Entering text: "+ text);
    }
    public static void switchWindow(String title) {
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();

        for (String window : windowHandles) {
            Driver.getDriver().switchTo().window(window);
            if (Driver.getDriver().getTitle().equals(title)) {
                break;
            }
        }
    }
    public static void scrollTo(WebElement element){
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
    }
    public static void scrollBy(){
        ((JavascriptExecutor)Driver.getDriver()).executeScript("scroll(0,100)");
    }
    public static String getScreenShot(String name){
        name = new Date().toString().replace(" ","_").replace(":","-")+"_"+name;
        String path = System.getProperty("user.dir")+"/test-ouput/screenshots/"+name+".png";
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(path);

        try {
            FileUtils.copyFile(source, destination);
        }catch (IOException e){
            e.printStackTrace();
        }
        return path;
    }









    }

