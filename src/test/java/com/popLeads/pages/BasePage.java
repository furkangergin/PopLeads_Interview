package com.popLeads.pages;

import com.popLeads.utilities.DriverFactory;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(DriverFactory.getDriver(),this);
    }
}
