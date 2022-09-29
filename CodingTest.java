import java.io.*;
import java.util.HashMap;

public class CodingTest {

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

    public static void main(String[] args) {
        String keys = new String("ABBA");
        String values = new String("CAT DOG DOG CAT");

        boolean result = isMatch(keys, values);
        System.out.println(result);
    }
}
    

