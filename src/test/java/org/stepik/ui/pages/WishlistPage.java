package org.stepik.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WishlistPage {

    SelenideElement removeFromWishlistButton = $("[data-qa='menu-item-remove-from-wishlist']"),
            removeModal = $(".modal-popup__container"),
            removeButton = $(".modal-popup__container .danger"),
            noWishlistNote = $(".teachlearn__empty-note"),
            wishlistedCourse = $(".item-tile");

    ElementsCollection wishlistManageButton = $$(".menu-more_icon");

    public WishlistPage openWishlistPage() {
        open("/learn/courses/wishlist");
        return this;
    }

    public WishlistPage verifyCourseInWishlist(String value) {
        wishlistedCourse.shouldHave(text(value));
        return this;
    }

    public WishlistPage clickManageWishlistButton() {
        wishlistManageButton.get(0).click();
        return this;
    }

    public WishlistPage clickRemoveFromWishlistButton() {
        removeFromWishlistButton.click();
        return this;
    }

    public WishlistPage removeModalAppeared() {
        removeModal.should(appear);

        return this;
    }

    public WishlistPage clickRemoveButton() {
        removeButton.click();
        return this;
    }

    public WishlistPage verifyNoWishlists(String value) {
        noWishlistNote.shouldHave(text(value));
        return this;
    }
}
