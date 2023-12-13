package com.popLeads.pages;

import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopLeads extends BasePage {

    @FindBy(xpath = "//a[.='Sign In']")
    public WebElement buttonSignIn;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[.='Sign In']")
    public WebElement signIn;


























}
