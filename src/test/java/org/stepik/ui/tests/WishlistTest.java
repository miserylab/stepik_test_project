package org.stepik.ui.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.sleep;
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
        sleep(1000);
    }

    @AfterEach
    void removeCourceFromWishlist(){
        wishlistPage.clickManageWishlistButton()
                .clickRemoveFromWishlistButton()
                .removeModalAppeared()
                .clickRemoveButton()
                .verifyNoWishlists(testData.noWishlistNoteText);
    }

    @Test
    @DisplayName("Добавление курса в вишлист")
    @Owner("o.demina")
    @Severity(CRITICAL)
    void successfullAddCourseToWishlist() {
//        step("Open main page", () ->
//                mainPage.openPage());
        mainPage.setSearchValue(testData.searchText);
//                .chooseCourse(testData.courseNameInDropDownList);
        searchResultPage.verifyCourseName(testData.courseName)
                        .wishlistCourse();
        wishlistPage.openWishlistPage()
                .verifyCourseInWishlist(testData.courseName);
    }
}
