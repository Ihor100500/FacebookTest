package com.ui.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostHelper extends HelperBase {

    private final String POST = "[name='xhpc_message']";
    private final String CHECKBOXES = "div[role='checkbox']";
    private final String TEXTAREA = "div[data-testid='status-attachment-mentions-input']";
    private final String FEEDSTREAM = "div[data-testid='newsFeedStream']>div[role='article']";
    private final String POSTTEXT= "div[id='substream_0'] p";
    private final String NEWSPARAMS = "div[id='substream_0'] a[aria-label*='Параметры новостей']";
    private final String PARAMSMENU = "div[class='uiContextualLayerPositioner uiLayer']";
    private final String EDITOPTION = "li[data-feed-option-name='FeedEditOption']";
    private final String EDITWINDOWELEMENTS = "div[data-testid='expanded-sprout-list']";
    private final String BUTTONSHARE = "button[data-testid='react-composer-post-button']";
    private final String DELETEOPTION = "li[data-feed-option-name='FeedDeleteOption']";
    private final String DELETEBUTTON = "div[class*='uiOverlayFooter'] button[type='submit']";
    private final String FIRSTPOSTLOCATOR = "div[id='substream_0'";


    public PostHelper(WebDriver driver) {
        super(driver);
    }

    public void create(String textData){
        click(By.cssSelector(POST));
        waitForVisibility(driver.findElement(By.cssSelector(CHECKBOXES)));
        type(By.cssSelector(TEXTAREA) , textData);
        click(By.cssSelector(BUTTONSHARE));
        waitForVisibility(driver.findElement(By.cssSelector(FEEDSTREAM)));
        driver.navigate().refresh();
        waitForTextPresent(By.cssSelector(POSTTEXT) , textData);
    }


    public void edit(String textData){
        click(By.cssSelector(NEWSPARAMS));
        waitForElementPrecence(By.cssSelector(PARAMSMENU));
        click(By.cssSelector(EDITOPTION));
        waitForElementPrecence(By.cssSelector(EDITWINDOWELEMENTS));
        type(By.cssSelector(TEXTAREA) , textData);
        click(By.cssSelector(BUTTONSHARE));
        waitForTextPresent(By.cssSelector(POSTTEXT) , textData);
    }

    public void delete(){
        click(By.cssSelector(NEWSPARAMS));
        waitForVisibilityOfAllElements(By.cssSelector(PARAMSMENU));
        click(By.cssSelector(DELETEOPTION));
        waitForElementPrecence(By.cssSelector(DELETEBUTTON));
        click(By.cssSelector(DELETEBUTTON));
        waitForTextPresent(By.cssSelector(FIRSTPOSTLOCATOR) , "");
    }

    public String getPOSTTEXT() {
        return POSTTEXT;
    }
}
