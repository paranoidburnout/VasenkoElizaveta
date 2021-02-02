package hw8;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Property {
    @SneakyThrows
    public static Properties getProperties() {
        Properties props = new Properties();
        String propFileName = "hw8/test.properties";
        props.load(Property.class.getClassLoader().getResourceAsStream(propFileName));
        return props;
    }
}
