package product.config;

import java.util.regex.Pattern;

public class ValidateUtils {
    public static final String NAME_REGEX = "^([A-Z]+[a-z]*[ ]?)+$";
    public static final String PHONE_REGEX = "^[0][1-9][0-9]{8,9}$";
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public static final String ADRESS_REGEX = "^([^. ][.]*[ ]?)+$";
    public static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$";


    public static boolean isNameValid(String name) {
        System.out.println("Nhập tên bất kỳ ");

        return Pattern.compile(NAME_REGEX).matcher(name).matches();
    }

    public static boolean isPhoneValid(String number) {

        return Pattern.compile(PHONE_REGEX).matcher(number).matches();
    }

    public static boolean isAddreeValid(String address){
        return Pattern.compile(ADRESS_REGEX).matcher(address).matches();
    }
    public static boolean isEmailValid(String email){
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }
    public static boolean isPasswordValid(String password){
        return Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
    }

}
