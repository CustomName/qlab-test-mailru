package test.task.mail.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import test.task.mail.pages.blocks.SearchResultsBlock;

@Component
public class SearchPage extends BasePage<SearchPage>{

    @Value("${pages.inbox.title}")
    private String title;

    @Autowired
    private SearchResultsBlock searchResultsBlock;

    public SearchResultsBlock getSearchResultsBlock(){
        return searchResultsBlock;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
