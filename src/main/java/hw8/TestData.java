package hw8;

import hw8.dto.ParametersDto;

import java.util.Collections;

public class TestData {
    public static final ParametersDto TEXT_WITH_UNKNOWN_LANGUAGE = new ParametersDto()
            .setIncorrectText(Collections.singletonList("unavena"));

    public static final String ERROR_IN_TEXT_WITH_OPTIONS = "думаю";

    public static final ParametersDto TEXT_WITH_OPTIONS = new ParametersDto()
            .setIncorrectText(Collections.singletonList("Я думаю думаю о смысле. Что есть я"))
            .setOptions(526);

    public static final ParametersDto TEXT_WITH_UPPERCASE = new ParametersDto()
            .setIncorrectText(Collections.singletonList("АТЛанТиДА"))
            .setCorrectText(Collections.singletonList("Атлантида"));

    public static final ParametersDto TEXT_WITH_DIGITS = new ParametersDto()
            .setIncorrectText(Collections.singletonList("Царь228"))
            .setCorrectText(Collections.singletonList("Царь 228"));
}
