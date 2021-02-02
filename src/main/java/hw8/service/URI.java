package hw8.service;

import static hw8.service.CommonService.getProperties;

public class URI {
    public static String DOMAIN = getProperties().getProperty("domain");
    public static final String CHECK_TEXT_URI = DOMAIN + "checkText";
    public static final String CHECK_TEXTS_URI = DOMAIN + "checkTexts";
}
