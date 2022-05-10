package org.sample.selenide_sample;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;

public class YahooSample {

	public static void main(String[] args) {
		
		// =============================================		
		// ブラウザ（ChromeDriver）の起動および初期URLの指定
		// ChromeDriver.exeは自動でダウンロード可能
		// UserAgentの指定は別途起動パラメータの指定などでも可能
		// =============================================
//		WebDriver driver = new ChromeDriver();
//		driver.navigate().to("https://google.com/");
		
		open("https://yahoo.co.jp/");
		
		// =============================================
		// Yahooページの検索に「selenium」を入力し、検索ボタンを押す
		// =============================================
//		driver.findElement(By.name("p"))
//	      .sendKeys("selenium");
//		driver.findElement(By.name("submit")).click();
		
		$(byName("p")).val("selenium");
		$("[type=submit]").click();
		
		
		// =============================================
		// ページのAssertを行う　この場合Yahooの検索結果ページの下部に条件指定の文字列があることを確認する
		// =============================================
//		assertThat(
//			    driver.findElement(By.class("SearchBox__conditionsListItem")).getText(),
//			    containsString("条件指定"));
		
		$(".SearchBox__conditionsListItem").shouldBe(matchText("条件指定"));
		
		
		// =============================================
		// 画面のキャプチャを行う
		// =============================================

//		File source = ((TakesScreenshot) driver)
//                .getScreenshotAs(OutputType.FILE);
//		Path target = Paths.get("/path/to/saved.png");
//		Files.copy(source.toPath(), target);

		//-Dselenide.reports=/path/to/
		screenshot("saved");
	}

}
