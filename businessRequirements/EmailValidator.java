package businessRequirements;

import java.io.*;


public class EmailValidator {
    public boolean hasAtSymbol(String input) {
        if (input == null)
            return false;
        else if (input == "")
            return false;
        else {
            for (int x=0; x<input.length(); x++)
            {
                if (input.charAt(x)=='@')
                    return true;
            }
            return false;
        }


    }
    public boolean hasInvalidSymbol(String input) throws IOException{
        File f = new File("src/businessRequirements/validSymbolsEmail");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String validSymbols="";
        int c=0;
        while ((c=br.read()) != -1)
        {
            char character = (char) c;
            validSymbols = validSymbols + character;
        }
        for(int x=0; x<input.length(); x++)
        {
            boolean flag = false;
            for(int i=0; i<validSymbols.length(); i++)
            {
                if(input.charAt(x)==validSymbols.charAt(i))
                    flag = true;
            }
            if (flag==false)
            {
                return false;
            }
        }
        return true;
    }
    public boolean domainValidator(String input) throws IOException{
        File f = new File("src/businessRequirements/validSymbolsLowercaseLetters");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String validSymbols="";
        int c=0;
        while ((c=br.read()) != -1)
        {
            char character = (char) c;
            validSymbols = validSymbols + character;
        }
        String[] cutAt = input.split("\\@");
        String inputWithoutName = cutAt[1];
        String[] cutDot = inputWithoutName.split("\\.");
        String secondLevelDomain = cutDot[0];
        if (secondLevelDomain == null || secondLevelDomain == "" || secondLevelDomain.length() == 0)
            return false;
        else
            for(int x=0; x<secondLevelDomain.length(); x++)
            {
                boolean flag = false;
                for(int i=0; i<validSymbols.length(); i++)
                {
                    if(secondLevelDomain.charAt(x)==validSymbols.charAt(i))
                        flag = true;
                }
                if (flag==false)
                {
                    return false;
                }
            }
        return true;
    }
    public boolean topLevelDomainValidator(String input) throws IOException{
        File f = new File("src/businessRequirements/validSymbolsLowercaseLetters");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String validSymbols="";
        int c=0;
        while ((c=br.read()) != -1)
        {
            char character = (char) c;
            validSymbols = validSymbols + character;
        }
        String[] cutAt = input.split("\\@");
        String inputWithoutName = cutAt[1];
        String[] cutDot = inputWithoutName.split("\\.");
        String topLevelDomain = cutDot[1];
        if (topLevelDomain == null || topLevelDomain == "" || topLevelDomain.length() == 0)
            return false;
        else
            for(int x=0; x<topLevelDomain.length(); x++)
            {
                boolean flag = false;
                for(int i=0; i<validSymbols.length(); i++)
                {
                    if(topLevelDomain.charAt(x)==validSymbols.charAt(i))
                        flag = true;
                }
                if (flag==false)
                {
                    return false;
                }
            }
        return true;
    }

}
