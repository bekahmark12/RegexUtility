import java.util.ArrayList;

public interface RegexUtility {
        /**
         * Be sure to account for middle name, middle initial, and prefix (Mr, Ms, Miss, Mrs, Dr).  Ensure proper capitalization.
         * @param name the name to check
         * @return true if valid; otherwise false
         */
        boolean isValidHumanName(String name);


        /**
         * Username must be at least 1 non-numeric character.  After the first character and before the '@' can be any alpha (any case)
         * any numeric, and only the symbols '_' and '.'.
         * The domain name section must contain at least a 1 character sub-domain.  Again the first character must be alpha (in either case)
         * and the remaining characters can be alpha or numeric.  The top-level domain can be 3-4 alphanumeric characters of either case.
         * @param email the email address to check
         * @return true if valid; otherwise false
         */
        boolean isValidEmailAddress(String email);


        /**
         * Of the form CC-AAA-PPP-NNNN or C-AAA-PPP-NNNN or AAA-PPP-NNNN
         * Where CC is the two digit country code,
         * 		C is a one digit country code
         * 		AAA is a three digit area code
         *      NNNN is the four digit phone number
         * research which digits are allowed in which blocks in phone numbers (some have minimum values)
         * @param phone the phone number string to check
         * @return true if valid; else false
         */
        boolean isValidPhoneNumber(String phone);

        /**
         * A US compliant SSN
         * reserach what digits are allowed in which locations (some have minimum values)
         * @param ssn
         * @return
         */
        boolean isValidSSN(String ssn);

        /**
         * Finding a valid USPS address format can be challenging so we'll define our own. Â Here is the street address format we will consider valid for our purposes:Â Â (the parts in array braces are optional - an address may or may not contain them)

         * An address is:A street or house number (all numeric 1 or more digits)[Followed by a space followed by a compass direction (north, south, east, west)]Followed by a spaceFollowed by a street name (or number) (alphanumeric with possible spaces)[Followed by a space followed by a compass direction (north, south, east, west)][Followed by a space, followed by an unit number (a unit number is the string â€œApt#â€, â€œSuite#â€, or just â€œ#â€ followed by 1 or more digits]Followed by a new lineFollowed by a city name (which can includes multiple words)Followed by a comma[Followed by a space]Followed by a two character state ID code (like UT, or CA)Followed by an optional new line or a spaceFollowed by a 5 digit zip code or (a 5 digit code followed by a hyphen followed by a 4 digit zip postfix)
         * @param street
         * @return
         */
        boolean isValidUSStreetAddress(String street);


        /**
         * Validate that a given password matches the given complexity requirements
         * @param password the password to check
         * @param minLength the minimum length the password is allowed to be
         * @param minUpper the minimum number of upper case alpha characters the password must have
         * @param minLower the minimum number of lower case alpha characters the password must have
         * @param minNumeric the minimum number of numeric characters the password must have
         * @param minSymbols the minimum number of non-alphanumeric characters the password must have
         * @return
         */
        boolean validatePasswordComplexity(String password, int minLength, int minUpper, int minLower, int minNumeric, int minSymbols);


        /**
         * Report the number of times the string needle occurs in the string haystack
         * @param needle the string for which the method is to search
         * @param haystack the string in which the method should search
         * @return the number of times needle appears in haystack
         */
        int countContains(String needle, String haystack);


        /**
         * Get the content of the first occurence of an html tag given it's name and the html string in which it occurs
         * @param html the html string to be searched
         * @param tagName the tagName for which the inner content should be returned
         * @return
         */
        String getHTMLTagContents(String html, String tagName);


        /**
         * Get the content of all occurences of an html tag given it's name and the html string in which it occurs
         * @param html the html string to be searched
         * @param tagName the tagName for which the inner content should be returned
         * @return
         */
        ArrayList<String> getHTMLTagsContents(String html, String tagName);


        /**
         * For all occurrences of a link tag ("<a href=..") in the string html
         * return the URL to which the link goes
         * @param html the string to be searched
         * @return an array of link destinations
         */
        ArrayList<String> getHTMLLinkURL(String html);
}
