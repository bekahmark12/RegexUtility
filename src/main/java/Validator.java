import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator implements RegexUtility {

    Pattern p = null;
    Matcher m = null;

    public boolean returnBoolean(String string, String regex){
        p = Pattern.compile(regex);
        m = p.matcher(string);
        return m.matches();
    }

    public boolean isValidHumanName(String name) {
        String regex = "^[\\p{L} .'-]+$";
        return returnBoolean(name, regex);
    }

    public boolean isValidEmailAddress(String email) {
        String regex = "^(.+)@(.+)$";
        return returnBoolean(email, regex);
    }

    public boolean isValidPhoneNumber(String phone) {
        String regex = "(?:\\d{3}-){2}\\d{4}";
        return returnBoolean(phone, regex);
    }

    public boolean isValidSSN(String ssn) {
        String regex = "^(?!666|000|9\\d{2})\\d{3}-(?!00)\\d{2}-(?!0{4})\\d{4}$";

//        ^ represents the starting of the string.
//        (?!666|000|9\\d{2})\\d{3} represents the first 3 digits should not starts with 000, 666, or between 900 and 999.
//        – represents the string followed by a hyphen (-).
//        (?!00)\\d{2} represents the next 2 digits should not starts with 00 and it should be any from 01-99.
//        – represents the string followed by a hyphen (-).
//        (?!0{4})\\d{4} represents the next 4 digits can’t 0000 and it should be any from 0001-9999.
//        $ represents the ending of the string.
        return returnBoolean(ssn, regex);
    }

    public boolean isValidUSStreetAddress(String street) {
        String regex = "\\d{1,5}\\s\\w.\\s(\\b\\w*\\b\\s){1,3}\\w*\\.";
        return returnBoolean(street, regex);
    }

    public boolean validatePasswordComplexity(String password, int minLength, int minUpper, int minLower, int minNumeric, int minSymbols) {
        String regex = "^(?=.*[0-9]{" + minNumeric + "})(?=.*[a-z]{" + minLower + "})(?=.*[A-Z]{" + minUpper + "})(?=.*[@#$%^&+=]" + minSymbols + "})(?=\\S+$).{" + minLength + ",}$";
        return returnBoolean(password, regex);

//        ^                 # start-of-string
//        (?=.*[0-9])       # a digit must occur at least once
//        (?=.*[a-z])       # a lower case letter must occur at least once
//        (?=.*[A-Z])       # an upper case letter must occur at least once
//        (?=.*[@#$%^&+=])  # a special character must occur at least once
//        (?=\S+$)          # no whitespace allowed in the entire string
//        .{8,}             # anything, at least eight places though
//        $                 # end-of-string
    }

    public int countContains(String needle, String haystack) {
        Matcher matcher = Pattern.compile(String.valueOf(needle)).matcher(haystack);
        int result = 0;
        while(matcher.find()) {
            result ++;
        }
        return result;
    }

    public String getHTMLTagContents(String html, String tagName) {
        String regex = "<" + tagName + ">(.+?)</" + tagName + ">";
        p = Pattern.compile(regex);
        m = p.matcher(html);

        String tagGroup = null;

        if(m.find()){
            //get the matching group
            tagGroup = m.group(1);
            //print the group
            //System.out.format("'%s'\n", tagGroup);
        }
        return tagGroup;
    }

    public ArrayList<String> getHTMLTagsContents(String html, String tagName){
        String regex = "<" + tagName + ">(.+?)</" + tagName + ">";
        p = Pattern.compile(regex);
        m = p.matcher(html);

        ArrayList<String> tags = new ArrayList<>();
        String tagGroup;

        while(m.find()){
            //get the matching group
            tagGroup = m.group(1);
            tags.add(tagGroup);
            //print the group
            //System.out.format("'%s'\n", tagGroup);
        }
        return tags;
    }

    public ArrayList<String> getHTMLLinkURL(String html) {
        ArrayList<String> results = new ArrayList<>();
        String regex = "<a href = (.+?)> </a>";
        p = Pattern.compile(regex);
        m = p.matcher(html);
        while(m.find()){
            results.add(m.group(1));
        }
        return results;
    }
}
