package com.vpbank.sqlitesimple;

import java.util.regex.Pattern;

public class PasswordUtil {

    public static boolean onPassConfirm(String data) {
        if (!hasLength(data)) return false;
        else if (!hasSymbol(data)) return false;
        else if (!hasNumber(data)) return false;
        else if (!hasLowerCase(data)) return false;
        else if (!hasUpperCase(data)) return false;
        else return true;
    }

    private static boolean hasLength(String data) {
        if (data.length() >= 8) return true;
        else return false;
    }

    private static boolean hasSymbol(String password) {
        return !password.matches("[A-Za-z0-9 ]*");
    }

    private static boolean hasUpperCase(String password) {
        return !password.equals(password.toLowerCase());
    }

    private static boolean hasLowerCase(String password) {
        return !password.equals(password.toUpperCase());
    }

    private static boolean hasNumber(String password) {
        String regex = "(.)*(\\d)(.)*";
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(password).matches();
    }
}
