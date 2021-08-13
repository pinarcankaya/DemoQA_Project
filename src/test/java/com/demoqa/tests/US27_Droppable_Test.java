package com.demoqa.tests;

import com.demoqa.pages.US27_Droppable_Page;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US27_Droppable_Test {
    
    US27_Droppable_Page droppablePage=new US27_Droppable_Page();
    Actions action=new Actions(Driver.getDriver());
    String url="https://demoqa.com";

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(url);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ReusableMethods.waitFor(3);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.clickWithJS(droppablePage.interactions);

        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.clickWithJS(droppablePage.droppableButton);

    }
    @Test  //Droppable menu linkinin tiklanabilir oldugunu dogrulayiniz
    public void TC151() {
        Assert.assertTrue(droppablePage.droppableButton.isEnabled());
    }

    @Test  //Droppable sayfasinda "Simple", "Accept" ,"Prevent Propogation","Revert Draggable" bulundugunu dogrulayiniz
    public void TC152() {
        String []expectedTabs={"Simple", "Accept" ,"Prevent Propogation","Revert Draggable"};
        List<Object> actuallyTabsList=new ArrayList<>();
        for (WebElement w:droppablePage.tabs) {
          actuallyTabsList.add(w.getText());
        }
        for (String e:expectedTabs) {
            Assert.assertTrue(actuallyTabsList.contains(e));
        }
        System.out.println(actuallyTabsList);
    }

    @Test  //Simple tab i altinda "Drag me" kutusu "Drop here" kutusu uzerine suruklenip birakildiginda
    // "Dropped!" yazisinin goruntulendigini dogrulayiniz
    public void TC153() {
        action.dragAndDrop(droppablePage.smallBoxs.get(0),droppablePage.bigBoxs.get(0)).perform();
        ReusableMethods.waitFor(2);
        String actuallyText=droppablePage.pText.get(0).getText();

        Assert.assertEquals(actuallyText,"Dropped!");
        System.out.println(actuallyText);

    }

    @Test  //Accept Tab'inin altinda "Acceptable" kutusu suruklendiginde "Drop here" kutusunun
    // yesil renk (#3cb371) aldigini dogrulayiniz
    public void TC154() {
        droppablePage.tabs.get(1).click();
        action.clickAndHold(droppablePage.smallBoxs.get(1)).moveToElement(droppablePage.bigBoxs.get(1)).build().perform();
        ReusableMethods.waitFor(2);
        String background=droppablePage.bigBoxs.get(1).getCssValue("background-color");
        String hexBackground=Color.fromString(background).asHex();

        Assert.assertEquals(hexBackground,"#3cb371");
        System.out.println(background+"\n"+hexBackground);


    }

    @Test  //Accept Tab'inin altinda "Acceptable" kutusu suruklendiginde "Drop here" kutusunun mavi renk (#4682b4)aldigini ve
    // "Dropped!" yazininin gozuktugunu dogrulayiniz
    public void TC155() {
        droppablePage.tabs.get(1).click();
        action.dragAndDrop(droppablePage.smallBoxs.get(1),droppablePage.bigBoxs.get(1)).perform();
        String background=droppablePage.bigBoxs.get(1).getCssValue("background-color");
        String hexBackground= Color.fromString(background).asHex();

        System.out.println("Background rgb : "+background+"\n"+"Background hex : "+hexBackground);
    }

    @Test  //Accept Tab'inin altinda "Not Acceptable" kutucugu suruklendiginde "Drop Here" kutusunun
    // renk degistirmedigini dogrulayiniz
    public void TC156() {
        droppablePage.tabs.get(1).click();
        String ilkBackground=droppablePage.bigBoxs.get(1).getCssValue("background-color");
        action.clickAndHold(droppablePage.smallBoxs.get(2)).moveToElement(droppablePage.bigBoxs.get(1)).build().perform();
        ReusableMethods.waitFor(2);
        String sonBackground=droppablePage.bigBoxs.get(1).getCssValue("background-color");

        Assert.assertEquals(ilkBackground,sonBackground);
        System.out.println(ilkBackground+"\n"+sonBackground);
    }

    @Test  //Prevent Propogation Tab'inin altinda "Drag me" kutucugunu ustteki  "Outer droppable" kutucuguna getirdiginizde
    //  kutunun acik yesil (#8fbc8f)oldugunu ve " Inner droppable(not greedy)" kutucugunun koyu yesil(#3cb371) oldugunu dogrulayinuz
    public void TC157() {
        droppablePage.tabs.get(2).click();
        ReusableMethods.waitFor(2);
        action.clickAndHold(droppablePage.smallBoxs.get(3)).moveByOffset(220,8).perform();
        ReusableMethods.waitFor(2);
        String background1=droppablePage.outerDroppable.get(0).getCssValue("background-color");
        String hexBackground1=Color.fromString(background1).asHex();
        ReusableMethods.waitFor(5);
        String background2=droppablePage.bigBoxs.get(2).getCssValue("background-color");
        String hexBackground2=Color.fromString(background2).asHex();

        Assert.assertEquals(hexBackground1,"#8fbc8f");//Acil yesil
        Assert.assertEquals(hexBackground2,"#3cb371");//Koyu yesil

        System.out.println(background1+"\n"+background2);
        System.out.println(hexBackground1+"\n"+hexBackground2);
    }

    @Test  //Prevent Propogation Tab'i altindaki "Drag me" kutucugunu ustteki "Inner droppable (not greedy)" kutucuguna
    // getirdiginizde ic kutu olan "inner droppable(not greedy)" kutucugunun ve onun dis cevresindeki outer droppable
    // kutucugunun da ayni renkte (#8fbc8f)oldugunu dogrulayiniz
    public void TC158() {
        droppablePage.tabs.get(2).click();
        ReusableMethods.waitFor(2);
        action.clickAndHold(droppablePage.smallBoxs.get(3)).moveToElement(droppablePage.bigBoxs.get(2)).perform();
        ReusableMethods.waitFor(2);
        String background1=droppablePage.outerDroppable.get(0).getCssValue("background-color");
        String hexBackground1=Color.fromString(background1).asHex();
        ReusableMethods.waitFor(5);
        String background2=droppablePage.bigBoxs.get(2).getCssValue("background-color");
        String hexBackground2=Color.fromString(background2).asHex();

        Assert.assertEquals(hexBackground1,hexBackground2);


        System.out.println(background1+"\n"+background2);
        System.out.println(hexBackground1+"\n"+hexBackground2);
    }

    @Test  //Revert Draggable Tab'i altinda "Will Revert" kutucugunun "Drop here" kutusuna birakildiginda
    // tekrar eski yerine geldigini dogrulayiniz
    public void TC159() {
        droppablePage.tabs.get(3).click();
        Point ilkKonum=droppablePage.smallBoxs.get(4).getLocation();
        action.dragAndDrop(droppablePage.smallBoxs.get(4),droppablePage.bigBoxs.get(4)).perform();
        ReusableMethods.waitFor(2);
        Point sonKonum=droppablePage.smallBoxs.get(4).getLocation();
        Assert.assertEquals(ilkKonum,sonKonum);
        System.out.println(ilkKonum+"\n"+sonKonum);
    }

    @Test  //Revert Draggable Tab'i altinda "Not Revert" kutucugunun "Drop here" kutusuna birakildiginda
    // tekrar eski yerine gelmedigini  dogrulayiniz
    public void TC160() {
        droppablePage.tabs.get(3).click();
        Point ilkKonum=droppablePage.smallBoxs.get(5).getLocation();
        action.dragAndDrop(droppablePage.smallBoxs.get(5),droppablePage.bigBoxs.get(4)).build().perform();
        ReusableMethods.waitFor(2);
        Point sonKonum=droppablePage.smallBoxs.get(5).getLocation();

        Assert.assertNotEquals(ilkKonum,sonKonum);
        System.out.println(ilkKonum+"\n"+sonKonum);

    }

}
