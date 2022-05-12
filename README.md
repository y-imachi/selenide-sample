# Selenideによる画面の自動化について

## Selenideとは
Webの自動テストフレームワークの一種。
「Selenium WebDriver」を利用したテスト自動化フレームワーク。Javaベース。

Seleniumに比べて
- コードが書きやすい
- 環境構築などの準備が簡単
- Ajaxサポート
- セレクタが簡単でわかりやすい

といった特徴がある。

【公式サイト】
https://selenide.org/
【SeleniumとSelenideを比較】
SeleniumとSelenideを比較

### Selenideでできること

- 各種ブラウザ操作
- 画面キャプチャ機能
- 各種アサート機能（各画面要素があるかどうか）

## 環境セットアップ
今回のサンプルはmavenを使用した場合の例

pom.xmlに以下を追加する
```xml
		<dependency>
			<groupId>com.codeborne</groupId>
			<artifactId>selenide</artifactId>
			<version>6.3.5</version>
		</dependency>
 ```
 
あとは操作処理を追加するのみ！
