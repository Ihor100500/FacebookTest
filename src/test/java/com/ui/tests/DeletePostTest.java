package com.ui.tests;

import org.junit.Test;

public class DeletePostTest extends TestBase {

    @Test
    public void postDelete(){
        app.post().delete();
    }

}
