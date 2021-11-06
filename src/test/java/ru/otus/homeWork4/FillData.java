package ru.otus.homeWork4;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FillData {
    public FillData(ChromeDriver driver) {
        this.driver = driver;
    }
    ChromeDriver driver;
    By buttonMenu = By.xpath("/html/body/div[1]/div/header[2]/div/div[3]/div/div[1]/div[3]");
    By myProfile = By.xpath("/html/body/div[1]/div/header[2]/div/div[3]/div/div[1]/div[2]/a[1]/div/b");
    By nameLat = By.id("id_fname_latin");
    By lastNameLat = By.id("id_lname_latin");
    By lastName = By.id("id_lname");
    By birthday = By.xpath("/html/body/div[1]/div/div[5]/div[3]/div[2]/div[2]/div/form/div[1]/div[1]/div/div[4]/div/div/input");
    By country = By.xpath("/html/body/div[1]/div/div[5]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[1]/div/div[1]/div[1]/div[2]/div/label/div");
    By valueCountry = By.xpath("/html/body/div[1]/div/div[5]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[1]/div/div[1]/div[1]/div[2]/div/div/div/button[2]");
    By town = By.xpath("/html/body/div[1]/div/div[5]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[1]/div/div[1]/div[2]/div[2]/div/label/div");
    By valueTown = By.xpath("/html/body/div[1]/div/div[5]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[1]/div/div[1]/div[2]/div[2]/div/div/div/button[9]");
    By levelEnglish = By.xpath("/html/body/div[1]/div/div[5]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[1]/div/div[1]/div[3]/div[2]/div/label/div");
    By valueLevelEnglish = By.xpath("/html/body/div[1]/div/div[5]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[1]/div/div[1]/div[3]/div[2]/div/div/div/button[2]");
    By communicationType = By.xpath("/html/body/div[1]/div/div[5]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/div/div/div/label/div");
    By valueComm1 = By.xpath("/html/body/div[1]/div/div[5]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/button[7]");
    By addCommunication = By.xpath("//*[@id=\"id_contact-0-value\"]");
    By valueComm2 = By.xpath("/html/body/div[1]/div/div[5]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div/div/button[6]");
    By communicationType2 = By.xpath("/html/body/div[1]/div/div[5]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[2]/div[2]/div/div[2]/div[1]/div/div/div");
    By addCommunication2 = By.xpath("//*[@id=\"id_contact-1-value\"]");
    By buttonSave = By.xpath("/html/body/div[1]/div/div[5]/div[3]/div[2]/div[2]/div/form/div[2]/div/div/button[2]");
    By butt = By.xpath("/html/body/div[1]/div/div[5]/div[3]/div[2]/div[2]/div/form/div[1]/div[3]/div[2]/div[2]/button");
    By telegram = By.xpath("//div[@class='lk-cv-block__line js-formset-items']//div[contains(text(), 'Тelegram')]");
    By viber = By.xpath("//div[@class='lk-cv-block__line js-formset-items']//div[contains(text(), 'Viber')]");



    public void fillMyProfile () {
        driver.findElement(buttonMenu).click();
        driver.findElement(myProfile).click();
        driver.findElement(nameLat).clear();
        driver.findElement(lastNameLat).clear();
        driver.findElement(lastName).clear();
        driver.findElement(birthday).clear();
        driver.findElement(addCommunication).clear();
        driver.findElement(addCommunication2).clear();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));


        driver.findElement(nameLat).sendKeys("Test");
        driver.findElement(lastNameLat).sendKeys("Testov");
        driver.findElement(lastName).sendKeys("Тестов");
        driver.findElement(birthday).sendKeys("19.02.2000");
        driver.findElement(country).click();
        driver.findElement(valueCountry).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(town).click();
        driver.findElement(valueTown).click();
        driver.findElement(levelEnglish).click();
        driver.findElement(valueLevelEnglish).click();
        driver.findElement(communicationType).click();
        driver.findElement(valueComm1).click();
        driver.findElement(butt).click();
        driver.findElement(addCommunication).click();
        driver.findElement(addCommunication).sendKeys("123");
        driver.findElement(communicationType2).click();
        driver.findElement(valueComm2).click();
        driver.findElement(addCommunication2).click();
        driver.findElement(addCommunication2).sendKeys("456");
        driver.findElement(buttonSave).submit();
    }
    public void examinationData() {

        driver.findElement(buttonMenu).click();
        driver.findElement(myProfile).click();
        Assert.assertEquals("Test",driver.findElement(nameLat).getAttribute("value"));
        Assert.assertEquals("Testov",driver.findElement(lastNameLat).getAttribute("value"));
        Assert.assertEquals("Тестов",driver.findElement(lastName).getAttribute("value"));
        Assert.assertEquals("19.02.2000", driver.findElement(birthday).getAttribute("value"));
        Assert.assertEquals("Россия", driver.findElement(country).getText());
        Assert.assertEquals("Анапа",driver.findElement(town).getText());
        Assert.assertEquals("Тelegram", driver.findElement(telegram).getText());
        Assert.assertEquals("123",driver.findElement(addCommunication).getAttribute("value"));
        Assert.assertEquals("456",driver.findElement(addCommunication2).getAttribute("value"));

    }


}
