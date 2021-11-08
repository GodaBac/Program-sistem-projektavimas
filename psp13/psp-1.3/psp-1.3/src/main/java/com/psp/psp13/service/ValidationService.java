package com.psp.psp13.service;

import com.psp.psp13.model.User;
import org.springframework.stereotype.Service;
import validation.EmailValidator;
import validation.PasswordChecker;
import validation.PhoneValidator;

@Service
public class ValidationService {
    EmailValidator emailValidator = new EmailValidator();
    PhoneValidator phoneValidator = new PhoneValidator();
    PasswordChecker passwordChecker = new PasswordChecker();

    public void validate (User user) {
        if (!emailValidator.validateAt(user.getEmail()))
            throw new IllegalArgumentException("Invalid email address");
        if(!phoneValidator.validateNumbers(user.getPhoneNumber()))
            throw new IllegalArgumentException("Invalid phone number");
        if(passwordChecker.validate((user.getPassword()), 8, 20))
            throw new IllegalArgumentException("Invalid password");

    }
}
