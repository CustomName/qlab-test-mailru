package test.task.mail.pages.blocks;

import com.codeborne.selenide.SelenideElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.task.mail.pages.popups.LetterPopup;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Component
public class SidebarBlock {

    @Autowired
    private LetterPopup letterPopup;

    private SelenideElement btnWriteLetter = $(byXpath("//a[@href='/compose/']"));

    public LetterPopup clickWriteLetter(){
        btnWriteLetter.click();

        return letterPopup;
    }

}
