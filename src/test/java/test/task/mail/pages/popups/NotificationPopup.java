package test.task.mail.pages.popups;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Component
public class NotificationPopup {

    private SelenideElement header = $(byXpath("//div[@class='layer-sent-page']//div[@class='layer__header']//a"));

    public NotificationPopup resultShouldBeSuccess(){
        header.shouldHave(ownText("Письмо отправлено"));

        return this;
    }

}
