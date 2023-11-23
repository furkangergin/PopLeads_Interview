package com.popLeads.stepDefinition;

import com.github.javafaker.Faker;
import com.popLeads.pages.PopLeads;
import com.popLeads.utilities.DriverFactory;
import com.popLeads.utilities.ExcelHelper;
import com.popLeads.utilities.ReadProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;

import static org.junit.Assert.assertTrue;

public class PopLeadsStepImpl {

    private static final Logger LOG = LogManager.getLogger(PopLeadsStepImpl.class);

    WebDriver driver = DriverFactory.getDriver();
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    Faker faker = new Faker();
    PopLeads popLeads = new PopLeads();

}