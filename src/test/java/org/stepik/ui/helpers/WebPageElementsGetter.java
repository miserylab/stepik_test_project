package org.stepik.ui.helpers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

public class WebPageElementsGetter {
    public static ArrayList<String> getHeadersFromPage(ElementsCollection headers) {
        ArrayList<String> headersFromPage = new ArrayList<>();

        for (SelenideElement header : headers) {
            String text = header.getText();
            if (!text.isEmpty()) {
                headersFromPage.add(text.trim());
            }
        }
        return headersFromPage;
    }
}
