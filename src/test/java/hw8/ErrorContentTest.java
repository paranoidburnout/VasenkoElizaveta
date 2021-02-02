package hw8;

import hw8.dto.ParametersDto;
import hw8.dto.SpellerDto;
import hw8.service.RestSpellerAssertions;
import hw8.service.RestSpellerService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static hw8.TestData.*;
import static java.util.Arrays.asList;

public class ErrorContentTest {

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
    public void checkWordsInUppercase() {
        checkText(TEXT_WITH_UPPERCASE, 3);
    }

    @Test
    public void checkTextForDigits() {
        checkText(TEXT_WITH_DIGITS,1);
    }

    public void checkText(ParametersDto String, Integer error) {
        SpellerDto[][] spellerDto = new RestSpellerService().getCheckTextsResult(String);
        SpellerDto[] errorDto = new RestSpellerService().parseData(spellerDto);
        new RestSpellerAssertions(errorDto)
                .verifyBodyHasErrorCode(error)
                .checkResponseContainsCorrectText(String.getCorrectText());
    }
}
