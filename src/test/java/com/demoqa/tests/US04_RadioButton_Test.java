package com.demoqa.tests;

import com.demoqa.pages.US04_RadioButton_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US04_RadioButton_Test {

    US04_RadioButton_Page radioButtonPage = new US04_RadioButton_Page();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        radioButtonPage.elementsCard.click();
    }

    //Radio Button'un Element Butonu'nun altinda oldugunu verify edin!
    @Test
    public void TC0401() {
        radioButtonPage.radioButtonMenu.click();

        List<String> elements = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            System.out.println(radioButtonPage.elementsMenuList.get(i).getText());
           elements.add(radioButtonPage.elementsMenuList.get(i).getText());

        }
        Assert.assertTrue(elements.contains("Radio Button"));

    }

    //"Radio Button"  yazisinin gorundugunu dogrulayin
    @Test
    public void TC0402() {
        radioButtonPage.radioButtonMenu.click();
        System.out.println(radioButtonPage.radioButtonMenu.getText());
        Assert.assertTrue(radioButtonPage.radioButtonMenu.isDisplayed());

    }

    //Tum Radio Buttonlarin  islevsel oldugunu test edin! //No button tiklanamiyor olmali
    @Test
    public void TC0403() {
        radioButtonPage.radioButtonMenu.click();
        Assert.assertTrue(radioButtonPage.allRadioButton.get(0).isEnabled());
        Assert.assertTrue(radioButtonPage.allRadioButton.get(1).isEnabled());
        Assert.assertFalse(radioButtonPage.allRadioButton.get(2).isEnabled());

    }

    // Yes, Impressive, No radio butonlarinin sirasiyla bulundugunu test edin!
    @Test
    public void TC0404() {
        radioButtonPage.radioButtonMenu.click();
        ReusableMethods.waitFor(2);
        List<String> radioArr=new ArrayList<>();
        radioArr.add("Yes");
        radioArr.add("Impressive");
        radioArr.add("No");


        for (String w:radioArr){
            System.out.println(w);
        }

        for (int i = 0; i <3; i++) {
            for (int j = 0; j <3 ; j++) {
                Assert.assertEquals(radioButtonPage.allRadioButton.get(i).getText(),radioArr.get(j));
            }
        }


    }


    //Secilen radio butonu ile ilgili cikan text'i isDisplay kullanarak dogrulayin!
    @Test
    public void TC0405() {
        radioButtonPage.radioButtonMenu.click();
        for (WebElement w:radioButtonPage.yesNoButtons){
           actions.click(w).build().perform();
            Assert.assertTrue(w.isDisplayed());
            System.out.println("Secilen radio button :" + radioButtonPage.buttonSuccesText.getText());
        }

    }

}
