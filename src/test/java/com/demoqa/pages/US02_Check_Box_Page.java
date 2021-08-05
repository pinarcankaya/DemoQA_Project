package com.demoqa.pages;



import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class US02_Check_Box_Page {

    public US02_Check_Box_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='card-up']")
    public WebElement elementsCard;

    @FindBy(id="item-1")
    public WebElement checkBoxKutu;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement checkBoxBaslik;

    @FindBy(xpath = "//button[@title='Expand all']")
    public WebElement artiButton;

    @FindBy(xpath = "//span[@class='text-success']")
    public WebElement text;

}
