import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Validator v = new Validator();

    @Test
    void isValidHumanNameTest() {
        assertTrue(v.isValidHumanName("Rebekah"));
    }

    @Test
    void isValidHumanNameTest2() {
        assertFalse(v.isValidHumanName("1667653"));
    }

    @Test
    void isValidEmailAddressTest() {
        assertTrue(v.isValidEmailAddress("rmark@gmail.com"));
    }

    @Test
    void isValidEmailAddressTest2() {
        assertFalse(v.isValidEmailAddress("rmark"));
    }

    @Test
    void isValidPhoneNumberTest() {
        assertTrue(v.isValidPhoneNumber("801-555-5552"));
    }

    @Test
    void isValidPhoneNumberTest2() {
        assertFalse(v.isValidPhoneNumber("888888888888888888888888888"));
    }

    @Test
    void isValidSSNTest() {
        assertTrue(v.isValidSSN("333-99-9999"));
    }

    @Test
    void isValidSSNTest2() {
        assertFalse(v.isValidSSN("8888888888098d"));
    }

    @Test
    void isValidUSStreetAddressTest() {
        assertTrue(v.isValidUSStreetAddress("115 N. California Ave."));
    }

    @Test
    void isValidUSStreetAddressTest2() {
        assertFalse(v.isValidUSStreetAddress("123"));
    }

    @Test
    void validatePasswordComplexityTest() { assertTrue(v.validatePasswordComplexity("Password12!", 5, 1,2, 1, 1)); }
    @Test
    void validatePasswordComplexityTest2() { assertFalse(v.validatePasswordComplexity("Password12!", 30, 1,2, 1, 3)); }

    @Test
    void countContainsTest() {
        int answer = 2;
        int tester = v.countContains("o", "color");
        assertEquals(answer, tester);
    }

    @Test
    void testGetHTMLTagsContents(){

    }

    @Test
    void getHTMLTagContentsTest() {
        String answer = "answer";
        String html = "<p>answer</p>";
        String tester = v.getHTMLTagContents(html, "p");
        assertEquals(answer, tester);
    }

    @Test
    void getHTMLLinkURLTest() {
        String html = "<a href = 'www.neumont.com' <a/>";
        String url = "'www.neumont.com'";
        ArrayList<String> testList = v.getHTMLLinkURL(html);
        assertEquals(testList.get(0), url);
    }
}