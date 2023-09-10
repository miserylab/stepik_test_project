package org.stepik.mobile.utils;

import org.aeonbits.owner.ConfigFactory;
import org.stepik.config.WebConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MobileTestData {

    private final WebConfig config = ConfigFactory.create(WebConfig.class);

    public String userEmail = config.getStepikUser(),
            unregisteredEmail = "test@eryuew.com",
            userPassword = config.getStepikPassword(),
            courseName = "Data Structures",
            userName = "Olga D",
            loginErrorMessageText = "Login/password was incorrect";

    public List<String> categories = new ArrayList<>(Arrays.asList("Editors' choice", "Stepik trends", "My courses", "Popular"));
}
