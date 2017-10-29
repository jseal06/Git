//2nd_B
import java.util.Objects;

/**
 * Driver class for the StringAnalyser class of Coursework 1
 * in the Software and Programming II module at BBK in 2017/8.
 *
 * @author Carsten Fuhs
 */
public class Coursework1Main {

    /* The following is a tiny "home-grown" testing framework.
     * We will see a more advanced framework, JUnit, later in the module.
     */

    /** Index value for the next test. */
    private static int testNo = 1;

    /** Number of passed tests. */
    private static int passes = 0;

    /** Number of failed tests. */
    private static int fails = 0;

    /** Output for successful test. */
    private static final String YEA = "PASSED";

    /** Output for unsuccessful test. */
    private static final String NAY = "FAILED";

    /**
     * Acceptable distance from expected value for double values,
     * should be slightly above 0.
     */
    private static final double DELTA = 1e-9;

    /**
     * Tests two int values for equality.
     *
     * Side effects: screen output of test result and increment of static
     * counter variables according to result.
     *
     * @param description  to be used as part of the screen output
     * @param expected  the expected value
     * @param actual  the actual value
     */
    public static void testIntEqual(String description, int expected, int actual) {
        sideEffectsForTest(description, expected + "", actual + "",
            expected == actual);
    }

    /**
     * Tests two double values for equality (up to a small "delta").
     *
     * Side effects: screen output of test result and increment of static
     * counter variables according to result.
     *
     * @param description  to be used as part of the screen output
     * @param expected  the expected value
     * @param actual  the actual value
     */
    public static void testDoubleEqual(String description, double expected, double actual) {
        sideEffectsForTest(description, expected + "", actual + "",
            expected - DELTA <= actual && actual <= expected + DELTA);
        // small rounding errors are ok
    }

    /**
     * Tests two String values for equality.
     *
     * Side effects: screen output of test result and increment of static
     * counter variables according to result.
     *
     * @param description  to be used as part of the screen output
     * @param expected  the expected value
     * @param actual  the actual value
     */
    public static void testStringEqual(String description, String expected, String actual) {
        sideEffectsForTest(description, expected, actual,
            Objects.equals(expected, actual));
        // Objects.equals is graceful on null
    }

    /**
     * Helper method for the side effects of the tests for different data types
     * (here already converted to Strings): screen output and increment of
     * static counter variables.
     *
     * @param description  description of the test to be printed
     * @param expected  String representation of the expected value
     * @param actual  String representation of the actual value
     * @param result  true: test has passed; false: test has failed
     */
    private static void sideEffectsForTest(String description, String expected, String actual, boolean result) {
        String output;
        if (result) {
            passes++;
            output = YEA;
        } else {
            fails++;
            output = NAY;
        }
        System.out.println("Test " + testNo + ": " + description
            + ", expected: " + expected + ", actual: " + actual
            + " ===> " + output);
        testNo++;
    }

    /* The code to test our StringAnalyser in particular starts here. */

    /**
     * Constants for use in the tests.
     */
    private static final String STRING1 = "Hi";
    private static final String STRING2 = "H" + 'i';
    private static final String STRING3 = "Alice";
    private static final String STRING4 = "Bob";
    private static final String STRING5 = "Charlie";
    private static final String STRING6 = "BBK";
    private static final String STRING7 = "small 1234";
    private static final String STRING8 = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz 2017";


    public static void main(String[] args) {
        StringAnalyser analyser = new StringAnalyser();
        testStringEqual("toString", "[]", analyser.toString());
        testStringEqual("getGreatest", null, analyser.getGreatest());
        testIntEqual("numberOfStrings", 0, analyser.numberOfStrings());
        testIntEqual("numberOfUniqueStrings", 0, analyser.numberOfUniqueStrings());
        testIntEqual("totalLength", 0, analyser.totalLength());
        testIntEqual("numberOfStringsWithUpperCaseChars", 0, analyser.numberOfStringsWithUpperCaseChars());
        testDoubleEqual("average", -1.0, analyser.averageLength());

        analyser.add(STRING1);
        testStringEqual("toString", "[" + STRING1 + "]", analyser.toString());
        testStringEqual("getGreatest", STRING1, analyser.getGreatest());
        testIntEqual("numberOfStrings", 1, analyser.numberOfStrings());
        testIntEqual("numberOfUniqueStrings", 1, analyser.numberOfUniqueStrings());
        testIntEqual("totalLength", 2, analyser.totalLength());
        testIntEqual("numberOfStringsWithUpperCaseChars", 1, analyser.numberOfStringsWithUpperCaseChars());
        testDoubleEqual("average", 2.0, analyser.averageLength());

        analyser.add(STRING2);
        testStringEqual("toString", "[" + STRING1 + ", " + STRING2 + "]", analyser.toString());
        testStringEqual("getGreatest", STRING1, analyser.getGreatest());
        testIntEqual("numberOfStrings", 2, analyser.numberOfStrings());
        testIntEqual("numberOfUniqueStrings", 1, analyser.numberOfUniqueStrings());
        testIntEqual("totalLength", 4, analyser.totalLength());
        testIntEqual("numberOfStringsWithUpperCaseChars", 2, analyser.numberOfStringsWithUpperCaseChars());
        testDoubleEqual("average", 2.0, analyser.averageLength());

        analyser.add(null);
        testStringEqual("toString", "[" + STRING1 + ", " + STRING2 + "]", analyser.toString());
        testStringEqual("getGreatest", STRING1, analyser.getGreatest());
        testIntEqual("numberOfStrings", 2, analyser.numberOfStrings());
        testIntEqual("numberOfUniqueStrings", 1, analyser.numberOfUniqueStrings());
        testIntEqual("totalLength", 4, analyser.totalLength());
        testIntEqual("numberOfStringsWithUpperCaseChars", 2, analyser.numberOfStringsWithUpperCaseChars());
        testDoubleEqual("average", 2.0, analyser.averageLength());

        analyser.addAll(new String[]{ STRING4, STRING6 });
        testStringEqual("getGreatest", STRING1, analyser.getGreatest());
        testIntEqual("numberOfStrings", 4, analyser.numberOfStrings());
        testIntEqual("numberOfUniqueStrings", 3, analyser.numberOfUniqueStrings());
        testIntEqual("totalLength", 10, analyser.totalLength());
        testIntEqual("numberOfStringsWithUpperCaseChars", 4, analyser.numberOfStringsWithUpperCaseChars());
        testDoubleEqual("average", 2.5, analyser.averageLength());

        analyser.reset();
        testStringEqual("toString", "[]", analyser.toString());
        testStringEqual("getGreatest", null, analyser.getGreatest());
        testIntEqual("numberOfStrings", 0, analyser.numberOfStrings());
        testIntEqual("numberOfUniqueStrings", 0, analyser.numberOfUniqueStrings());
        testIntEqual("totalLength", 0, analyser.totalLength());
        testIntEqual("numberOfStringsWithUpperCaseChars", 0, analyser.numberOfStringsWithUpperCaseChars());
        testDoubleEqual("average", -1.0, analyser.averageLength());

        String[] myStrings = { STRING3, STRING4, STRING5 };
        analyser = new StringAnalyser(myStrings);
        testStringEqual("getGreatest", STRING5, analyser.getGreatest());
        testIntEqual("numberOfStrings", 3, analyser.numberOfStrings());
        testIntEqual("numberOfUniqueStrings", 3, analyser.numberOfUniqueStrings());
        testIntEqual("totalLength", 15, analyser.totalLength());
        testIntEqual("numberOfStringsWithUpperCaseChars", 3, analyser.numberOfStringsWithUpperCaseChars());
        testDoubleEqual("average", 5.0, analyser.averageLength());

        System.out.println();
        System.out.println(YEA + ": " + passes);
        System.out.println(NAY + ": " + fails);
    }

    /*

Test 1: toString, expected: [], actual: [] ===> PASSED
Test 2: getGreatest, expected: null, actual: null ===> PASSED
Test 3: numberOfStrings, expected: 0, actual: 0 ===> PASSED
Test 4: numberOfUniqueStrings, expected: 0, actual: 0 ===> PASSED
Test 5: totalLength, expected: 0, actual: 0 ===> PASSED
Test 6: numberOfStringsWithUpperCaseChars, expected: 0, actual: 0 ===> PASSED
Test 7: average, expected: -1.0, actual: -1.0 ===> PASSED
Test 8: toString, expected: [Hi], actual: [Hi] ===> PASSED
Test 9: getGreatest, expected: Hi, actual: Hi ===> PASSED
Test 10: numberOfStrings, expected: 1, actual: 1 ===> PASSED
Test 11: numberOfUniqueStrings, expected: 1, actual: 1 ===> PASSED
Test 12: totalLength, expected: 2, actual: 2 ===> PASSED
Test 13: numberOfStringsWithUpperCaseChars, expected: 1, actual: 1 ===> PASSED
Test 14: average, expected: 2.0, actual: 2.0 ===> PASSED
Test 15: toString, expected: [Hi, Hi], actual: [Hi, Hi] ===> PASSED
Test 16: getGreatest, expected: Hi, actual: Hi ===> PASSED
Test 17: numberOfStrings, expected: 2, actual: 2 ===> PASSED
Test 18: numberOfUniqueStrings, expected: 1, actual: 1 ===> PASSED
Test 19: totalLength, expected: 4, actual: 4 ===> PASSED
Test 20: numberOfStringsWithUpperCaseChars, expected: 2, actual: 2 ===> PASSED
Test 21: average, expected: 2.0, actual: 2.0 ===> PASSED
Test 22: toString, expected: [Hi, Hi], actual: [Hi, Hi] ===> PASSED
Test 23: getGreatest, expected: Hi, actual: Hi ===> PASSED
Test 24: numberOfStrings, expected: 2, actual: 2 ===> PASSED
Test 25: numberOfUniqueStrings, expected: 1, actual: 1 ===> PASSED
Test 26: totalLength, expected: 4, actual: 4 ===> PASSED
Test 27: numberOfStringsWithUpperCaseChars, expected: 2, actual: 2 ===> PASSED
Test 28: average, expected: 2.0, actual: 2.0 ===> PASSED
Test 29: getGreatest, expected: Hi, actual: Hi ===> PASSED
Test 30: numberOfStrings, expected: 4, actual: 4 ===> PASSED
Test 31: numberOfUniqueStrings, expected: 3, actual: 3 ===> PASSED
Test 32: totalLength, expected: 10, actual: 10 ===> PASSED
Test 33: numberOfStringsWithUpperCaseChars, expected: 4, actual: 4 ===> PASSED
Test 34: average, expected: 2.5, actual: 2.5 ===> PASSED
Test 35: toString, expected: [], actual: [] ===> PASSED
Test 36: getGreatest, expected: null, actual: null ===> PASSED
Test 37: numberOfStrings, expected: 0, actual: 0 ===> PASSED
Test 38: numberOfUniqueStrings, expected: 0, actual: 0 ===> PASSED
Test 39: totalLength, expected: 0, actual: 0 ===> PASSED
Test 40: numberOfStringsWithUpperCaseChars, expected: 0, actual: 0 ===> PASSED
Test 41: average, expected: -1.0, actual: -1.0 ===> PASSED
Test 42: getGreatest, expected: Charlie, actual: Charlie ===> PASSED
Test 43: numberOfStrings, expected: 3, actual: 3 ===> PASSED
Test 44: numberOfUniqueStrings, expected: 3, actual: 3 ===> PASSED
Test 45: totalLength, expected: 15, actual: 15 ===> PASSED
Test 46: numberOfStringsWithUpperCaseChars, expected: 3, actual: 3 ===> PASSED
Test 47: average, expected: 5.0, actual: 5.0 ===> PASSED

PASSED: 47
FAILED: 0

     */

}
