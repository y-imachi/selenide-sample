package org.sample.selenide_sample;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sample.selenide_sample.pagewidgets.GoogleSearch;
import org.sample.selenide_sample.pagewidgets.GoogleSearchResults;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;

/**
 * Simple Selenide Test with PageObjects
 */
@ExtendWith({ScreenShooterExtension.class})
@DisplayName("Selenide")
public class GooglePageObjectTest

{
    @Test
    @DisplayName("検索シナリオ(PageObject仕様)")
    public void searchForSelenide() {
    	
    	
    	// 保存場所を設定
    	Configuration.reportsFolder = "target/reports";
    	// -Dselenide.reports=test-result/reportsでも設定可能

        // Arrange
        open("https://google.com/");
        // 画面全体を撮りたい場合（my_file_name.pngとmy_file_name.htmlが保存される）
        screenshot("01_top_page");
        // Act
        new GoogleSearch().searchFor("selenide");

        // Assert
        GoogleSearchResults results = new GoogleSearchResults();
        
        // 検索結果が1件以上あること
        results.found.shouldHave(sizeGreaterThan(1));
        // SelenideTopページが出ること
        results.getResult(0).shouldHave(text("Selenide: concise UI tests in Java"));
    }
}
