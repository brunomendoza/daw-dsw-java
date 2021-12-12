package es.brunomendoza.dsw.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginFormValidator {
    private static final List<String> fields = List.of("username", "password");

    public static List<String> validate(Map<String, String[]> fields) {
        List<String> errors = new ArrayList<>();

        for (String field: LoginFormValidator.fields) {
            if (!fields.containsKey(field) || fields.get(field)[0].isBlank()) {
                errors.add(field);
            }
        }

        return errors;
    }
}
