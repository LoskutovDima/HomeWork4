package ru.otus.homeWork4;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


public class HomeWork {
private org.apache.logging.log4j.Logger logger = LogManager.getLogger(Test.class);

protected static ChromeDriver driver;

@Before
public void setDriver(){
    WebDriverManager.chromedriver().setup();
    logger.info("Драйвер поднят!");

}

@After
    public void driverEnd() {
    if(driver!=null)
        driver.quit();
    logger.info("Драйвер закрыт!");
}
@Test
    public void webTest() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    Auth qwerty = new Auth(driver);
    FillData qwerty1 = new FillData(driver);
    // 1. Открыть страницу сайта ОТУС
    driver.get("https://otus.ru/");
    // 2. Авторизоваться на сайте ОТУС
    qwerty.auth();
    logger.info("Пользователь успешно авторизирован!");
    //3. Заполнить данные в профиле пользователя
    qwerty1.fillMyProfile();
    logger.info("Данные пользователя успешно заполнены!");
    if(driver!=null)
        driver.quit();
    driver = new ChromeDriver();
    //1. Открыть сайт ОТУС в новом окне
    driver.get("https://otus.ru/");
    logger.info("Сайт открыт!");
    Auth newAuth = new Auth(driver);
    FillData fillData = new FillData(driver);
    //2. Авторизоваться на сайте ОТУС
    newAuth.auth();
    logger.info("Пользователь успешно авторизован!");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    //3. Проверить заполнение атрибутов заполненных ранее
    fillData.examinationData();
    logger.info("Данные успешно проверены!");


}
}
