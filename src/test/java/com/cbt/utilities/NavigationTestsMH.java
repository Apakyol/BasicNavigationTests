package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class NavigationTestsMH {

    public static void main(String[] args) {

        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");
        String firstTitle = driver.getTitle();
        driver.navigate().to("https://etsy.com/");
        String secondTitle = driver.getTitle();
        driver.navigate().back();
        verifyEquals(firstTitle, driver.getTitle());
        driver.navigate().forward();
        verifyEquals(secondTitle, driver.getTitle());
        driver.quit();
    }

    public static String getOperatingSystem() {
        String os = System.getProperty("os.name");
        System.out.println("Using System Property: " + os);
        return os.toLowerCase();
    }

    public static WebDriver getDriver(String browserType) {
        String os = getOperatingSystem();
        if (((browserType.equalsIgnoreCase("safari")) && (os.contains("windows"))) || ((browserType.equalsIgnoreCase("edge")) && (os.contains("mac")))) {
            System.out.println("System Mismatch");
            return null;
        }
        if ((browserType.equalsIgnoreCase("chrome"))) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            return new SafariDriver();
        } else if (browserType.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        } else {
            System.out.println("No such driver");
            return null;
        }

    }

    public static void verifyEquals(String expected, String actual) {
        if (expected.equalsIgnoreCase(actual)) System.out.println("PASS");
        else System.out.println("FAIL");
    }


}
