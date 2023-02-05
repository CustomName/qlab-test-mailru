package test.task.mail.pages;

import com.codeborne.selenide.SelenideElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Component
public class MainPage extends BasePage<MainPage> {

    @Value("${pages.login.title}")
    private String title;

    private final SelenideElement inputSearch = $(byXpath("//input[@name='text']"));
    private final SelenideElement btnSubmit = $(byXpath("//button[@type='submit']"));

    public MainPage inputSearch(String value){
        inputSearch.setValue(value);

        return this;
    }

    public MainPage clickSubmit(){
        btnSubmit.click();

        return this;
    }

    public MainPage inputSearchAndSubmit(String value){
        inputSearch.setValue(value);
        btnSubmit.click();

        return this;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
