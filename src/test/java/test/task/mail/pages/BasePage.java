package test.task.mail.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BasePage<T> {

    public T titleShouldBeCorrect(){
        checkTitle(getTitle());

        return (T) this;
    }

    public T titleShouldBeCorrect(String expTitle){
        checkTitle(expTitle);

        return (T) this;
    }

    private void checkTitle(String expTitle){
        WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), 10);
        webDriverWait.until(ExpectedConditions.titleContains(expTitle));
    }

    public abstract String getTitle();

}
