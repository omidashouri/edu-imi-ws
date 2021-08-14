package edu.imi.ir.eduimiws.utilities;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MelliTripleDes {
    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE = "DESede";
    public static final String DESEDE_ECB_PKCS_7_PADDING = "DESede/ECB/PKCS7Padding";
    public static final String ENCRYPTION_KEY = "XZewVTUH9U+hQgMCjMu9mKmF9srWLN/y";

    public String encrypt(String unencryptedMessage) {
        Cipher encryptCipher;
        String base64EncryptedMessageString = null;
        byte[] messageBytes, encryptedMessageBytes, base64EncryptedMessageBytes;

        try {
            encryptCipher = Cipher.getInstance(DESEDE_ECB_PKCS_7_PADDING,new BouncyCastleProvider());
            encryptCipher.init(Cipher.ENCRYPT_MODE, this.getSecretKey());
            messageBytes = unencryptedMessage.getBytes(UNICODE_FORMAT);
            encryptedMessageBytes = encryptCipher.doFinal(messageBytes);
            base64EncryptedMessageBytes = Base64.encodeBase64(encryptedMessageBytes);
            base64EncryptedMessageString = new String(base64EncryptedMessageBytes);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException | InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return base64EncryptedMessageString;
    }

    public String decrypt(String encryptedMessage) throws Exception {
        byte[] base64EncryptedMessage,decryptedMessageBytes;
        Cipher decryptCipher;
        String decryptedMessage = null;

        try{
            base64EncryptedMessage = Base64.decodeBase64(encryptedMessage.getBytes());
            decryptCipher = Cipher.getInstance(DESEDE_ECB_PKCS_7_PADDING, new BouncyCastleProvider());
            decryptCipher.init(Cipher.DECRYPT_MODE, this.getSecretKey());
            decryptedMessageBytes = decryptCipher.doFinal(base64EncryptedMessage);
            decryptedMessage = new String(decryptedMessageBytes, UNICODE_FORMAT);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return decryptedMessage;
    }

    protected SecretKey getSecretKey() {
        byte[] secretKeyBytes = ENCRYPTION_KEY.getBytes();
        byte[] secretKey64Bytes = Base64.decodeBase64(secretKeyBytes);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey64Bytes, DESEDE);
        return secretKeySpec;
    }

    protected String encryptBankSample(String message, String key) throws Exception{
        SecretKey secretKey = new SecretKeySpec(org.bouncycastle.util.encoders.Base64.decode(key.getBytes()), "DESede");
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS7Padding", new BouncyCastleProvider());
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] buf = cipher.doFinal(message.getBytes("UTF-8"));
        return org.bouncycastle.util.encoders.Base64.toBase64String(buf);
    }
}
