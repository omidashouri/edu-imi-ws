package edu.imi.ir.eduimiws.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ActiveUserService2 {

    private SessionRegistry sessionRegistry;

    public List<User> getAllActiveUsers() {
        List<User> activeUsers;
        List<Object> principals = sessionRegistry.getAllPrincipals();
        User[] users = principals.toArray(new User[principals.size()]);
        activeUsers = Arrays
                .stream(users)
                .filter(u -> !sessionRegistry.getAllSessions(u, false).isEmpty())
                .collect(Collectors.toList());
        return activeUsers;
    }

    public List<String> getAllActiveUserNames() {

        List<String> activeUserNames;
        List<Object> principals = sessionRegistry.getAllPrincipals();
        User[] users = principals.toArray(new User[principals.size()]);

        activeUserNames =
                Arrays.stream(users)
                        .filter(u -> !sessionRegistry.getAllSessions(u, false).isEmpty())
                        .map(u -> u.getUsername())
                        .collect(Collectors.toList());

        return activeUserNames;
    }
}
