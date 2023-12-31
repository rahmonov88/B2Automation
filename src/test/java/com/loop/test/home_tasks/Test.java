package com.loop.test.home_tasks;

import com.github.javafaker.Faker;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Test {
    @org.testng.annotations.Test

    public void getToLoopAcademyWebSite() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("loopcamp"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,99);");

        Faker faker = new Faker();

        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName() + Keys.TAB + faker.name().lastName() +
                Keys.TAB + faker.name().firstName() + faker.number().digits(5) + Keys.TAB + faker.internet().emailAddress() + Keys.TAB +
                faker.internet().password() + Keys.TAB + faker.numerify("###-###-####"));

        WebElement genderRadioButton = Driver.getDriver().findElement(By.xpath("//input[@name='gender']"));
        genderRadioButton.click();

        WebElement dateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirth.sendKeys(faker.numerify("12") + "/" + faker.numerify("04") + "/" +
                faker.numerify("1995"));

        Select selectDepartment = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        selectDepartment.selectByIndex(1);

        Select selectJobTitle = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        selectJobTitle.selectByIndex(3);

        WebElement programmingLanguage = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        programmingLanguage.click();

        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        Thread.sleep(5000); // just for show what going on :)

        Driver.closeDriver();
    }
}
