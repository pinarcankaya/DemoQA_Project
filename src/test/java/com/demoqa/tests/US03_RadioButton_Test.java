package com.demoqa.tests;

import com.demoqa.pages.US03_RadioButton_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US03_RadioButton_Test {

    US03_RadioButton_Page us03_radioButton_page = new US03_RadioButton_Page();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        us03_radioButton_page.elementsCard.click();
    }

    //Radio Button'un Element Butonu'nun altinda oldugunu verify edin!
    @Test
    public void TC0301() {
        List<String> elements = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            System.out.println(us03_radioButton_page.elementsMenuList.get(i).getText());
            elements.add(us03_radioButton_page.elementsMenuList.get(i).getText());

        }
        Assert.assertTrue(elements.contains("Radio Button"));

    }

    //"Radio Button"  yazisinin gorundugunu dogrulayin
    @Test
    public void TC0302() {
        us03_radioButton_page.radioButtonMenu.click();
        System.out.println(us03_radioButton_page.radioButtonMenu.getText());
        Assert.assertTrue(us03_radioButton_page.radioButtonMenu.isDisplayed());

    }

    //Tum Radio Buttonlarin  islevsel oldugunu test edin! //No button tiklanamiyor olmali
    @Test
    public void TC0303() {
        us03_radioButton_page.radioButtonMenu.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us03_radioButton_page.allRadioButton.get(0).isEnabled());
        Assert.assertTrue(us03_radioButton_page.allRadioButton.get(1).isEnabled());
        ReusableMethods.waitFor(1);
        Assert.assertFalse(us03_radioButton_page.allRadioButton.get(2).isEnabled());

    }

    // Yes, Impressive, No radio butonlarinin sirasiyla bulundugunu test edin!
    @Test
    public void TC0304() {
        us03_radioButton_page.radioButtonMenu.click();
        ReusableMethods.waitFor(2);

        String [] radioArr = {"Yes","Impressive","No"};///expected

        for (int i = 0; i <us03_radioButton_page.allRadioButton.size() ; i++) {
            System.out.println(us03_radioButton_page.allRadioButton.get(i).getText());
            Assert.assertEquals(us03_radioButton_page.allRadioButton.get(i).getText(),radioArr[i]);
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

    //Secilen radio butonu ile ilgili cikan text'i isDisplay kullanarak dogrulayin!
    @Test
    public void TC0405() {
        us03_radioButton_page.radioButtonMenu.click();
        for (WebElement w : us03_radioButton_page.yesImpressButtons) {
            actions.click(w).perform();
            Assert.assertTrue(w.isDisplayed());
            System.out.println("Secilen radio button :" + us03_radioButton_page.buttonSuccesText.getText());
        }
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

}