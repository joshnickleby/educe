package gitbox;

import gitbox.domain.Decrypt;
import gitbox.domain.individuals.LambdaDirector;
import show.test.DecryptTest;

public class Main {

    /** First runs the tests and then runs the actual decoding algorithm (comment out things if needed) **/
    public static void main(String[] args) {
        Decrypt decrypt = new Decrypt();

        DecryptTest dt = new DecryptTest(LambdaDirector.decrypt, decrypt.decryptions);
        dt.runTest("all");

        decrypt.run();
    }
}
