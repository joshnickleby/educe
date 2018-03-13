package gitbox.domain.tests;

import gitbox.domain.individuals.LambdaDirector;
import show.domain.StringCipher;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class DecryptTest {

    public enum AlgoOptions {
        MEESEEKS, DECRYPT, CAESAR_CIPHER, REVERT_NUMBER, NUMBER_STRING, INDIVIDUAL_NUMBERS, REVERSE, ALL
    }

    private List<Function<String, String>> functions;
    private BiFunction<String, StringCipher, String> cipherFunction;

    public static final String EXPECTED = "Great job!";
    public static final String MEESEEKS_REMOVAL_START = "Great _I'M_MR._MEESEEKS!_LOOK_AT_ME!_job!";
    public static final String CAESAR_CIPHER_START = "Juhdw1mre2";
    public static final String REVERT_NUMBER_BEGINNING_START = "0reatG 1ob!j";
    public static final String LIST_OF_STRING_NUMBERS = "71.114.101.97.116.32.106.111.98.33";
    public static final String INDIVIDUAL_NUMBERS = "17.411.101.79.611.23.601.111.89.33";
    public static final String REVERSE_STRING = "33.89.111.601.23.611.79.101.411.17";

    public DecryptTest(BiFunction<String, StringCipher, String> cipherFunction, List<Function<String, String>> functions) {
        this.cipherFunction = cipherFunction;
        this.functions = functions;
    }

    private Supplier<String> meeseeksRemovalTest = () -> {
        String actual = LambdaDirector.removeMeeSeek.apply(MEESEEKS_REMOVAL_START);
        return "TESTING REMOVAL OF MR MEESEEKS\n" + compare(actual, EXPECTED);
    };

    private Supplier<String> caesarCipherTest = () -> {
        String actual = LambdaDirector.caesarCipher.apply(CAESAR_CIPHER_START);
        return "TEST CAESAR CIPHER\n" + compare(actual, EXPECTED);
    };

    private Supplier<String> revertNumberBeginningTest = () -> {
        String actual = LambdaDirector.revertNumberBeginning.apply(REVERT_NUMBER_BEGINNING_START);
        return "TEST REVERT NUMBER BEGINNING\n" + compare(actual, EXPECTED);
    };

    private Supplier<String> listOfStringNumbersTest = () -> {
        String actual = LambdaDirector.listOfStringNumbers.apply(LIST_OF_STRING_NUMBERS);
        return "TEST LIST OF STRING NUMBERS\n" + compare(actual, EXPECTED);
    };

    private Supplier<String> individualNumbersTest = () -> {
        String actual = LambdaDirector.individualNumbers.apply(INDIVIDUAL_NUMBERS);
        return "TEST INDIVIDUAL NUMBERS\n" + compare(actual, LIST_OF_STRING_NUMBERS);
    };

    private Supplier<String> reverseString = () -> {
        String actual = LambdaDirector.reverseString.apply(REVERSE_STRING);
        return "TEST REVERSE STRING\n" + compare(actual, LIST_OF_STRING_NUMBERS);
    };

    public String compare(String actual, String expected) {
        return actual.equals(expected) ?
                "PASS: " + expected + "\n" :
                "FAIL - expected: " + expected + "\n\t\t actual: " + actual + "\n";
    }

    private List<Supplier<String>> ALL_TESTS = Arrays.asList(
            meeseeksRemovalTest, caesarCipherTest, revertNumberBeginningTest,
            listOfStringNumbersTest, individualNumbersTest, reverseString
    );

    public void runTest(AlgoOptions target) {

        String testResponses = "";

        switch(target) {
            case MEESEEKS: testResponses = meeseeksRemovalTest.get();
            case CAESAR_CIPHER: testResponses = caesarCipherTest.get();
            case REVERT_NUMBER: testResponses = revertNumberBeginningTest.get();
            case NUMBER_STRING: testResponses = listOfStringNumbersTest.get();
            case INDIVIDUAL_NUMBERS: testResponses = individualNumbersTest.get();
            case REVERSE: testResponses = reverseString.get();
            default: testResponses = ALL_TESTS.stream().map(Supplier::get).collect(Collectors.joining());
        }

        System.out.print(testResponses);
    }

    public void testFinal(String actual) {
        hiddenFinal(actual);
    }

    private void hiddenFinal(String actual) {
        System.out.println("FINAL TEST");
        System.out.println(
                actual.equals(finalString()) ? "PASS: " + actual :
                        "FAIL: " + actual
        );
    }

    private String finalString() {
        return "Megustalations! You have successfully completed the Git collaboration decryption challenge!";
    }
}
