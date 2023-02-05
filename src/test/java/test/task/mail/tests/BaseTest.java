package test.task.mail.tests;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Value;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    @Value("${url.yandex.main}")
    private String urlYandexMain;

    @BeforeEach
    public void beforeEach(){
        open(urlYandexMain);
        getWebDriver().manage().window().maximize();
    }

}
