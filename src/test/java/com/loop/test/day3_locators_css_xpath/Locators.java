package com.loop.test.day3_locators_css_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class Locators {

    public static void main(String[] args) {

        // setuo driver
        WebDriverManager.chromedriver().setup();

        // create the driver object
        WebDriver driver = new ChromeDriver();

        // navigate to google
        driver.get("https://www.google.com/");


        // maximize the window
        driver.manage().window().maximize();

        // locate the element
        WebElement searchBoxWithID = driver.findElement(By.id("APjFqb"));
        WebElement searchBoxWithName = driver.findElement(By.name("q"));
        WebElement aboutLink = driver.findElement(By.linkText("About"));

       // aboutLink.click();

        // create a string what you want to search
        searchBoxWithName.sendKeys("Feyruz is handsome");
        searchBoxWithID.clear();

        // creat a string what you want to search
        String textToSearth = "Loop Academy";
        searchBoxWithID.sendKeys(textToSearth + Keys.ENTER);
    }
}
