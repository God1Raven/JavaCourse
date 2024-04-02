import java.util.regex.Pattern;

public class Task8 {

    // Point 4
    public static boolean isPalindrom(String str){
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) != str.charAt(str.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
    // Point 5
    public static int countSubString(String str, String subStr){
        return str.split(Pattern.quote(subStr), -1).length - 1;
    }
}
