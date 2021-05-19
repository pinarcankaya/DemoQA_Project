package com.demoqa.tests;


import com.demoqa.utilities.Driver;
import org.testng.annotations.Test;

public class US01_TextBox_Test {

    @Test
    public void TC01() {
        Driver.getDriver().get("demoqa_url");
        Driver.getDriver().manage().window().maximize();
    }
}