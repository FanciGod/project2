package standardized.Phone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPhoneNumber {
    public static boolean regexPhoneVN(String phoneNum) {
        Pattern pattern = Pattern.compile("(84|0[3|5|7|8|9])+([0-9]{8})\\b");
        Matcher matcher = pattern.matcher(phoneNum);
        return matcher.matches();
    }
}
