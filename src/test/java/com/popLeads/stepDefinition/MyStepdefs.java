package com.popLeads.stepDefinition;

import com.github.javafaker.Faker;
import com.popLeads.pages.PopLeads;
import com.popLeads.utilities.DriverFactory;
import com.popLeads.utilities.ReadProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class MyStepdefs {

    WebDriver driver = DriverFactory.getDriver();
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    Faker faker = new Faker();
    PopLeads popLeads = new PopLeads();



    @Given("User go to the {string}")
    public void userGoToThe(String url) {
        driver.get(ReadProperties.getProperty("testURL"));
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

    @When("User click to sign in button.")
    public void userClickToSignInButton() {
        wait.until(ExpectedConditions.visibilityOf(popLeads.buttonSignIn));
        popLeads.buttonSignIn.click();
    }

    @And("User enter the email randomly.")
    public void userEnterTheEmailRandomly() {
        popLeads.username.sendKeys(faker.name().username());
        
    }

    @And("User enter the password randomly.")
    public void userEnterThePasswordRandomly() {
        popLeads.password.sendKeys(faker.name().username());
    }

    @And("User click sign in button.")
    public void userClickSignInButton() {
        popLeads.signIn.click();
    }

    @Then("The sign in button remove top the menu")
    public void theSignInButtonRemoveTopTheMenu() {
       Assert.assertTrue(!popLeads.buttonSignIn.isDisplayed());
    }

    @When("User selects one of the nine courses main page")
    public void  userSelectsOneOfTheNineCoursesMainPage() {
        List<WebElement> courses = driver.findElements(By.xpath("//div[@class='sc-18ecabe2-0 sc-8c9258ce-0 ctHEtz dCanNT']/a"));
        Random r = new Random();
        int randomValue = r.nextInt(courses.size()); //Getting a random value that is between 0 and (list's size)-1
        courses.get(randomValue).click();


    }

}


