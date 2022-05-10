package org.sample.selenide_sample.pagewidgets;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchResults {

	// Elements
	public ElementsCollection found = $$("h3");

	// Actions
	public SelenideElement getResult(int index) {
		return found.get(index);
	}

	public void click(int index) {
		found.get(index).click();
	}

}
