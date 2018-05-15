package net.meloli.demo.controller;

import org.junit.Assert;
import org.junit.Test;

public class MyTestControllerTest {

    @Test
    public void testGetMyName(){
         Assert.assertEquals("FLiNG", new MyTestController().getMyName());
    }
}
