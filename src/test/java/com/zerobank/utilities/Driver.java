package com.zerobank.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver driver;
    private Driver (){};
    public static WebDriver getDriver(){
        if(driver == null){
         String browser = ConfigurationReader.getProperty("browser");
         switch (browser){
             case "chrome":
                 WebDriverManager.chromedriver().setup();
                 ChromeOptions chromeOptions = new ChromeOptions();
                 chromeOptions.addArguments("---start-maximized");
                 driver = new ChromeDriver(chromeOptions);
                 break;
             case "chromeheadless":
                 WebDriverManager.chromedriver().setup();
                 ChromeOptions chromeHeadlessOptions = new ChromeOptions();
                 chromeHeadlessOptions.setHeadless(true);
                 driver = new ChromeDriver(chromeHeadlessOptions);
                 break;
             case "firefox":
                 WebDriverManager.firefoxdriver().setup();
                 driver = new FirefoxDriver();
                 break;
             default:
                 throw new RuntimeException("Wrong browser name!!!");

         }
        }
        return driver;
    }
    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver=null;
        }
    }


}





















