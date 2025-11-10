package com.ejemplo.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

//import net.thucydides.core.annotations.Managed;
//import net.thucydides.core.annotations.ManagedPages;
import net.serenitybdd.annotations.Managed;
import net.thucydides.core.pages.Pages;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;


/**
 * Clase base para inicializar WebDriver y configuración común de las pruebas.
 */
public abstract class TestBase {


    @Managed(driver = "chrome")
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}