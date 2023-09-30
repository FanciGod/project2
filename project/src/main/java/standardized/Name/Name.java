package standardized.Name;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Name {
    public static String standardName(String s) {
        s = s.trim();
        s = s.replaceAll("\\s+" , " ");
        s = s.toLowerCase();
        StringTokenizer st = new StringTokenizer(s, " ");
        StringBuilder stringBuilder = new StringBuilder();
        s = "";

        while (st.hasMoreElements()) {
            String temp1 = st.nextToken();
            stringBuilder.append(String.valueOf(temp1.charAt(0)).toUpperCase()).append(temp1.substring(1));
            if (st.hasMoreTokens()) {
                stringBuilder.append(" ");
            }
        }
        s = stringBuilder.toString();
        return s;
    }
}
