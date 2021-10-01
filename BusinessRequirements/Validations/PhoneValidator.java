package businessRequirements;

import java.io.*;

public class PhoneValidator {

    public boolean hasLetters (String input) throws IOException
    {
        File f = new File("src/businessRequirements/validSymbolsPhoneNumber");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String validSymbols="";
        int c=0;
        while ((c=br.read()) != -1)
        {
            char character = (char) c;
            validSymbols = validSymbols + character;
        }
        if(input == null || input == "")
            return false;
        else {
            for (int x = 0; x < input.length(); x++) {
                boolean flag = false;
                for (int i = 0; i < validSymbols.length(); i++) {
                    if (input.charAt(x) == validSymbols.charAt(i))
                        flag = true;
                }
                if (flag == false) {
                    return false;
                }
            }
            return true;
        }
    }
    public String numberFormat (String input)
    {
        String firstNumber = input.substring(0,1);
        if (firstNumber.equals("+"))
            return input;
        else
        {
            String numberWithoutPrefix = input.substring(1);
            String newNumber = "+370" + numberWithoutPrefix;
            return newNumber;
        }
    }
    public boolean differentCountryNumberValidation (String CountryLetters, String input) throws IOException
    {
        File f = new File("src/businessRequirements/validCountryPhoneNumbers");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String validSymbols="";
        String validCountries[] = new String[500];
        int z=0;
        int c=0;
        while ((c=br.read()) != -1)
        {
            char character = (char) c;
            if (character == ' ' || character == '\n' || c==13)
            {
                validCountries[z] = validSymbols;
                validSymbols = "";
                z++;
            }
            else
                validSymbols = validSymbols + character;
        }
        validCountries[z]=validSymbols;
        z++;
        for (int x=0; x<z; x+=4)
        {
            if (CountryLetters.equals(validCountries[x]))
            {
                if (validCountries[x+1].equals(input.substring(0, validCountries[x+1].length())))
                {
                    String s = String.valueOf(input.length());
                    if (validCountries[x+2].equals(s))
                        return true;
                }

            }
        }
        return false;


    }
}
