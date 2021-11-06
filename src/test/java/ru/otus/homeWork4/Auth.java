package ru.otus.homeWork4;



import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class Auth {
    public Auth(ChromeDriver driver) {
        this.driver = driver;
    }



    ChromeDriver driver;

    By emailXpath = By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/form/div[2]/input");
    By password = By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/form/div[3]/input");
    By buttonLogin = By.xpath("/html/body/div[1]/div/header[2]/div/div[3]/div[1]/button");
    By buttonSubmit = By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/form/div[4]/button");
    String email = System.getProperty("email");
    String pass = System.getProperty("pass");




    public void auth () {

        driver.findElement(buttonLogin).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.findElement(emailXpath).sendKeys(email);
        driver.findElement(password).sendKeys(pass);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(buttonSubmit).submit();








    }
}
