package org.stepik.ui.utils;

import org.aeonbits.owner.ConfigFactory;
import org.stepik.config.WebConfig;

public class TestData {

    private final WebConfig config = ConfigFactory.create(WebConfig.class);

    public String catalogPage = config.getBaseUrl() + "/catalog",
    catalogSalePage = "https://welcome.stepik.org/catalog-sale",
    catalogSalePageTitle = "Распродажа в честь 10-летия платформы Stepik";
}
