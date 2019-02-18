package com.ui.tests;


import com.ui.appmanager.ApplicationManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.BrowserType;

import java.io.IOException;

public class TestBase {

    static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @Before
    public void setUp() throws IOException {
        app.init();
    }

    @After
    public void tearDown(){
        app.stop();
    }

}
