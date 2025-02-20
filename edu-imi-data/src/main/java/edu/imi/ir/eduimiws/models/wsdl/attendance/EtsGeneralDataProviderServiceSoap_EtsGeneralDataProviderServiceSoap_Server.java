
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import jakarta.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 4.1.0
 * 2025-01-31T12:06:54.499+03:30
 * Generated source version: 4.1.0
 *
 */

public class EtsGeneralDataProviderServiceSoap_EtsGeneralDataProviderServiceSoap_Server{

    protected EtsGeneralDataProviderServiceSoap_EtsGeneralDataProviderServiceSoap_Server() throws Exception {
        System.out.println("Starting Server");
        Object implementor = new EtsGeneralDataProviderServiceSoapImpl();
        String address = "http://172.17.70.21:8090/EtsGeneralDataProviderService.asmx";
        Endpoint.publish(address, implementor);
    }

    public static void main(String args[]) throws Exception {
        new EtsGeneralDataProviderServiceSoap_EtsGeneralDataProviderServiceSoap_Server();
        System.out.println("Server ready...");

        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}
