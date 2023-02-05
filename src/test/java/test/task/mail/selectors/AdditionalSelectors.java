package test.task.mail.selectors;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;

public class AdditionalSelectors {

    public static By byTestId(String testId) {
        return byAttribute("data-testid", testId);
    }

}
