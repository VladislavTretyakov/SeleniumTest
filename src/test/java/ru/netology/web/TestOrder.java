package ru.netology.web;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.*;

public class TestOrder {
//    private WebDriver driver;
//
//    @BeforeAll
//    static void setUpAll() {
//        System.setProperty("webdriver.chrome.driver", "./driver/win/chromedriver.exe");
//    }
//
//    @BeforeEach
//    void setUp() {driver = new ChromeDriver();}
//
//    @AfterEach
//    void tearDown() {
//        driver.quit();
//        driver = null;
//    }

//    @Test
//    void validationTestV1() throws InterruptedException {
//        driver.get("http://localhost:9999/");
//        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Третьяков Владислав");
//        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+79994445566");
//        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
//        driver.findElement(By.className("button")).click();
//        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
//        String actual = driver.findElement(By.cssSelector("p[data-test-id=order-success]")).getText().trim();
//        Assertions.assertEquals(expected, actual);
//    }

    @Test
    void validationTestV1() throws InterruptedException {
        open("http://localhost:9999/");
        SelenideElement form = $("div[id=root]");
        form.$(By.cssSelector("span[data-test-id=name] input")).setValue("Третьяков Владислав");
        form.$(By.cssSelector("span[data-test-id=phone] input")).setValue("+79994445566");
        form.$(By.cssSelector("label[data-test-id=agreement]")).click();
        form.$(By.className("button")).click();
        $("p[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
//    @Test
//    void validationHyphenatedTest() throws InterruptedException {
//        driver.get("http://localhost:9999/");
//        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Третьяков-Ощепков Владислав");
//        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+79994445566");
//        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
//        driver.findElement(By.className("button")).click();
//        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
//        String actual = driver.findElement(By.cssSelector("p[data-test-id=order-success]")).getText().trim();
//        Assertions.assertEquals(expected, actual);
//    }

    @Test
    void validationHyphenatedTest() throws InterruptedException {
        open("http://localhost:9999/");
        SelenideElement form = $("div[id=root]");
        form.$(By.cssSelector("span[data-test-id=name] input")).setValue("Третьяков-Ощепков Владислав");
        form.$(By.cssSelector("span[data-test-id=phone] input")).setValue("+79994445566");
        form.$(By.cssSelector("label[data-test-id=agreement]")).click();
        form.$(By.className("button")).click();
        $("p[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
       }
//
//    @Test
//    void validationLatinTest() throws InterruptedException {
//        driver.get("http://localhost:9999/");
//        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Tretyakov Vladislav");
//        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+79994445566");
//        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
//        driver.findElement(By.className("button")).click();
//        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
//        String actual = driver.findElement(By.className("input__sub")).getText().trim();
//        Assertions.assertEquals(expected, actual);
//    }

        @Test
        void validationLatinTest() throws InterruptedException {
            open("http://localhost:9999/");
            SelenideElement form = $("div[id=root]");
            form.$(By.cssSelector("span[data-test-id=name] input")).setValue("Tretyakov Vladislav");
            form.$(By.cssSelector("span[data-test-id=phone] input")).setValue("+79994445566");
            form.$(By.cssSelector("label[data-test-id=agreement]")).click();
            form.$(By.className("button")).click();
            $(".input__sub").shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
        }
       }

//    @Test
//    void wrongNumberTest() throws InterruptedException {
//        driver.get("http://localhost:9999/");
//        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Третьяков Владислав");
//        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+7999444556");
//        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
//        driver.findElement(By.className("button")).click();
//        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
//        String actual = driver.findElement(By.className("input__sub")).getText().trim();
//        Assertions.assertEquals(expected, actual);
//    }

