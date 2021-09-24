package test.task.mail.pages;

import com.codeborne.selenide.SelenideElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static test.task.mail.AdditionalSelectors.byTestId;

@Component
public class LoginPage extends BasePage<LoginPage> {

    @Value("${pages.login.title}")
    private String title;

    private final SelenideElement inputLogin = $(byTestId("login-input"));
    private final SelenideElement btnEnterPassword = $(byTestId("enter-password"));
    private final SelenideElement labelLogin = $(byClassName("head__email"));
    private final SelenideElement inputPassword = $(byTestId("password-input"));
    private final SelenideElement btnEnter = $(byTestId("login-to-mail"));

    public LoginPage enterLogin(String login){
        inputLogin.val(login);
        btnEnterPassword.click();
        labelLogin.shouldHave(ownText(login + "@mail.ru"));

        return this;
    }

    public LoginPage enterPassword(String password){
        inputPassword.val(password);
        btnEnter.click();

        return this;
    }

    public LoginPage login(String login, String password){
        enterLogin(login);
        enterPassword(password);

        return this;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
