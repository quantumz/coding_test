import java.io.*;
import java.util.HashMap;

public class CodingTest {

    /** 
        Given two strings of arbitrary length as input, S1 is capital letters. S2 is list of animals separated by spaces.
        Describe an algorithm that will check for a pattern equivilancy between the strings. 
                Ex. S1="ABBA" S2="CAT DOG DOG CAT". Show that the pattern is equivilant. 
                + "ABBA" = "CAT DOG DOG CAT" > true 
                + "ABBA" = "CAT CAT DOG CAT" > false
                + "ABBBAA" = "CAT DOG DOG DOG CAT CAT" > true
                + "ABBZ" = "CAT DOG DOG ELEPHANT" > true

        @param keys key string S1
        @param values value string S2
 
        @return true if key string and data string match
     */
    public static boolean isMatch(String keys, String values) {
        HashMap matchMap = new HashMap<>();
        String[] explodedValues = values.split(" "); 

        if (keys.length() != explodedValues.length)
            return false;

        for (int i = 0; i < keys.length(); i++) {

            char key = keys.charAt(i);

            if(!matchMap.containsKey(key)) {
                if(matchMap.containsValue(explodedValues[i])) {
                    return false;
                }
                else {
                    matchMap.put(key, explodedValues[i]);
                }
            }
            else if(!(matchMap.get(key)).equals(explodedValues[i]))  {
                return false;
            }
        }

        return true;
    }

    /** 
        Example usage: `java CodingTest ABBA "CAT DOG DOG CAT"`
     */
    public static void main(String[] args) {
        String keys = args[0];
        String values = args[1];

        boolean result = isMatch(keys, values);
        System.out.println(result);
    }
}
    

