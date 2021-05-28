package com.demoqa.tests;


import com.demoqa.pages.CSS_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CSS_Calisma {

    CSS_Page cssPage = new CSS_Page();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        cssPage.elementsCard.click();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        cssPage.webtableMenuLink.click();
    }

    @Test
    public void BorderColor() {
        cssPage.addButton.click();
        cssPage.firstNameTextBox.sendKeys("A");
        cssPage.submitButton.click();
        ReusableMethods.waitFor(2);

        String firstnamebordercolor = cssPage.firstNameTextBox.getCssValue("border-color");
        System.out.println(firstnamebordercolor);

        ReusableMethods.waitFor(2);

        String hexColor = Color.fromString(firstnamebordercolor).asHex();  //hex co renk icin
        System.out.println(hexColor);

        Assert.assertEquals(firstnamebordercolor, "rgb(40, 167, 69)");
        Assert.assertEquals(hexColor,"#28a745");


        String lastnamebordercolor = cssPage.lastNameTextBox.getCssValue("border-color");
        System.out.println(lastnamebordercolor);

       //ReusableMethods.waitFor(2);

        String hexColorLastName = Color.fromString(firstnamebordercolor).asHex();  //hex co renk icin
        System.out.println(hexColorLastName);


        String font=cssPage.webtableMenuLink.getCssValue("font-size");
        System.out.println(font);
    }


}