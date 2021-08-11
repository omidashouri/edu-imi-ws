package edu.imi.ir.eduimiws.utilities;

import org.junit.jupiter.api.Test;

class MelliTripleDesTest {

    @Test
    void test1() throws Exception {
/*        */

        TrippleDe trippleDe = new TrippleDe();
        System.out.println(
        trippleDe._encrypt("salam","XZewVTUH9U+hQgMCjMu9mKmF9srWLN/y")
        );

        System.out.println(
        trippleDe._decrypt("qg8eLRKKHUo=","XZewVTUH9U+hQgMCjMu9mKmF9srWLN/y")
        );
        System.out.println("-----------------");

        TrippleDESTest trippleDESTest = new TrippleDESTest();
        trippleDESTest.test();

/*        MelliTripleDes melliTripleDes = new MelliTripleDes();
        melliTripleDes.test();*/
//
//        PR+yYZk26DU=
    }
}