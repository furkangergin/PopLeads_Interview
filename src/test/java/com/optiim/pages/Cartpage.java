package com.optiim.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cartpage extends BasePage{

    @FindBy(xpath = "//span[.='Sepete Ekle']")
    public WebElement sepeteEkleButonu;

    @FindBy(xpath = "//div[@class='basket-button button-success pointer-event-none ']")
    public WebElement sepeteEklendiPopup;

    @FindBy(xpath = "//p[.='Sepetim']")
    public WebElement sepetimButton;

    @FindBy(xpath = "//button[.='Anladım']")
    public WebElement anladımButton;

    @FindBy(xpath = "//div[@class='pb-header']")
    public WebElement sepetimSayfaTitle;

    @FindBy(xpath = "//i[@class='i-trash']")
    public WebElement sepettenKaldirButton;

    @FindBy(xpath = "(//div[.='Sepetim (0 Ürün)'])[2]")
    public WebElement sepetimSıfırÜrün;
}
