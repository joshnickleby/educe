package gitbox.domain;

import gitbox.domain.individuals.LambdaDirector;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Decrypt implements Supplier<String> {

    // This starts as a cipher text and ends as a plain text
    private String cipherText;

    /**
     *  The different functions for decrypting. They are out of order so you have to
     *  figure out the order. The decrypt function lives in the run part of the class.
     **/
    public List<Function<String, String>> decryptions = Arrays.asList(
            LambdaDirector.individualNumbers,
            LambdaDirector.listOfStringNumbers,
            LambdaDirector.removeMeeSeek,
            LambdaDirector.reverseString,
            LambdaDirector.caesarCipher,
            LambdaDirector.revertNumberBeginning
    );

    /** Interface method
     *
     *  Creates the cipher text (needs a new key every time it runs), gets the encrypted string,
     *  then runs each function in sequence.
     **/
    @Override
    public String get() {

        show.domain.StringCipher sc = new show.domain.StringCipher();

        sc.encrypt();

        cipherText = sc.getEncryptedString();

        System.out.println(cipherText);

        cipherText = LambdaDirector.decrypt.apply(cipherText, sc);

        for(int i = 0; i < decryptions.size(); i++) {
            cipherText = decryptions.get(i).apply(cipherText);
            System.out.println((1+i) + " : " + cipherText);
        }

        return cipherText;
    }
}
