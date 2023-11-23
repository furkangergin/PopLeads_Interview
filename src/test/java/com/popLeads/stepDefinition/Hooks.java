package com.popLeads.stepDefinition;


import com.popLeads.utilities.DriverFactory;
import com.popLeads.utilities.ExcelHelper;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void sentResult(Scenario scenario) {
        String result = scenario.getStatus().name();
        System.out.println("result = " + result);
        ExcelHelper.writeExcel(scenario.getName() + " " + result + " olarak sonuçlandı.");
         //DriverFactory.closeDriver();
    }

    @After
    public void tearDownScenario(Scenario scenario) {
        //scenario.isFailed()---> if scenario fails this method will return TRUE boolean value
        // System.out.println("====Closing browser using cucumber @After");
        // System.out.println("====Scenario ended/Take screenshot if failed!");
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        //DriverFactory.closeDriver();
    }
}
