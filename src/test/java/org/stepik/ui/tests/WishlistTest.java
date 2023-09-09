package org.stepik.ui.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic("Wishlist")
@Feature("Wishlist")
@Story("Managing wishlist items")
@Tag("web")
public class WishlistTest extends TestBase {

    @BeforeEach
    void successfullLogin() {
        step("Successfull Login", () ->
                mainPage.openLoginModal()
                        .setUserEmail(testData.userEmail)
                        .setUserUserPassword(testData.userPassword)
                        .clickLogin()
                        .userAvatarIsVisible());
    }

    @AfterEach
    void removeCourseFromWishlist() {
        step("Successfull course removal from wishlist", () ->
                wishlistPage.clickManageWishlistButton()
                        .clickRemoveFromWishlistButton()
                        .removeModalAppeared()
                        .clickRemoveButton()
                        .verifyNoWishlists(testData.noWishlistNoteText));
    }

    @Test
    @DisplayName("Добавление курса в вишлист")
    @Owner("o.demina")
    @Severity(CRITICAL)
    void successfullAddCourseToWishlist() {
        step("Search for value: " + testData.searchText, () ->
                mainPage.SearchValue(testData.searchText));
        step("Wishlist Course: " + testData.courseName, () ->
                searchResultPage.verifyCourseName(testData.courseName)
                        .wishlistCourse());
        step("Verify Course is wishlisted", () ->
                wishlistPage.openWishlistPage()
                        .verifyCourseInWishlist(testData.courseName));
    }
}
