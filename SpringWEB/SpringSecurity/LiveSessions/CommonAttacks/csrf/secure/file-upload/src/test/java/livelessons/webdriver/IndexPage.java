package livelessons.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class IndexPage {
	private WebDriver driver;

	@FindBy(id = "file")
	private WebElement file;

	@FindBy(css = "input[type=submit]")
	private WebElement submit;

	public IndexPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public static <T> T to(WebDriver driver, int port, Class<T> page) {
		driver.get("http://localhost:" + port + "/");
		return (T) PageFactory.initElements(driver, page);
	}

	public IndexPage assertAt() {
		assertThat(this.driver.getTitle()).isEqualTo("File Upload");
		return this;
	}

	public IndexPage upload(String fileLocation) {
		this.file.sendKeys(fileLocation);
		this.submit.click();
		return PageFactory.initElements(this.driver, IndexPage.class);
	}
}
