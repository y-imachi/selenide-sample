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


@ExtendWith({ScreenShooterExtension.class})
@DisplayName("Selenide")
public class GoogleTest
{

    @BeforeAll
    public static void before() {
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
        screenshot("02_google_result");

        $$("h3").get(0).click();
        screenshot("03_selenide_top");
    }
}
