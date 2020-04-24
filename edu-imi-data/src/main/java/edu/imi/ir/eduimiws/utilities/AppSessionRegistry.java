package edu.imi.ir.eduimiws.utilities;

import lombok.AllArgsConstructor;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

@AllArgsConstructor
public class AppSessionRegistry {

 public SessionRegistry sessionRegistryImpl(){
     return new SessionRegistryImpl();
 }

}
