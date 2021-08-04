package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US28_Draggable_Page {
    public US28_Draggable_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h5[.='Interactions']")
    public WebElement interactions;
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[5]")
    public WebElement dragableInteractions;

    @FindBy(xpath = "(//div//ul[@class='menu-list'])[5]//li")
    public List<WebElement> dragableMenuList;
    @FindBy(xpath = "//div[@id='draggableExample-tabpane-containerRestriction']/div")
    public List<WebElement> restcrictedkutulari;

    @FindBy(xpath = "(//div//ul[@class='menu-list'])[5]//li")
    public WebElement dragableMenu;


    @FindBy(xpath = "//div[@class='pattern-backgound playgound-header']") ////div[.='Menu'])[2]
    public WebElement mainHeader;


    @FindBy(xpath = "((//div//ul[@class='menu-list'])[5]//li)[5]")
    public WebElement dragable;


    @FindBy(id = "dragBox")
    public WebElement dragMe;
    @FindBy(xpath = "//a[@role='tab']")
    public List<WebElement> tabList;

    @FindBy(id = "restrictedX")
    public WebElement onlyX;

    @FindBy(id = "restrictedY")
    public WebElement onlyY;

    @FindBy(linkText = "Axis Restricted")
    public WebElement axisRestricted;
    @FindBy(linkText = "Cursor Style")
    public WebElement cursorStyle;
    @FindBy(linkText = "Container Restricted")
    public WebElement containerRestricted;
   @FindBy(xpath = "(//div[@role='tabpanel']/div)[4]/span")
    public WebElement second_ContainedWithParent;

    @FindBy(xpath = "//div[@id='containmentWrapper']/div")
    public WebElement first_ContainmentWrapper;

    @FindBy(id = "cursorCenter")
    public WebElement center;

    @FindBy(id = "cursorTopLeft")
    public WebElement left;

    @FindBy(id = "cursorBottom")
    public WebElement bottom;




}
