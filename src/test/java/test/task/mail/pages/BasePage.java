package test.task.mail.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BasePage<T> {

    public T titleShouldBeCorrect(){
        WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), 10);
        webDriverWait.until(ExpectedConditions.titleIs(getTitle()));

        return (T) this;
    }

    public abstract String getTitle();

}
