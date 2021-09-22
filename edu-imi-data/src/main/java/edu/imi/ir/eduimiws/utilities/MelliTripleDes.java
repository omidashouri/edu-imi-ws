package edu.imi.ir.eduimiws.utilities;

import edu.imi.ir.eduimiws.mapper.MappingUtil;

public interface MelliTripleDes {

    @MappingUtil.MelliTripleDesEncrypt
    String encrypt(String unencryptedMessage);

    String decrypt(String encryptedMessage) throws Exception;
}
