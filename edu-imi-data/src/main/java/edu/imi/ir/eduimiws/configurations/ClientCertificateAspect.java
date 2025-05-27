package edu.imi.ir.eduimiws.configurations;

import edu.imi.ir.eduimiws.services.behdad.BehdadServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class ClientCertificateAspect {

   /* @Around("@annotation(UseClientCertificate)")
    public Object applyClientCertificate(ProceedingJoinPoint pjp) throws Throwable {
        Object target = pjp.getTarget();*/

        // Assuming the target has a CXF client proxy method to configure SSL
        // For example, if target is your service impl with a 'getPort' method:

        // Here you must access the CXF client proxy and configure SSL with your .pfx file
        // Example:
       /* if (target instanceof BehdadServiceImpl) {
            BehdadServiceImpl serviceImpl = (BehdadServiceImpl) target;
            // Access the port/client proxy you want to configure:
            Object port = serviceImpl.getAccountServicePort();  // add such method if needed

            // Now configure the client certificate on the port
            BehdadClientConfig.configureClientCertificate(port);
        }*/

        // Proceed with the original method call
/*        return pjp.proceed();
    }*/
}
