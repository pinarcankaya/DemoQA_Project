package com.demoqa.tests;

import com.demoqa.pages.US26_Resizable_Page;
import com.demoqa.pages.us27_offline_droppable_page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class us27_offline {

    Actions actions = new Actions(Driver.getDriver());
    us27_offline_droppable_page droppable_page = new us27_offline_droppable_page();

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ReusableMethods.scrollTo(droppable_page.interactionsMenuCard);
        droppable_page.interactionsMenuCard.click();
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        ReusableMethods.scrollTo(droppable_page.droppableMenuLink);
        droppable_page.droppableMenuLink.click();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_UP).build().perform();


    }

    //Droppable menu linkinin tiklanabilir oldugunu dogrulayiniz

    @Test
    public void TC151() {
        Assert.assertTrue(droppable_page.droppableMenuLink.isEnabled());
    }


    //Droppable sayfasinda "Simple", "Accept" ,"Prevent Propogation","Revert Draggable" bulundugunu dogrulayiniz
    @Test
    public void TC152() {
        String arr[] = {"Simple", "Accept", "Prevent Propogation", "Revert Draggable"};
        for (int i = 0; i < droppable_page.droppableTabsList.size(); i++) {
            System.out.println(droppable_page.droppableTabsList.get(i).getText());
            Assert.assertEquals(droppable_page.droppableTabsList.get(i).getText(), arr[i]);
        }
    }


    //Simple tab i altinda "Drag me" kutusu "Drop here" kutusu uzerine suruklenip birakildiginda "Dropped!"
   // yazisinin goruntulendigini dogrulayiniz
    @Test
    public void TC153() {
        actions.dragAndDrop(droppable_page.dragMeBox,droppable_page.simpleDragHearBox).build().perform();
        String droppedText=droppable_page.droppedText.getText();
        System.out.println(droppedText);
        //Assert.assertTrue();
    }

    //Accept Tab'inin altinda "Acceptable" kutusu suruklendiginde "Drop here" kutusunun yesil renk aldigini dogrulayiniz
    @Test
    public void TC154() {
        droppable_page.droppableTabsList.get(1).click();

        actions.clickAndHold(droppable_page.acceptableBox).moveToElement(droppable_page.acceptDropHearBox).build().perform();
        String dropBoxcolor=ReusableMethods.getHexColor(droppable_page.acceptDropHearBox,"background-color");
        System.out.println(dropBoxcolor);
        actions.release().build().perform();
        Assert.assertEquals(dropBoxcolor,"#3cb371");
    }


    //Accept Tab'inin altinda "Acceptable" kutusu suruklendiginde "Drop here" kutusunun mavi renk aldigini ve
    // "Dropped!" yazininin gozuktugunu dogrulayiniz
    @Test
    public void TC155() {
        droppable_page.droppableTabsList.get(1).click();
        actions.dragAndDrop(droppable_page.acceptableBox,droppable_page.acceptDropHearBox).build().perform();
        String dropBoxcolor=ReusableMethods.getHexColor(droppable_page.acceptDropHearBox,"background-color");
        System.out.println(dropBoxcolor);
        Assert.assertEquals(dropBoxcolor,"#4682b4");

    }


    //Accept Tab'inin altinda "Not Acceptable" kutucugu suruklendiginde "Drop Here" kutusunun renk degistirmedigini dogrulayiniz
    @Test
    public void TC156() {
        droppable_page.droppableTabsList.get(1).click();
        ReusableMethods.waitFor(1);
        String dropBoxcolorAfter=droppable_page.acceptDropHearBox.getCssValue("background-color");
        System.out.println(dropBoxcolorAfter);
        actions.dragAndDrop(droppable_page.notAcceptableBox,droppable_page.acceptDropHearBox).build().perform();
        ReusableMethods.waitFor(1);
        String dropBoxcolorBefore=droppable_page.acceptDropHearBox.getCssValue("background-color");
        System.out.println(dropBoxcolorBefore);
    }


    //Prevent Propogation Tab'inin altinda "Drag me" kutucugunu ustteki  "Outer droppable" kutucuguna getirdiginizde
    // kutunun acik yesil oldugunu ve " Inner droppable(not greedy)" kutucugunun koyu yesil oldugunu dogrulayinuz
    @Test
    public void TC157() {
        droppable_page.droppableTabsList.get(2).click();
        actions.clickAndHold(droppable_page.preventDrogMeBox).moveToElement(droppable_page.outerDroppableText).build().perform();
        ReusableMethods.waitFor(1);
        String dropBoxcolorOutter = ReusableMethods.getHexColor(droppable_page.outerDroppable, "background-color");
        System.out.println(dropBoxcolorOutter);

        Assert.assertEquals(dropBoxcolorOutter,"#8fbc8f");
        ReusableMethods.waitFor(1);
        String dropBoxcolorInner = ReusableMethods.getHexColor(droppable_page.innerDroppable, "background-color");
        System.out.println(dropBoxcolorInner);
        Assert.assertEquals(dropBoxcolorInner,"#3cb371");


        actions.release().build().perform();



    }
    //Prevent Propogation Tab'i altindaki "Drag me" kutucugunu ustteki "Inner droppable (not greedy)" kutucuguna
    // getirdiginizde ic kutu olan "inner droppable(not greedy)" kutucugunun ve onun dis cevresindeki outer droppable
    // kutucugunun da ayni renkte oldugunu dogrulayiniz
    @Test
    public void TC158() {
        droppable_page.droppableTabsList.get(2).click();
        actions.dragAndDrop(droppable_page.preventDrogMeBox,droppable_page.innerDroppable).build().perform();

        String dropBoxcolorInner = ReusableMethods.getHexColor(droppable_page.innerDroppable, "background-color");
        System.out.println(dropBoxcolorInner);

        String dropBoxcolorOutter = ReusableMethods.getHexColor(droppable_page.outerDroppable, "background-color");
        System.out.println(dropBoxcolorOutter);

        Assert.assertEquals(dropBoxcolorInner,dropBoxcolorOutter);
    }


    //Revert Draggable Tab'i altinda "Will Revert" kutucugunun "Drop here" kutusuna birakildiginda tekrar eski yerine
    // geldigini dogrulayiniz
    @Test
    public void TC159() {
        droppable_page.droppableTabsList.get(3).click();
        Point after=droppable_page.willRevertBox.getLocation();
        System.out.println(after);
        actions.dragAndDrop(droppable_page.willRevertBox,droppable_page.revertDropHereBox).build().perform();
        ReusableMethods.waitFor(2);
        Point before=droppable_page.willRevertBox.getLocation();
        System.out.println(before);
        Assert.assertEquals(after,before);
    }


    //Revert Draggable Tab'i altinda "Not Revert" kutucugunun "Drop here" kutusuna birakildiginda tekrar eski yerine
    // gelmedigini  dogrulayiniz
    @Test
    public void TC160() {
        droppable_page.droppableTabsList.get(3).click();
        Point after=droppable_page.notRevertBox.getLocation();
        System.out.println(after);
        ReusableMethods.waitFor(1);
        actions.dragAndDrop(droppable_page.notRevertBox,droppable_page.revertDropHereBox).build().perform();
        ReusableMethods.waitFor(2);
        Point before=droppable_page.notRevertBox.getLocation();
        System.out.println(before);
        Assert.assertNotEquals(after,before);
    }
}
