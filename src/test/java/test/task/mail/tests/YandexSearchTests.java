package test.task.mail.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import test.task.mail.pages.MainPage;
import test.task.mail.pages.SearchPage;

@SpringBootTest
class YandexSearchTests extends BaseTest {

	@Autowired
	private MainPage mainPage;

	@Autowired
	private SearchPage searchPage;

	@Test
	public void successSearchTest() {
		mainPage.titleShouldBeCorrect()
				.inputSearch("selenide")
				.clickSubmit();

		searchPage.titleShouldBeCorrect()
				.getSearchResultsBlock()
				.checkItemContainsText(0, "Selenide: лаконичные и стабильные UI тесты на Java");
	}

	@Test
	public void searchWithManyResultsHas10ItemsTest() {
		mainPage.titleShouldBeCorrect()
				.inputSearch("selenide")
				.clickSubmit();

		searchPage.titleShouldBeCorrect()
				.getSearchResultsBlock()
				.checkResultCount(10);
	}

	@Test
	public void searchWithNoResultsTest() {
		mainPage.titleShouldBeCorrect()
				.inputSearch("iohasohsidguhldsfhglieugh")
				.clickSubmit();

		searchPage.titleShouldBeCorrect("Яндекс: ничего не найдено")
				.getSearchResultsBlock()
				.checkNoResult();
	}

}
