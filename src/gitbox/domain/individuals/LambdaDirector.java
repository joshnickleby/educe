package gitbox.domain.individuals;

import show.domain.StringCipher;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaDirector {

    // Your options for cipher algorithms - find the right one
    public static List<String> cipherTypes = Arrays.asList(
            "AES", "BES", "CES", "DES"
    );

    // The alphanumeric list for the caesar cipher
    public static List<String> alphabet = Arrays.asList(
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z", "A", "B", "C", "D",
            "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z", " ", "!"
    );


    // remove Mr. MeeSeeks phrase from the string
    public static Function<String, String> removeMeeSeek = string -> {
        return string;
    };

    // decrypt with StringCipher
    public static BiFunction<String, StringCipher, String> decrypt = (string, cipher) -> {
        return cipher.decrypt(string, "DES");
    };

    // A basic caesar cipher. Figure out which index it was switched to.
    public static Function<String, String> caesarCipher = string -> {
        return string;
    };

    // for each word replace the first set of numbers with the character
    public static Function<String, String> revertNumberBeginning = string -> {
        return string;
    };

    // turn every number into a character
    public static Function<String, String> listOfStringNumbers = string -> {
        return string;
    };

    // reverse the numbers in the string
    public static Function<String, String> individualNumbers = string -> {
        return string;
    };

    // reverse the string
    public static Function<String, String> reverseString = string -> {
        return string;
    };

    /** NEED A HINT? CHECKOUT gitbox.include.show.Hints **/

}
