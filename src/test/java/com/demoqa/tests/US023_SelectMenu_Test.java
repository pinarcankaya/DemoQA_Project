package com.demoqa.tests;
import com.demoqa.pages.US023_SelectMenu_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US023_SelectMenu_Test {
    public US023_SelectMenu_Page us023SelectMenuPage;
    Actions action=new Actions(Driver.getDriver());
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),15);
    Select select;
    JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();




    @Test (priority = 1)
    public void setup() throws InterruptedException {
    Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    Driver.getDriver().manage().window().maximize();
    Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    us023SelectMenuPage =new US023_SelectMenu_Page();



    us023SelectMenuPage.Widgets.click();

    Thread.sleep(500);
    //scrolling down
    jse.executeScript("window.scrollBy(0,300)");
    wait.until(ExpectedConditions.elementToBeClickable(us023SelectMenuPage.SelectMenu));
    ReusableMethods.clickWithJS(us023SelectMenuPage.SelectMenu);




}
    @Test(priority = 2, dependsOnMethods = "setup")
    //- Sayfanın başlığı "Select Menu" olmalıdir.

    public void US023128(){
    Assert.assertEquals(us023SelectMenuPage.mainheader.getText(),"Select Menu");
    System.out.println(us023SelectMenuPage.mainheader.getText());

    }

    @Test (priority = 3, dependsOnMethods = "setup")
    //-Sayfada ilk olarak "Select Value" adi altinda "Select Option" adli box icinde Dropdown menu tiklandiginda acilmalidir
    public void US023129(){
    
        Assert.assertEquals(us023SelectMenuPage.SelectDropDownBoxes.get(1).getText(),"Select Value");
        // System.out.println(us023SelectMenuPage.SelectDropDownBoxes.get(1).getText());
        Assert.assertEquals(us023SelectMenuPage.SelectDropDownBoxes.get(2).getText(),"Select Option");
        // System.out.println(us023SelectMenuPage.SelectDropDownBoxes.get(2).getText());


        us023SelectMenuPage.SelectDropDownBoxes.get(2).click();
        for (int i = 0; i < us023SelectMenuPage.SelectOption.size(); i++) {
            String expectedResult=us023SelectMenuPage.SelectOption.get(i).getText();
            System.out.println(i+1 + " expectedResult = " + expectedResult);
            us023SelectMenuPage.SelectOption.get(i).click();
            String actualResult= us023SelectMenuPage.SelectDropDownBoxes.get(2).getText();
            System.out.println("actualResult = " + actualResult);
            Assert.assertTrue(actualResult.contains(expectedResult));
            us023SelectMenuPage.SelectDropDownBoxes.get(2).click();
        }



    }

    @Test (priority = 4, dependsOnMethods = "setup")
    //-Sayfada ikinci olarak "Select One" adi altinda "Select Title" adli box icinde Dropdown menu tiklandiginda acilmalidir
    public void US023130 (){


        Assert.assertEquals(us023SelectMenuPage.SelectDropDownBoxes.get(3).getText(),"Select One");
        //System.out.println(us023SelectMenuPage.SelectDropDownBoxes.get(3).getText());

        Assert.assertEquals(us023SelectMenuPage.SelectDropDownBoxes.get(4).getText(),"Select Title");
        //System.out.println(us023SelectMenuPage.SelectDropDownBoxes.get(4).getText());

        wait.until(ExpectedConditions.elementToBeClickable(us023SelectMenuPage.SelectDropDownBoxes.get(4)));
        action.click(us023SelectMenuPage.SelectDropDownBoxes.get(4)).build().perform();
        jse.executeScript("window.scrollBy(0,175)");

        for (int i = 0; i < us023SelectMenuPage.SelectOption.size(); i++) {
            String expectedResult=us023SelectMenuPage.SelectOption.get(i).getText();
            System.out.println(i+1 + " expectedResult = " + expectedResult);
            us023SelectMenuPage.SelectOption.get(i).click();

            String actualResult= us023SelectMenuPage.SelectDropDownBoxes.get(4).getText();
            System.out.println("actualResult = " + actualResult);
            Assert.assertTrue(actualResult.contains(expectedResult));
            us023SelectMenuPage.SelectDropDownBoxes.get(4).click();
        }


    }

    @Test (priority = 5, dependsOnMethods = "setup")
    //-Sayfada ucuncu olarak "Old Style Select Menu" adi altinda "Red" adli box icinde Dropdown menu tiklandiginda acilmalidir

    public void TC023131 (){
        Assert.assertEquals(us023SelectMenuPage.SelectDropDownBoxes.get(5).getText(),"Old Style Select Menu");
        System.out.println(us023SelectMenuPage.SelectDropDownBoxes.get(5).getText());
        select=new Select(us023SelectMenuPage.oldSelectMenu);


        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Red");
        System.out.println(select.getFirstSelectedOption().getText());

        for (WebElement selectMenu : select.getOptions()) {
            us023SelectMenuPage.oldSelectMenu.click();
            String toBeSelected=selectMenu.getText();
            //System.out.println(selectMenu.getText());
            selectMenu.click();
            System.out.println(select.getFirstSelectedOption().getText());
            Assert.assertEquals(toBeSelected, select.getFirstSelectedOption().getText());

        }


    }

    @Test (priority = 6, dependsOnMethods = "setup")
    //-Sayfada dorduncu olarak "Multiselect drop down" adi altinda "Select..." adli box icinde Dropdown menu
    // tiklandiginda  acilmalidir ve takibinde menudeki secenekler secilebilmelidir.

    public void US023132() {

        Assert.assertTrue(us023SelectMenuPage.SelectDropDownBoxes.get(7).getText().contains("Multiselect drop down"));
        //System.out.println(us023SelectMenuPage.SelectDropDownBoxes.get(7).getText());


        WebElement selectBox =us023SelectMenuPage.multiSelectDropDownBox;


        selectBox.click();

        List <String> optionsText=new ArrayList<>();
        for (int i = 0; i <us023SelectMenuPage.SelectOption.size() ; i++) {
            optionsText.add(us023SelectMenuPage.SelectOption.get(i).getText()); }

        for (WebElement option:us023SelectMenuPage.SelectOption) {option.click(); }

        for (String s : optionsText) {
            Assert.assertTrue(us023SelectMenuPage.selectOptionBox.getText().contains(s));
            System.out.println(us023SelectMenuPage.selectOptionBox.getText());
            System.out.println("********************************");
            System.out.println(s);
        }

    }

    @Test (priority = 7, dependsOnMethods = "setup")
    //-Sayfada son olarak "Standard multi select" adi altinda alt alta "Volvo", "Saab","Opel" ve "Audi" secenekleri bulunmali
    //ve secenekler secilebilmelidir.
    
    public void US023133(){
        WebElement standartMultiSelect=us023SelectMenuPage.SelectDropDownBoxes.get(8);
        Assert.assertTrue(standartMultiSelect.getText().contains("Standard multi select\n"+ "Volvo\n" +"Saab\n" + "Opel\n" +"Audi"));

        select= new Select(us023SelectMenuPage.cars);
        for (WebElement car: select.getOptions()) {
            car.click();
            //String carSelected=car.getText();
            //System.out.println("carSelected = " + carSelected);
            Assert.assertTrue(car.isSelected());
        }
    }

    @Test (priority = 8, dependsOnMethods = "setup")
    //-"Multiselect drop down" ve "Standard multi select" basliklari bold olmalidir.

    public void US023134 (){

    Assert.assertEquals(us023SelectMenuPage.multiSelectDropDown.getCssValue("font-weight"),"700");
    Assert.assertEquals(us023SelectMenuPage.standartMultiSelect.getCssValue("font-weight"),"700");


    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
        Driver.closeDriver();
}
}




