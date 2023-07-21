package com.optiim.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{


    @FindBy(xpath = "//p[.='Giriş Yap']")
    public WebElement girisYapButton;

   @FindBy(xpath = "//input[@id='login-email']")
    public WebElement emailInputBox;

    @FindBy(xpath = "//input[@name='login-password']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[@class='q-primary q-fluid q-button-medium q-button submit']")
    public WebElement loginPageGirisYapButton;



}
