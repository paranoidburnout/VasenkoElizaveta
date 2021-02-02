package hw8;

import hw8.dto.ParametersDto;
import hw8.dto.SpellerDto;
import hw8.service.RestSpellerAssertions;
import hw8.service.RestSpellerService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collections;

import static java.util.Arrays.asList;

public class ErrorContentTest {

    private static final ParametersDto TEXT_WITH_UNKNOWN_LANGUAGE = new ParametersDto()
            .setIncorrectText(Collections.singletonList("unavena"));

    private static final String ERROR_IN_TEXT_WITH_OPTIONS = "думаю";

    private static final ParametersDto TEXT_WITH_OPTIONS = new ParametersDto()
            .setIncorrectText(Collections.singletonList("Я думаю думаю о смысле. Что есть я"))
            .setOptions(526);

    @DataProvider
    public Object[] checkTextForSpellingErrorsDataProvider() {
        return new ParametersDto[]{
                new ParametersDto().setIncorrectText(asList("праверка")).setLang("ru").setCorrectText(asList("проверка")),
                new ParametersDto().setIncorrectText(asList("сабака")).setLang("ru").setCorrectText(asList("собака")),
                new ParametersDto().setIncorrectText(asList("друх")).setLang("ru").setCorrectText(asList("друг"))
        };
    }

    @Test(dataProvider = "checkTextForSpellingErrorsDataProvider")
    public void checkTextInDifferentLanguages(ParametersDto wordDto) {
        SpellerDto[] spellerDto = new RestSpellerService().getCheckTextResult(wordDto);
        new RestSpellerAssertions(spellerDto).checkResponseContainsCorrectText(wordDto.getCorrectText());
    }

    @Test
    public void checkUnknownLanguage() {
        SpellerDto[] spellerDto = new RestSpellerService()
                .getCheckTextResult(TEXT_WITH_UNKNOWN_LANGUAGE);
        new RestSpellerAssertions(spellerDto).checkErrorSize(0);
    }

    @Test
    public void checkOptions() {
        SpellerDto[] errors = new RestSpellerService()
                .getCheckTextResult(TEXT_WITH_OPTIONS);
        new RestSpellerAssertions(errors)
                .checkWordWithMistake(ERROR_IN_TEXT_WITH_OPTIONS);
    }

}
