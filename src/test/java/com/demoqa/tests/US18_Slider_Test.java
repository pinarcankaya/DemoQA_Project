package com.demoqa.tests;

import com.demoqa.pages.US18_Slider_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US18_Slider_Test {
    US18_Slider_Page sliderPage = new US18_Slider_Page();
    Actions action = new Actions(Driver.getDriver());

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        ReusableMethods.scrollTo(sliderPage.widgetMenuCard);
        sliderPage.widgetMenuCard.click();
        ReusableMethods.waitForVisibility(sliderPage.sliderMenuLink, 5);
        ReusableMethods.scrollTo(sliderPage.sliderMenuLink);
        sliderPage.sliderMenuLink.click();

    }

    //slide.ın sola kaydırılabildiğini assert edin
    @Test
    public void TC91() {
        ReusableMethods.scrollTo(sliderPage.sliderButton);
        ReusableMethods.waitFor(2);
    }
}
