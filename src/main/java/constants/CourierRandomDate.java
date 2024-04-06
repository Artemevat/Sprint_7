package constants;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierRandomDate {
    //генерация случайного значения для поля login, password, firstName
    public static final String LOGIN = RandomStringUtils.randomAlphabetic(10);
    public static final String PASSWORD = RandomStringUtils.randomNumeric(8);
    public static final String FIRSTNAME = RandomStringUtils.randomAlphabetic(12);

    public static final String LOGIN_DUPLICATE = RandomStringUtils.randomAlphabetic(10);
    public static final String PASSWORD_DUPLICATE = RandomStringUtils.randomNumeric(8);
    public static final String FIRSTNAME_DUPLICATE = RandomStringUtils.randomAlphabetic(12);

    public static final String LOGIN_WITHOUT_FIRSTNAME = RandomStringUtils.randomAlphabetic(10);
    public static final String PASSWORD_WITHOUT_FIRSTNAME = RandomStringUtils.randomNumeric(8);
}
