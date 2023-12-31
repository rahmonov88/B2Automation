package com.loop.pages;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoopPracticeDragDropPage {

    @FindBy(xpath="//*[@id='draggable']")
    public static WebElement smallCircle;

    @FindBy(id="droptarget")
    public static WebElement bigCircle;

    public LoopPracticeDragDropPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}