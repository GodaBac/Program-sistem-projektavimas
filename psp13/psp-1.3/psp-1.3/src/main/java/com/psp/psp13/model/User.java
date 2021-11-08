package com.psp.psp13.model;


import validation.EmailValidator;
import validation.PasswordChecker;
import validation.PhoneValidator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;



@Entity
public class User implements Comparable<User>{

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String address;
    private String password;

    public User(){}

    public User(Long userId, String name, String surname, String phoneNumber, String email, String address, String password){
        super();
        //userFieldsValidation(name, surname, phoneNumber, email, address, password);
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
        this.userId = userId;
    }

    public User(String name, String surname, String phoneNumber, String email, String address, String password){
        super();
        //userFieldsValidation(name, surname, phoneNumber, email, address, password);
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
         this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
         this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(email, user.email) && Objects.equals(address, user.address) && Objects.equals(password, user.password);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, password);
    }

    public boolean isPhoneNumberValid(String phoneNumber){
//        PhoneValidator phoneValidator = new PhoneValidator();
//        if (!phoneValidator.validateNumbers(phoneNumber)
//                || !phoneValidator.validatePrefix(phoneNumber)
//                //|| !phoneValidator.numberLength(phoneNumber,12)
//               // || !phoneValidator.checkCountryCode(phoneNumber, "Lithuania")
//            )
//            throw new IllegalArgumentException("INVALID PHONE NUMBER");
//        else return true;
        return true;
    }

    public boolean isEmailValid(String email){
//        EmailValidator emailValidator = new EmailValidator();
//        if (!emailValidator.notEmpty(email)
//                || !emailValidator.hasAtSign(email)
//                || !emailValidator.checkBadSymbols(email)
//                || !emailValidator.correctDomainCheck(email)
//                || !emailValidator.correctTLDCheck(email))
//            throw new IllegalArgumentException("INVALID EMAIL");
//        else return true;
        return true;
    }

    public boolean isPasswordValid(String password){
//        PasswordChecker passwordChecker = new PasswordChecker();
//        if (!passwordChecker.passwordLength(password, 8)
//                || !passwordChecker.hasSpecialCharacter(password)
//                || !passwordChecker.hasUpperCase(password))
//            throw new IllegalArgumentException("INVALID PASSWORD");
//        else return true;
        return true;
    }


    @Override
    public int compareTo(User o) {
        return 0;
    }
}
