package com.loop.test.day7_windows;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.Set;

import static org.testng.Assert.assertEquals;


public class Task1 extends TestBase {


    /*
        go to https://loopcamp.vercel.app/
        click "Multiple Windows" link
        Validate "Powered by Loopcamp" is displayed
        Validate title is "Windows"
        Click - click here
        Switch to new window and validate title

        */
    @Test
    public void multipleWindows() {
        driver.get("https://loopcamp.vercel.app/");
        WebElement clickElement = driver.findElement(By.xpath("//a[@href='windows.html']"));
        clickElement.click();



        String actualText= driver.findElement(By.xpath("//div[contains(text(),  'Powered by ')]")).getText();
        //poweredByLoopCamp.isDisplayed();
        Assert.assertEquals(actualText, "Powered by LOOPCAMP");
        Assert.assertEquals(driver.getTitle(),"Windows");
        driver.findElement(By.xpath("//a[@href='windows/new.html']")).click();


        //String actual = ValidateLoopcamp.getText();


        Set<String> windowHandles = driver.getWindowHandles();
        for (String eachWindow : windowHandles){
            driver.switchTo().window(eachWindow);
        }
        Assert.assertEquals(driver.getTitle(),"New Window","Test Failed => Actual does not match the expected ");
    }
}

