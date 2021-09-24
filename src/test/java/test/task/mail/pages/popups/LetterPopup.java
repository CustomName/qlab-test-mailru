package test.task.mail.pages.popups;

import com.codeborne.selenide.SelenideElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Component
public class LetterPopup {

    @Autowired
    private NotificationPopup notificationPopup;

    private SelenideElement inputTo = $(byXpath("//div[@data-type='to']//input"));
    private SelenideElement inputBody = $(byXpath("//div[contains(@class,'editable-container')]/div/div"));
    private SelenideElement btnSend = $(byText("Отправить"));

    public LetterPopup fillTo(String to){
        inputTo.val(to)
            .shouldHave(value(to));

        return this;
    }

    public LetterPopup fillBody(String body){
        inputBody.val(body)
                .shouldHave(ownText(body));

        return this;
    }

    public NotificationPopup clickSend(){
        btnSend.click();

        return notificationPopup;
    }

}
