package businessRequirements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PasswordChecker {
    public boolean hasLengthRequirement(String input, int requiredLength)
    {
        if (input == null || input == "" || input.length()<requiredLength)
            return false;
        else
            return true;
    }
    public boolean hasUppercaseLetter(String input) throws IOException
    {
        File f = new File("src/businessRequirements/uppercaseLetters");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String validSymbols="";
        int c=0;
        while ((c=br.read()) != -1)
        {
            char character = (char) c;
            validSymbols = validSymbols + character;
        }
        boolean flag = false;
        for(int x=0; x<input.length(); x++)
        {
            for(int i=0; i<validSymbols.length(); i++)
            {
                if(input.charAt(x)==validSymbols.charAt(i))
                    flag = true;
            }
        }
        if (flag==false)
            return false;
        return true;
    }
    public boolean hasSpecialCharacter(String input) throws IOException
    {
        //darbas su failu
        File f = new File("src/businessRequirements/specialCharacters");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String validSymbols="";
        int c=0;
        while ((c=br.read()) != -1)
        {
            char character = (char) c;
            validSymbols = validSymbols + character;
        }
        boolean flag = false;
        //input tikrinimas
        for(int x=0; x<input.length(); x++)
        {
            for(int i=0; i<validSymbols.length(); i++)
            {
                if(input.charAt(x)==validSymbols.charAt(i))
                    flag = true;
            }
        }
        if (flag==false)
            return false;
        return true;
    }
}
