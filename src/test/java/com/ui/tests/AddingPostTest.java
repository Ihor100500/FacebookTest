package com.ui.tests;

import com.ui.generators.TextDataGenerator;
import org.junit.Test;
import org.openqa.selenium.By;

public class AddingPostTest extends TestBase {

    @Test
    public void postAdding(){
        String textData = TextDataGenerator.dataGenerator(10);
        app.post().create(textData);
        app.post().checkText(By.cssSelector(app.post().getPOSTTEXT()) , textData);
    }
}
