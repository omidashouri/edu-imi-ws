package edu.imi.ir.eduimiws.utilities;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;

public class MelliTripleDes {
    private static final String UNICODE_FORMAT = "UTF8";
    public static final String TRIPLE_DES = "TripleDES";
    public static final String TRIPLE_DES_ECB_PKCS_7_PADDING = "TripleDES/ECB/PKCS5Padding";
//    public static final String TRIPLE_DES_ECB_PKCS_7_PADDING = "AES/ECB/PKCS7Padding";
    private KeySpec ks;
    private SecretKeyFactory skf;
    private SecretKeySpec secretKeySpec;
    private Cipher cipher;
    byte[] keyArrayBytes;
    private String myEncryptionKey;
    private String algorithm;
    private String transformationAlgorithm;
    SecretKey key;
    IvParameterSpec ivParameterSpec;

    public MelliTripleDes() throws Exception {
//        myEncryptionKey = "ThisIsSpartaThisIsSparta";
          myEncryptionKey = "XZewVTUH9U+hQgMCjMu9mKmF9srWLN/y";
        algorithm = TRIPLE_DES;
        transformationAlgorithm = TRIPLE_DES_ECB_PKCS_7_PADDING;
        keyArrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);

        secretKeySpec = new SecretKeySpec(keyArrayBytes,algorithm);
        cipher = Cipher.getInstance(transformationAlgorithm);

        byte[] iv = "a76nb5h9".getBytes();
        ivParameterSpec = new IvParameterSpec(iv);

        ks = new DESedeKeySpec(keyArrayBytes);
        skf = SecretKeyFactory.getInstance(algorithm);
        key = skf.generateSecret(ks);
    }


    public String encrypt(String unencryptedString) {
        String encryptedString = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
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
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
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
