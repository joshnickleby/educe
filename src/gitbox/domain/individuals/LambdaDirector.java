package gitbox.domain.individuals;

import show.domain.StringCipher;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaDirector {

    public static List<String> cipherTypes = Arrays.asList(
            "AES", "BES", "CES", "DES"
    );

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
        return string;
    };

    // for each letter, starting from the left, subtract its position from each character
    public static Function<String, String> caesarCipher = string -> {
        return string;
    };

    // for each word replace the first set of numbers with the character
    public static Function<String, String> revertNumberBeginning = string -> {
        return string;
    };

    // turn every letter into a number array
    public static Function<String, String> listOfStringNumbers = string -> {
        return string;
    };

    public static Function<String, String> individualNumbers = string -> {
        return string;
    };

    public static Function<String, String> reverseString = string -> {
        return string;
    };

}
