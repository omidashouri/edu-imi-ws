package edu.imi.ir.eduimiws.utilities;

import edu.imi.ir.eduimiws.security.MelliCredential;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Component;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
@RequiredArgsConstructor
@Slf4j
public class MelliTripleDesImpl implements MelliTripleDes{

    private final MelliCredential melliCredential;


//    @Named("melliEncrypt")
    @Override
    public String encrypt(String unencryptedMessage) {
        Cipher encryptCipher;
        String base64EncryptedMessageString = null;
        byte[] messageBytes, encryptedMessageBytes, base64EncryptedMessageBytes;

        try {
            encryptCipher = Cipher.getInstance(melliCredential.getEncryptionAlgorithm(),new BouncyCastleProvider());
            encryptCipher.init(Cipher.ENCRYPT_MODE, this.getSecretKey());
            messageBytes = unencryptedMessage.getBytes(melliCredential.getUnicodeFormat());
            encryptedMessageBytes = encryptCipher.doFinal(messageBytes);
            base64EncryptedMessageBytes = Base64.encodeBase64(encryptedMessageBytes);
            base64EncryptedMessageString = new String(base64EncryptedMessageBytes);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            log.debug(e.getMessage());
        } catch (NoSuchPaddingException | InvalidKeyException e) {
            log.debug(e.getMessage());
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            log.debug(e.getMessage());
        }
        return base64EncryptedMessageString;
    }

    @Override
    public String decrypt(String encryptedMessage) throws Exception {
        byte[] base64EncryptedMessage,decryptedMessageBytes;
        Cipher decryptCipher;
        String decryptedMessage = null;

        try{
            base64EncryptedMessage = Base64.decodeBase64(encryptedMessage.getBytes());
            decryptCipher = Cipher.getInstance(melliCredential.getEncryptionAlgorithm(),
                    new BouncyCastleProvider());
            decryptCipher.init(Cipher.DECRYPT_MODE, this.getSecretKey());
            decryptedMessageBytes = decryptCipher.doFinal(base64EncryptedMessage);
            decryptedMessage = new String(decryptedMessageBytes, melliCredential.getUnicodeFormat());
        }
        catch (Exception e){
            log.debug(e.getMessage());
        }
        return decryptedMessage;
    }

    protected SecretKey getSecretKey() {
        byte[] secretKeyBytes = melliCredential.getEncryptionKey().getBytes();
        byte[] secretKey64Bytes = Base64.decodeBase64(secretKeyBytes);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey64Bytes,
                melliCredential.getDataEncryptionStandardAlgorithm());
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
