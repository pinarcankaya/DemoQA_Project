package com.demoqa.tests;

import com.demoqa.pages.US01_TextBox_Page;
import com.demoqa.pages.US03_RadioButton_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US03_RadioButton_Test {

    US01_TextBox_Page us01TextBoxPage = new US01_TextBox_Page();
    US03_RadioButton_Page us03_radioButton_page = new US03_RadioButton_Page();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        us01TextBoxPage.elementsCard.click();
    }

    @Test
    public void TC0301() {
        List<String> elements = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            elements.add(us03_radioButton_page.elementsMenuList.get(i).getText());
        }
        Assert.assertTrue(elements.contains("Radio Button"));
    }

    @Test
    public void TC0302() {
        us03_radioButton_page.radioButtonMenu.click();
        Assert.assertTrue(us03_radioButton_page.radioButtonMenu.isDisplayed());

    }

    @Test
    public void TC0303() {
        us03_radioButton_page.radioButtonMenu.click();
        Assert.assertTrue(us03_radioButton_page.allRadioButton.get(0).isEnabled());
        Assert.assertTrue(us03_radioButton_page.allRadioButton.get(1).isEnabled());
        Assert.assertFalse(us03_radioButton_page.allRadioButton.get(2).isEnabled());

    }

    @Test
    public void TC0304() {
        us03_radioButton_page.radioButtonMenu.click();
        String[] radioArr = {"Yes", "Impressive", "No"};///expected

        for (int i = 0; i < us03_radioButton_page.allRadioButtonsText.size(); i++) {

            Assert.assertEquals(us03_radioButton_page.allRadioButtonsText.get(i).getText(), radioArr[i]);
        }

        //2.yol****Siralama dikkate alinmadan

//        List<String> radioList=new ArrayList<>();
//        radioList.add("Yes");
//        radioList.add("Impressive");
//        radioList.add("No");
//
//        for (int i = 0; i <radioList.size() ; i++) {
//           radioList.contains(us03_radioButton_page.allRadioButton.get(i).getText());
//        }


    }

    @Test
    public void TC0405() {
        us03_radioButton_page.radioButtonMenu.click();
        for (WebElement w : us03_radioButton_page.yesImpressiveButtons) {
            actions.click(w).perform();
            Assert.assertTrue(w.isDisplayed());
            System.out.println("Secilen radio button :" + us03_radioButton_page.buttonSuccesText.getText());
        }
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @AfterClass
    public void close() {
        Driver.closeDriver();
    }

}