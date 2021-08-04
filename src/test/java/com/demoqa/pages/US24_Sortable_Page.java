package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US24_Sortable_Page {

    public US24_Sortable_Page(){ PageFactory.initElements(Driver.getDriver(),this); }


    @FindBy(xpath = "//h5[text()='Interactions']")
    public WebElement Interactions;

    @FindBy(xpath = "//span[.='Sortable']")
    public WebElement Sortable;

    @FindBy(xpath = "//a[@href='#']")
    public List<WebElement> Windows;

    @FindBy(xpath = "//div[@class='vertical-list-container mt-4']/div")
    public List<WebElement> Listlist;



    @FindBy(xpath = "//div[@class='grid-container mt-4']/div/div")
    public List<WebElement> GridList;

    @FindBy (id = "demo-tab-grid")
    public WebElement GridButton;

}
