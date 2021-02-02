package edu.imi.ir.eduimiws.aop.aspect;

import edu.imi.ir.eduimiws.aop.annotation.Sanitize;
import lombok.extern.slf4j.Slf4j;

//@Component
@Slf4j
public class SanitizeAspectServiceExample {
    public void saveTransactionData(String identifier, String data, @Sanitize String privateKey){
        log.info(String.format("sending data, identifier=[%s], data=[%s], privateKey=[%privateKey]",
                        identifier, data, privateKey)
        );
    }
}
