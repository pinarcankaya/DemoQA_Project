package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US015_Accordian_Page {

    public US015_Accordian_Page(){ PageFactory.initElements(Driver.getDriver(), this);}


        @FindBy(xpath = "(//div[@class='header-wrapper'])[4]")
        public WebElement widgetsButton;

        @FindBy(xpath = "//span[.='Accordian']")
        public WebElement accordianButton;

        @FindBy(xpath = "//div[@class='pattern-backgound playgound-header']")
         public WebElement mainHeader;

        @FindBy(xpath = "(//div[@class='card-header'])")
        public List<WebElement> cardList;

        @FindBy(xpath = "//p")
        public List<WebElement> paragraf;

        @FindBy(xpath = "//*[@id=\"accordianContainer\"]/div/div[1]/div[2]")
         public WebElement collapse1;

        @FindBy(xpath = "//*[@id=\"accordianContainer\"]/div/div[2]/div[2]")
        public WebElement collapse2;


//*[@id="accordianContainer"]/div/div[1]/div[2]

    }
