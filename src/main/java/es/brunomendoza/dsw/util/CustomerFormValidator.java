package es.brunomendoza.dsw.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerFormValidator {
    private static final String[] required = {
            "username",
            "password",
            "firstName",
            "lastName",
            "birthdate",
            "countryId",
            "address",
            "phoneNumber1",
            "email"
    };

    public static List<String> validate(Map<String, String> fields) {
        List<String> errors = new ArrayList<>();

        for (String field : CustomerFormValidator.required) {
            if (!fields.containsKey(field) || fields.get(field).isEmpty()) {
                errors.add(field);
            }
        }

        return errors;
    }
}
