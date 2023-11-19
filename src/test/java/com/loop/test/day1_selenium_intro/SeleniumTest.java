package com.loop.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        // setting up the web driver
        WebDriverManager.chromedriver().setup();

        // create an instance of webdriver
        WebDriver driver = new ChromeDriver();
        Thread.sleep(1000);

        // navigate to web page
        //driver.get("https://www.google.com");
        driver.navigate().to("https://www.google.com");

        driver.manage().window().maximize();

        driver.navigate().to("https://www.etsy.com");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

        //driver.quit();

        driver.close();
    }
}
