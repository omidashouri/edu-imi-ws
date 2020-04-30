package edu.imi.ir.eduimiws.utilities;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

@Component
public class PublicIdUtil {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//    private static final char[] hexArray = "0123456789ABCDEF".toCharArray();
    private static final char[] hexArray = "0123456789ABCDEFGHIJKLMOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    private final int ITERATIONS = 10000;
    private final int KEY_LENGHT = 256;

    public String generateUserId(int lenght) {
        return generateRandomString(lenght);
    }

    public String generateUniquePublicId()  {

        String uniquePublicUserId = null;
        try {
            uniquePublicUserId =  generateUniqueKeysWithUUIDAndMessageDigest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return uniquePublicUserId;

    }

    public String generateAddressId(int lenght) {
        return generateRandomString(lenght);
    }

//    generateType5UUID(NAMESPACE_URL, "google.com")
    public static UUID generateType5UUID(String namespace, String name) throws UnsupportedEncodingException {
        String source = namespace + name;
        byte[] bytes = source.getBytes("UTF-8");
        UUID uuid = type5UUIDFromBytes(bytes);
        return uuid;
    }

    public static UUID type5UUIDFromBytes(byte[] name) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException nsae) {
            throw new InternalError("SHA-1 not supported", nsae);
        }
        byte[] bytes = Arrays.copyOfRange(md.digest(name), 0, 16);
        bytes[6] &= 0x0f; /* clear version        */
        bytes[6] |= 0x50; /* set to version 5     */
        bytes[8] &= 0x3f; /* clear variant        */
        bytes[8] |= 0x80; /* set to IETF variant  */
        return constructType5UUID(bytes);
    }

    private static UUID constructType5UUID(byte[] data) {
        long msb = 0;
        long lsb = 0;
        assert data.length == 16 : "data must be 16 bytes in length";

        for (int i = 0; i < 8; i++)
            msb = (msb << 8) | (data[i] & 0xff);

        for (int i = 8; i < 16; i++)
            lsb = (lsb << 8) | (data[i] & 0xff);
        return new UUID(msb, lsb);
    }


    public static String generateUniqueKeysWithUUIDAndMessageDigest() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest salt = MessageDigest.getInstance("SHA-256");
        salt.update(UUID.randomUUID()
                .toString()
                .getBytes("UTF-8"));
        String digest = bytesToHex(salt.digest());
        return digest;
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
    }
}
