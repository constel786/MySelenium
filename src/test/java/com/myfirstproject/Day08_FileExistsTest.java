package com.myfirstproject;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileExistsTest {
    @Test
    public void isExistTest(){
        //1. write the path of your file
        //terminal
// hard coded path of image file is /Users/eozer1/Downloads/image.jpeg  
        String pathOfImage = System.getProperty("user.home")+"/Downloads/image.jpeg";
        System.out.println("path = " + pathOfImage);
//  And verify if that file exists on your computer or not
        boolean isImageExist = Files.exists(Paths.get(pathOfImage));
        Assert.assertTrue(isImageExist);


    }
}
