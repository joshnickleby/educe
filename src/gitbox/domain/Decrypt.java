package gitbox.domain;

import gitbox.domain.individuals.LambdaDirector;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Decrypt implements Runnable {

    private String cipherText;

    private List<Function<String, String>> decryptions = Arrays.asList(
            LambdaDirector.individualNumbers,
            LambdaDirector.listOfStringNumbers,
            LambdaDirector.removeMeeSeek,
            LambdaDirector.reverseString,
            LambdaDirector.caesarCipher,
            LambdaDirector.revertNumberBeginning
    );

    @Override
    public void run() {

        show.domain.StringCipher sc = new show.domain.StringCipher();

        sc.encrypt();

        cipherText = sc.getEncryptedString();

        System.out.println(cipherText);

        cipherText = LambdaDirector.decrypt.apply(cipherText, sc);

        for(int i = 0; i < decryptions.size(); i++) {
            cipherText = decryptions.get(i).apply(cipherText);
            System.out.println((1+i) + " : " + cipherText);
        }

    }
}
