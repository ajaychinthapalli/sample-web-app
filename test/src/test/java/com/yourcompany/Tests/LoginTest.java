package com.yourcompany.Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.Assert;

public class LoginTest extends TestBase {

    @Test
    public void validLogin(){
        driver.get("http://localhost:5000/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector(".btn_action")).click();

        Assert.assertTrue(driver.findElement(By.id("shopping_cart_container")).isDisplayed());
    }
}
