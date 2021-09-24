package test.task.mail.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import test.task.mail.pages.InboxPage;
import test.task.mail.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

@SpringBootTest
class MailMessageTests {

	@Autowired
	private LoginPage loginPage;

	@Autowired
	private InboxPage inboxPage;

	@Value("${url.mail.main}")
	private String urlMailMain;

	@Value("${user.login}")
	private String login;

	@Value("${user.password}")
	private String password;

	@Test
	public void messageShouldBeSent() {
		open(urlMailMain);

		loginPage.titleShouldBeCorrect()
				.login(login, password);

		inboxPage.titleShouldBeCorrect()
				.getSidebarBlock()
				.clickWriteLetter()
				.fillTo(login + "@mail.ru")
				.fillBody("Probe message")
				.clickSend()
				.resultShouldBeSuccess();
	}

}
