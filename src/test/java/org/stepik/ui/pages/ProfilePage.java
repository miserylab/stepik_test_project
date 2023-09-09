package org.stepik.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage {

    SelenideElement searchInput = $(".st-input-wrapper");
    ElementsCollection searchDropDownListItems = $$("li.menu-item");

    public ProfilePage setSearchValue(String value) {
        searchInput.setValue(value);
        return this;
    }

    public ProfilePage chooseCourse(String value) {
        searchDropDownListItems.find(text(value)).click();
        return this;
    }
}
