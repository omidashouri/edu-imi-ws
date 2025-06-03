package edu.imi.ir.eduimiws.configurations;

import edu.imi.ir.eduimiws.models.wsdl.behdad.AccountService;
import edu.imi.ir.eduimiws.models.wsdl.behdad.AccountServiceImplService;
import edu.imi.ir.eduimiws.services.behdad.BehdadServiceImpl;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class ClientCertificateAspect {

    private final BehdadAccountServiceContext behdadAccountServiceContext;

    @Around("@annotation(BehdadClientCertificate)")
    public Object applyClientCertificate(ProceedingJoinPoint pjp) throws Throwable {
        Object target = pjp.getTarget();

        // Assuming the target has a CXF client proxy method to configure SSL
        // For example, if target is your service impl with a 'getPort' method:

        // Here you must access the CXF client proxy and configure SSL with your .pfx file
        // Example:

        // Access the port/client proxy you want to configure:
//         Object port = getAccountServicePort();  // add such method if needed

        // Now configure the client certificate on the port
        if (!behdadAccountServiceContext.hasAccountService())
            behdadAccountServiceContext.setAccountService(BehdadClientConfig.createAccountServiceProxy());


        // Proceed with the original method call
        return pjp.proceed();
    }

    // Expose the CXF port
//    public AccountService getAccountServicePort() {
//        AccountServiceImplService accountServiceImplService = new AccountServiceImplService();
//        return accountServiceImplService.getAccountServiceImplPort();
//    }
}
