package com.ui.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {


    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        type(By.name("email") , email);
        type(By.name("pass") , password);
        click(By.cssSelector("[data-testid=royal_login_button]"));
    }
}
