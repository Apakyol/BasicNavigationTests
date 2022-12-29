package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();


        String browser=null;

        if ((System.getProperty("os.name").equals("Windows 11 home")&&browser.equals("safari")||
                (System.getProperty("os.name").equals("Mac")&&browser.equals("edge")))){

        }
        //1-WebDrivingManager(Chrome);
        switch (browser) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "Safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
        }
        driver.get("https://www.google.com");
    }
    }


