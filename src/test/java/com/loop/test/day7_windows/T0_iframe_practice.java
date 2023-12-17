package com.loop.test.day7_windows;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class T0_iframe_practice extends TestBase {

    /*
    go to https://loopcamp.vercel.app/nested-frames.html
    validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"

     */

    @Test
    public void left(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.xpath("//*[contains(text(),'LEFT')]"));
        String actualLeft = left.getText();
        Assert.assertEquals(actualLeft.trim(), "LEFT");
    }

    @Test
    public void right(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");
        WebElement right = driver.findElement(By.xpath("//*[contains(text(),'RIGHT')]"));

        String actualLeft = right.getText();
        Assert.assertEquals(actualLeft.trim(), "RIGHT");

    }

    @Test
    public void middle(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.xpath("//*[contains(text(),'MIDDLE')]"));

        String actualLeft = middle.getText();
        Assert.assertEquals(actualLeft.trim(), "MIDDLE");

    }

    @Test
    public void bottom(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-bottom");

        WebElement bottom = driver.findElement(By.xpath("//*[contains(text(),'BOTTOM')]"));

        String actualLeft = bottom.getText();
        Assert.assertEquals(actualLeft.trim(), "BOTTOM");

    }


}