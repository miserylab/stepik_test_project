package org.stepik.ui.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;


@Epic("Wishlist")
@Feature("Wishlist")
@Story("Managing wishlist items")
@Owner("o.demina")
@Tag("web")
public class WishlistTest extends BaseTest {

    @BeforeEach
    void successfullLogin() {
        step("Successfull Login", () ->
                mainPage.openLoginModal()
                        .setUserEmail(testData.userEmail)
                        .setUserPassword(testData.userPassword)
                        .clickLogin()
                        .checkAvatarIsVisible());
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
    @Severity(CRITICAL)
    void successfullAddCourseToWishlist() {
        step("Search for value: " + testData.searchText, () ->
                mainPage.searchValue(testData.searchText));
        step("Wishlist Course: " + testData.courseName, () ->
                searchResultPage.verifyCourseName(testData.courseName)
                        .clickWishlistCourse());
        step("Verify Course is wishlisted", () ->
                wishlistPage.openWishlistPage()
                        .verifyCourseInWishlist(testData.courseName));
    }
}
