package com.optiim.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//input[@type='text'][1]")
    public WebElement searchBar;

    @FindBy(xpath = "//i[@class='cyrzo7gC']")
    public WebElement searchButton;

    @FindBy(xpath = "//div[text()='Akıllı Saat']")
    public WebElement akıllıSaatLink;

    @FindBy(xpath = "//h1")
    public WebElement searchResultElement;
    @FindBy(xpath = "//div[@class='p-card-wrppr with-campaign-view']")
    public List<WebElement> productListContent;

    @FindBy(xpath = "//button[@class='fv']")
    public WebElement favoriButonu;

    @FindBy(xpath = "//p[.='Favorilerim']")
    public WebElement favorilerimButonu;




}
