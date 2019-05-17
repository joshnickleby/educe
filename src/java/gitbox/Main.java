package gitbox;

import gitbox.domain.Decrypt;
import gitbox.domain.individuals.LambdaDirector;
import gitbox.domain.tests.DecryptTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {

    public static List<Function<String, String>> decryptions = Arrays.asList(
            LambdaDirector.individualNumbers,
            LambdaDirector.listOfStringNumbers,
            LambdaDirector.removeMeeSeek,
            LambdaDirector.reverseString,
            LambdaDirector.caesarCipher,
            LambdaDirector.revertNumberBeginning
    );

    /**
     * First runs the tests and then runs the actual decoding algorithm (comment out things if needed)
     **/
    public static void main(String[] args) {
        Decrypt decrypt = new Decrypt();

        DecryptTest dt = new DecryptTest(LambdaDirector.decrypt, decryptions);
        dt.runTest(DecryptTest.AlgoOptions.ALL);

        String plaintext = decrypt.get();

        dt.testFinal(plaintext);
    }
}
