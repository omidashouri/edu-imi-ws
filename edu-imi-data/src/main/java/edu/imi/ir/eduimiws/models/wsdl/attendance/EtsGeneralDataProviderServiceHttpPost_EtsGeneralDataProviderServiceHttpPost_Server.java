
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 3.6.5
 * 2025-01-08T14:55:54.048+03:30
 * Generated source version: 3.6.5
 *
 */

public class EtsGeneralDataProviderServiceHttpPost_EtsGeneralDataProviderServiceHttpPost_Server{

    protected EtsGeneralDataProviderServiceHttpPost_EtsGeneralDataProviderServiceHttpPost_Server() throws Exception {
        System.out.println("Starting Server");
        Object implementor = new EtsGeneralDataProviderServiceHttpPostImpl();
        String address = "http://172.17.70.21:8090/EtsGeneralDataProviderService.asmx";
        Endpoint.publish(address, implementor);
    }

    public static void main(String args[]) throws Exception {
        new EtsGeneralDataProviderServiceHttpPost_EtsGeneralDataProviderServiceHttpPost_Server();
        System.out.println("Server ready...");

        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}
