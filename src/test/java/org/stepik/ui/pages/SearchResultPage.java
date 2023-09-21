package org.stepik.ui.pages;

import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {

    ElementsCollection wishListButtons = $$("[type='button'][class^='course-card__bookmark']"),
            searchResultHeaders = $$(".course-cards__item .course-card__title");

    public SearchResultPage verifyCourseName(String value) {
        searchResultHeaders.find(text(value)).shouldBe(visible);
        return this;
    }

    public SearchResultPage clickWishlistCourse() {
        wishListButtons.get(0).shouldBe(visible, Duration.ofSeconds(5));
        wishListButtons.get(0).click();
        return this;
    }
}
