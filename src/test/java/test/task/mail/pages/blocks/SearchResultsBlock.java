package test.task.mail.pages.blocks;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;

@Component
public class SearchResultsBlock {

    private final ElementsCollection results = $$(byXpath("//ul[@id='search-result']/li"));
    private final SelenideElement labelNoResult = $("div.EmptySearchResults-Title");

    public SearchResultsBlock checkItemContainsText(int index, String expText){
        String actText = results.get(index).getText();
        assertThat(actText)
                .contains(expText);

        return this;
    }

    public SearchResultsBlock checkResultCount(int expCount){
        assertThat(results.size())
                .isEqualTo(expCount);

        return this;
    }

    public SearchResultsBlock checkNoResult(){
        assertThat(labelNoResult.getText())
                .isEqualTo("Ничего не нашли");

        return this;
    }

}
