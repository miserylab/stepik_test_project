package org.stepik.ui.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {

    ElementsCollection wishListButtons = $$("li.course-cards__item .course-card__bookmark"),
            searchResultHeaders = $$(".course-cards__item .course-card__title");

    public SearchResultPage verifyCourseName(String value) {
        searchResultHeaders.find(text(value));
        return this;
    }

    public SearchResultPage wishlistCourse() {
        wishListButtons.get(0).click();
        return this;
    }
}
