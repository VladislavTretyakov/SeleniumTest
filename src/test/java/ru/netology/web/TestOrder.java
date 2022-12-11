package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class TestOrder {
//        private WebDriver driver;
//
//        @BeforeEach
//        void setUp() {driver = new ChromeDriver();}

    @Test
    void validationTestV1() {
        open("http://localhost:9999/");
        SelenideElement form = $("div[id=root]");
        form.$("span[data-test-id=name] input").setValue("Третьяков Владислав");
        form.$("span[data-test-id=phone] input").setValue("+79994445566");
        form.$("label[data-test-id=agreement]").click();
        form.$("button").click();
        $("p[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void validationHyphenatedTest() {
        open("http://localhost:9999/");
        SelenideElement form = $("div[id=root]");
        form.$("span[data-test-id=name] input").setValue("Третьяков-Ощепков Владислав");
        form.$("span[data-test-id=phone] input").setValue("+79994445566");
        form.$("label[data-test-id=agreement]").click();
        form.$("button").click();
        $("p[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void validationLatinTest() {
        open("http://localhost:9999/");
        SelenideElement form = $("div[id=root]");
        form.$("span[data-test-id=name] input").setValue("Tretyakov Vladislav");
        form.$("span[data-test-id=phone] input").setValue("+79994445566");
        form.$("label[data-test-id=agreement]").click();
        form.$("button").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void incompleteNumberTest() {
        open("http://localhost:9999/");
        SelenideElement form = $("div[id=root]");
        form.$("span[data-test-id=name] input").setValue("Третьяков Владислав");
        form.$("span[data-test-id=phone] input").setValue("+7999444566");
        form.$("label[data-test-id=agreement]").click();
        form.$("button").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }
}

