package businessRequirementsTest;

import businessRequirements.PhoneValidator;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class phoneValidatorTest {

    PhoneValidator phoneValidator = new PhoneValidator();

    //Tests for checking if number has letters or other symbols
    @Test
    void phoneValidator_HasLettersTrue() throws IOException {
        assertFalse(phoneValidator.hasLetters("+370622A2B62"));
        //should return false, phone number has letters
    }

    @Test
    void phoneValidator_HasInvalidSymbols() throws IOException{
        assertFalse(phoneValidator.hasLetters("+3706&2!2962"));
        //should return false, phone number has invalid symbols
    }

    @Test
    void phoneValidator_NoIvalidCharacters() throws IOException{
        assertTrue(phoneValidator.hasLetters("+37068615236"));
        //should return true, number does not have any letters
    }

    @Test
    void phoneValidator_StringEmpty() throws IOException{
        assertFalse(phoneValidator.hasLetters(""));
        //should return false, no number provided
    }

    @Test
    void phoneValidator_Null() throws IOException{
        assertFalse(phoneValidator.hasLetters(null));
        //should return false, null
    }

    //Tests to check if number format is valid and if format changes when needed (ex: 8 -> +370)
    @Test
    void phoneValidator_ValidFormat(){
        assertEquals("+37062242762", phoneValidator.numberFormat("+37062242762"));
        //format is valid, no changes needed
    }

    @Test
    void phoneValidator_InvalidFormat(){
        assertEquals("+37062242762", phoneValidator.numberFormat("862242762"));
        //format is invalid, changes needed
    }

    //Tests to check if numbers from different countries are valid (length and prefix)
    @Test
    void phoneValidator_DifferentCountryNumberLengthValid() throws IOException{
        assertTrue(phoneValidator.differentCountryNumberValidation("ENG", "+441237379541"));
        //should return true, length is correct
    }

    @Test
    void phoneValidator_DifferentCountryNumberPrefixValid() throws IOException{
        assertTrue(phoneValidator.differentCountryNumberValidation("FR", "+331237379541"));
        //should return true, prefix is correct
    }

}
