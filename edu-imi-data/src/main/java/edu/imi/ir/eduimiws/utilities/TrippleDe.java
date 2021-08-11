package edu.imi.ir.eduimiws.utilities;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TrippleDe {

    //    public static String ALGO = "DESede/CBC/PKCS7Padding";
//    DESede is same as TripleDES
//    public static String ALGO = "DESede/ECB/PKCS5Padding";
    public static String ALGO = "TripleDES/ECB/PKCS5Padding";

    public static String _encrypt(String message, String secretKey) throws Exception {

        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, getSecreteKey(secretKey));

        byte[] plainTextBytes = message.getBytes("UTF-8");
        byte[] buf = cipher.doFinal(plainTextBytes);
        byte[] base64Bytes = Base64.encodeBase64(buf);
        String base64EncryptedString = new String(base64Bytes);
        return base64EncryptedString;
    }

    public static String _decrypt(String encryptedText, String secretKey) throws Exception {

        byte[] message = Base64.decodeBase64(encryptedText.getBytes());

        Cipher decipher = Cipher.getInstance(ALGO);
        decipher.init(Cipher.DECRYPT_MODE, getSecreteKey(secretKey));

        byte[] plainText = decipher.doFinal(message);

        return new String(plainText, "UTF-8");
    }

    public static SecretKey getSecreteKey(String secretKey) throws Exception {
/*        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        SecretKey key = new SecretKeySpec(keyBytes, "TripleDES");
        return key;*/

        byte[] secretKeyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        byte[] copy24Bytes = Arrays.copyOf(secretKeyBytes, 24);
        SecretKeySpec secretKeySpec = new SecretKeySpec(copy24Bytes,"TripleDES");
        return secretKeySpec;
    }
}
