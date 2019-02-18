package com.ui.tests;

import com.ui.generators.TextDataGenerator;
import org.junit.Test;

public class EditPostTest extends TestBase {

    @Test
    public void postEdit(){
        String textData = TextDataGenerator.dataGenerator(10);
        app.post().edit(textData);
    }
}
