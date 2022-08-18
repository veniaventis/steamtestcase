package parse_util;

import org.jetbrains.annotations.NotNull;

public class ParsingString {

    protected static int parseStringToInt;

    public static int parseString(String parseString){

        parseStringToInt = Integer.parseInt(parseString.replaceAll("[^0-9]", ""));

        return parseStringToInt;
    }
}
