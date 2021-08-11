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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
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


    }

    @Test (priority = 3, dependsOnMethods = "setup")
    //-Sayfada ilk olarak "Select Value" adi altinda "Select Option" adli box icinde Dropdown menu tiklandiginda acilmalidir
    public void US023129() throws InterruptedException {

        Assert.assertEquals(us023SelectMenuPage.SelectDropDownBoxes.get(1).getText(),"Select Value");

        Assert.assertEquals(us023SelectMenuPage.SelectDropDownBoxes.get(2).getText(),"Select Option");



        us023SelectMenuPage.SelectDropDownBoxes.get(2).click();
        for (int i = 0; i < us023SelectMenuPage.SelectOption.size(); i++) {
            String expectedResult=us023SelectMenuPage.SelectOption.get(i).getText();

            us023SelectMenuPage.SelectOption.get(i).click();
            String actualResult= us023SelectMenuPage.SelectDropDownBoxes.get(2).getText();

            Assert.assertTrue(actualResult.contains(expectedResult));
            us023SelectMenuPage.SelectDropDownBoxes.get(2).click();

        }
        Driver.getDriver().navigate().refresh();


    }

    @Test (priority = 4, dependsOnMethods = "setup")
    //-Sayfada ikinci olarak "Select One" adi altinda "Select Title" adli box icinde Dropdown menu tiklandiginda acilmalidir
    public void US023130 (){

        //ReusableMethods.waitForVisibility(us023SelectMenuPage.SelectDropDownBoxes.get(4),10);
        Assert.assertEquals(us023SelectMenuPage.SelectDropDownBoxes.get(3).getText(),"Select One");


        Assert.assertEquals(us023SelectMenuPage.SelectDropDownBoxes.get(4).getText(),"Select Title");
        System.out.println("us023SelectMenuPage.SelectDropDownBoxes.get(4).getText() = " + us023SelectMenuPage.SelectDropDownBoxes.get(4).getText());

        ReusableMethods.waitForClickablility(us023SelectMenuPage.selectTitle,25);
//        for (int i = 0; i < 15; i++) {
//            try {
//                us023SelectMenuPage.selectTitle.click();
//            }catch(Exception exception){
//                System.out.println("exception = " + exception);
//            }
//        }
        us023SelectMenuPage.selectTitle.click();
        //ReusableMethods.waitFor(2);
        //action.click(us023SelectMenuPage.SelectDropDownBoxes.get(4)).build().perform();
        Driver.getDriver().navigate().refresh();

        for (int i = 0; i < us023SelectMenuPage.SelectOption.size(); i++) {
            ReusableMethods.waitForVisibility(us023SelectMenuPage.SelectOption.get(i),5);
            String expectedResult=us023SelectMenuPage.SelectOption.get(i).getText();

            ReusableMethods.waitForClickablility(us023SelectMenuPage.SelectOption.get(i),10);
            //ReusableMethods.scrollTo(us023SelectMenuPage.SelectOption.get(i));
            us023SelectMenuPage.SelectOption.get(i).click();
            ReusableMethods.waitForVisibility(us023SelectMenuPage.SelectDropDownBoxes.get(4),5);
            String actualResult= us023SelectMenuPage.SelectDropDownBoxes.get(4).getText();
            Assert.assertTrue(actualResult.contains(expectedResult));
            us023SelectMenuPage.SelectDropDownBoxes.get(4).click();
        }
        us023SelectMenuPage.SelectDropDownBoxes.get(3).click();

    }

    @Test (priority = 5, dependsOnMethods = "setup")
    //-Sayfada ucuncu olarak "Old Style Select Menu" adi altinda "Red" adli box icinde Dropdown menu tiklandiginda acilmalidir

    public void TC023131 (){
        Assert.assertEquals(us023SelectMenuPage.SelectDropDownBoxes.get(5).getText(),"Old Style Select Menu");

        select=new Select(us023SelectMenuPage.oldSelectMenu);


        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Red");
        System.out.println(select.getFirstSelectedOption().getText());

        for (WebElement selectMenu : select.getOptions()) {
            ReusableMethods.waitForClickablility(us023SelectMenuPage.oldSelectMenu,10);
            us023SelectMenuPage.oldSelectMenu.click();
            String toBeSelected=selectMenu.getText();

            selectMenu.click();

            Assert.assertEquals(toBeSelected, select.getFirstSelectedOption().getText());

        }


    }

    @Test (priority = 6, dependsOnMethods = "setup")
    //-Sayfada dorduncu olarak "Multiselect drop down" adi altinda "Select..." adli box icinde Dropdown menu
    // tiklandiginda  acilmalidir ve takibinde menudeki secenekler secilebilmelidir.

    public void US023132() {
        Driver.getDriver().navigate().refresh();
        Assert.assertTrue(us023SelectMenuPage.SelectDropDownBoxes.get(7).getText().contains("Multiselect drop down"));

        WebElement selectBox =us023SelectMenuPage.multiSelectDropDownBox;
        ReusableMethods.waitForClickablility(selectBox,10);

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

            Assert.assertTrue(car.isSelected());
        }
    }

    @Test (priority = 8, dependsOnMethods = "setup")
    //-"Multiselect drop down" ve "Standard multi select" basliklari bold olmalidir.

    public void US023134 (){

        Assert.assertEquals(us023SelectMenuPage.multiSelectDropDown.getCssValue("font-weight"),"700");
        Assert.assertEquals(us023SelectMenuPage.standartMultiSelect.getCssValue("font-weight"),"700");


    }
    @AfterClass
    public void tearDown(){Driver.closeDriver();}
}




