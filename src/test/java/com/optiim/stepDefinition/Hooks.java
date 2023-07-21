package com.optiim.stepDefinition;


import com.optiim.utilities.DriverFactory;
import com.optiim.utilities.ExcelHelper;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

 @After
    public void sentResult (Scenario scenario){
     String result = scenario.getStatus().name();
     System.out.println("result = " + result);
     ExcelHelper.writeExcel(scenario.getName() + " " + result + " olarak sonuçlandı.");
     DriverFactory.closeDriver();
 }



}
