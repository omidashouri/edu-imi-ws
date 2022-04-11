package edu.imi.ir.eduimiws.utilities;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MelliTripleDesImplTest {

    @Autowired
    MelliTripleDesImpl melliTripleDesImpl;

    @Disabled
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

    @Disabled
    @Test
    void test2(){
        String text1 = "مديريت فرآيندهاي كسب وكار نوبت يك";
        System.out.println(text1);

        String text2 = text1
                .replaceAll("\u064A","\u06CC")
                .replaceAll("\u0643","\u06A9");

        System.out.println(text2);

    }

    @Test
    void test3(){
        CommonUtils commonUtils = new CommonUtils();
/*        ContactRequestForPaymentCode contactRequestForPaymentCode = new ContactRequestForPaymentCode();
        contactRequestForPaymentCode.setFirstName("string");
        contactRequestForPaymentCode.setLastName("");
        contactRequestForPaymentCode.setNationCode("1361");*/

        PersonEntity person = new PersonEntity();
        person.setAddress("string");
        person.setLastName("ali");

        commonUtils.nullInstanceFieldsForValues(person, List.of("string",""));
        System.out.println("sss");
    }
}