package org.sample.selenide_sample;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;

/**
 * Simple Selenide Test with PageObjects
 */
@ExtendWith({ScreenShooterExtension.class})
@DisplayName("Selenide")
public class GoogleTest
{
	
	@BeforeAll
	public void before() {
    	// 保存場所を設定
    	Configuration.reportsFolder = "target/reports";
    	// -Dselenide.reports=test-result/reportsでも設定可能	
	}

    @Test
    @DisplayName("検索シナリオ")
    public void searchForSelenide() {
    	
        open("https://google.com/");

        screenshot("01_google_top");
        // 検索
        $(byName("q")).setValue("selenide").pressEnter();


        // Assert
        // 検索結果が1件以上あること
        $$("h3").shouldHave(sizeGreaterThan(1));
        // SelenideTopページが出ること
        $$("h3").get(0).shouldHave(text("Selenide: concise UI tests in Java"));
        
        $$("h3").get(0).click();
        screenshot("02_selenide_top");
    }
}