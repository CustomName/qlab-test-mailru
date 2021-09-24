package test.task.mail.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import test.task.mail.pages.blocks.SidebarBlock;

@Component
public class InboxPage extends BasePage<InboxPage>{

    @Value("${pages.inbox.title}")
    private String title;

    @Autowired
    private SidebarBlock sidebarBlock;

    public SidebarBlock getSidebarBlock(){
        return sidebarBlock;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
