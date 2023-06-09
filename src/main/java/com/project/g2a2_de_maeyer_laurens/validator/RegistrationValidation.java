package com.project.g2a2_de_maeyer_laurens.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegistrationValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Registration.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Registration registration = (Registration) target;
        if (!registration.getPassword().equals(registration.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "password.mismatch", "Passwords do not match");
        }
    }
}
