package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US25_Selectable_Page {

    public US25_Selectable_Page() {

        PageFactory.initElements(Driver.getDriver(), this);}


    @FindBy(xpath = "//div[@class='card mt-4 top-card']")
    public List<WebElement> interactionsLinkList;

    @FindBy(xpath = "//span[.='Selectable']")
    public WebElement selecTableLink;

    @FindBy(xpath = "(//div[.='Interactions'])[1]")
    public WebElement interactionMainHeader;

    @FindBy(xpath = "//a[@role='tab']")
    public List<WebElement> listGridTab;

    @FindBy(xpath = "//li[@class='mt-2 list-group-item active list-group-item-action']")
    public List<WebElement> listTabAdlarList;

    @FindBy(xpath = "//li[@class='list-group-item list-group-item-action']")
    public List<WebElement> siraliSayiKutucuklariList ;









}
