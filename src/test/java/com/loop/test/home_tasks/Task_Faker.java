package com.loop.test.home_tasks;

import com.github.javafaker.Faker;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

public class Task_Faker {
    /*

go to url: https://loopcamp.vercel.app/registration_form.html
fill the form
use faker*/




        @Test


        public void registrationForm() {
            Driver.getDriver().get(ConfigurationReader.getProperty("loopcamp"));
            Faker faker = new Faker();
            Object name = faker.name();


            System.out.println(name);

            WebElement firstName = Driver.getDriver().findElement(By.cssSelector(getFieldLocator("firstname")));
            setValue(firstName, faker.name().firstName());

            WebElement lastName = Driver.getDriver().findElement(By.cssSelector(getFieldLocator("lastname")));
            setValue(lastName, faker.name().lastName());

            WebElement userName = Driver.getDriver().findElement(By.cssSelector(getFieldLocator("username")));
            setValue(userName, faker.letterify("??????????"));

            WebElement email = Driver.getDriver().findElement(By.cssSelector(getFieldLocator("email")));
            setValue(email, faker.internet().emailAddress());

            WebElement password = Driver.getDriver().findElement(By.cssSelector(getFieldLocator("password")));
            setValue(password, faker.internet().password());

            WebElement phone = Driver.getDriver().findElement(By.cssSelector(getFieldLocator("phone")));
            setValue(phone, faker.numerify("###-###-####"));

            WebElement gender = Driver.getDriver().findElement(By.cssSelector(getCheckboxLocator("gender", "male")));
            clickOnElement(gender);
            WebElement dateOfBirth = Driver.getDriver().findElement(By.cssSelector(getFieldLocator("birthday")));
            SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
            setValue(dateOfBirth, date.format(faker.date().birthday()));

            WebElement department = Driver.getDriver().findElement(By.cssSelector(getFieldLocator("department")));
            selectRandomOptionFromDropDown(department);

            WebElement jobTitle = Driver.getDriver().findElement(By.cssSelector(getFieldLocator("job_title")));
            selectRandomOptionFromDropDown(jobTitle);

            WebElement programLanguage = Driver.getDriver().findElement(By.cssSelector(getCheckboxLocator("programming_language", "java")));
            clickOnElement(programLanguage);

            WebElement signUpButton = Driver.getDriver().findElement(By.cssSelector("#wooden_spoon"));
            clickOnElement(signUpButton);


        }

        public static String getFieldLocator(String fieldName) {
            return "[name='" + fieldName + "']";
        }

        public static String getCheckboxLocator(String fieldName, String valueName) {
            String baseLocator = getFieldLocator(fieldName);
            return baseLocator + "[value='" + valueName + "']";
        }

        public static void setValue(WebElement element, String value) {

            element.sendKeys(value);

        }

        public static void selectRandomOptionFromDropDown(WebElement element) {

            Select select = new Select(element);
            List<WebElement> options = select.getOptions();
            int randomIndex = new Random().nextInt(options.size());
            select.selectByIndex(randomIndex);
        }

        public static void clickOnElement(WebElement element) {

            element.click();

        }
    }

