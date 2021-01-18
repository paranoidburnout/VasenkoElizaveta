package hw6.Json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hw6.DataFromJsonForMetalsColorPage;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

public class JsonDataProvider {
    @DataProvider(name = "DataProviderJson")
    public Object[][] divideDataProviderNoCheckDivZero() throws FileNotFoundException {
        Reader reader = new FileReader("src/test/resources/hw6/JDI_ex6_metalsColorsDataSet.json");
        Map<String, DataFromJsonForMetalsColorPage> dataFromJson = new Gson()
                .fromJson(reader, new TypeToken<Map<String, DataFromJsonForMetalsColorPage>>() {
                }
                        .getType());
        Object[][] returnObject = new Object[dataFromJson.size()][1];
        int index = 0;
        for (String key : dataFromJson.keySet()) {
            returnObject[index++][0] = dataFromJson.get(key);
        }
        return returnObject;
    }
}
