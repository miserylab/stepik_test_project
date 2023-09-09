package org.stepik.ui.utils;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.stepik.config.WebConfig;

import java.util.Arrays;
import java.util.stream.Stream;

public class TestData implements ArgumentsProvider {

    private final WebConfig config = ConfigFactory.create(WebConfig.class);

    public String catalogPageUrl = config.getBaseUrl() + "/catalog",
            catalogSalePageUrl = "https://welcome.stepik.org/catalog-sale",
            catalogSalePageTitle = "Распродажа в честь 10-летия платформы Stepik",
            userEmail = "psychosomatic2032@gmail.com",
            unregisteredEmail = "test@eryuew.com",
            userPassword = "F8EhaLCsAp9sB5",
            unSuccessfullAlert = "E-mail адрес и/или пароль не верны.",
            searchText = "основы java",
            courseName = "Основы java",
            noWishlistNoteText = "Add interesting courses to your Wishlist to come back to them later.";

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of("Русский", Arrays.asList("Праздничная распродажа: курсы со скидками", "Скидки для программистов", "Размещают курсы на Stepik", "Онлайн-курсы", "Предметы", "Часто ищут", "Авторы курсов", "Рекомендованные курсы")),
                Arguments.of("English", Arrays.asList("Online courses", "Top categories", "Best authors"))
        );
    }
}
