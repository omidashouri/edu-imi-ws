package edu.imi.ir.eduimiws.utilities;

import org.junit.jupiter.api.Test;

class MelliTripleDesTest {

    @Test
    void test1() throws Exception {

        System.out.println("---------MELLI--------");

        MelliTripleDes melliTripleDes = new MelliTripleDes();
        String encrypted = melliTripleDes.encrypt("salam");
        System.out.println("Encypted: >> "+encrypted);
        String decrypted = melliTripleDes.decrypt(encrypted);
        System.out.println("Decrypted: >>"+decrypted);

        System.out.println("Decrypted bank Sample: >>   "+melliTripleDes.encryptBankSample("salam","XZewVTUH9U+hQgMCjMu9mKmF9srWLN/y"));
//        qg8eLRKKHUo=
    }
}