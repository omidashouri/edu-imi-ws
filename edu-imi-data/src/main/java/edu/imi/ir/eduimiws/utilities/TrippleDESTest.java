package edu.imi.ir.eduimiws.utilities;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.spec.KeySpec;

public class TrippleDESTest {

    private static final String UNICODE_FORMAT = "UTF8";
//    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    public static final String DESEDE_ENCRYPTION_SCHEME = "TripleDES/ECB/PKCS5Padding";
    private KeySpec ks;
    private SecretKeyFactory skf;
    private Cipher cipher;
    byte[] myEncryptionKeyBytes;
    private String myEncryptionKey;
    private String myEncryptionScheme;
    SecretKey key;

    public TrippleDESTest() throws Exception {
        myEncryptionKey = "XZewVTUH9U+hQgMCjMu9mKmF9srWLN/y";
        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        myEncryptionKeyBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        //copy 24 byte
        ks = new DESedeKeySpec(myEncryptionKeyBytes);
//        skf = SecretKeyFactory.getInstance(myEncryptionScheme);
        skf = SecretKeyFactory.getInstance("TripleDES");
        cipher = Cipher.getInstance(myEncryptionScheme);
        key = skf.generateSecret(ks);
    }


    public String encrypt(String unencryptedString) {
        String encryptedString = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = new String(Base64.encodeBase64(encryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }


    public String decrypt(String encryptedString) {
        String decryptedText=null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.decodeBase64(encryptedString);
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedText= new String(plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }


    public void test() throws Exception
    {

        String target="salam";
        String encrypted=this.encrypt(target);
        String decrypted=this.decrypt(encrypted);

        System.out.println("String To Encrypt: "+ target);
        System.out.println("Encrypted String:" + encrypted);
        System.out.println("Decrypted String:" + decrypted);

    }
}
