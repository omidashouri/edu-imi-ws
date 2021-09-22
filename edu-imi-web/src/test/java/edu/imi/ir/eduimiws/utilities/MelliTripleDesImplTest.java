package edu.imi.ir.eduimiws.utilities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MelliTripleDesImplTest {

    @Autowired
    MelliTripleDesImpl melliTripleDesImpl;

    @Test
    void test1() throws Exception {

        System.out.println("---------MELLI--------");

//        MelliTripleDesImpl melliTripleDes = new MelliTripleDesImpl();
        String encrypted = melliTripleDesImpl.encrypt("salam");
        System.out.println("Encypted: >> "+encrypted);
        String decrypted = melliTripleDesImpl.decrypt(encrypted);
        System.out.println("Decrypted: >>"+decrypted);

        System.out.println("Decrypted bank Sample: >>   "+ melliTripleDesImpl.encryptBankSample("salam","XZewVTUH9U+hQgMCjMu9mKmF9srWLN/y"));
//        pKp4/m+AFSA=
    }

    @Test
    void test2(){
        String text1 = "مديريت فرآيندهاي كسب وكار نوبت يك";
        System.out.println(text1);

        String text2 = text1
                .replaceAll("\u064A","\u06CC")
                .replaceAll("\u0643","\u06A9");

        System.out.println(text2);

    }
}