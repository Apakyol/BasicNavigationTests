package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
    public static void main(String[] args) {
        //1-WebDrivingManager
        WebDriverManager.chromedriver().setup();
        //2-Create instance of the chrome driver
        WebDriver driver=new ChromeDriver();

    }
}
