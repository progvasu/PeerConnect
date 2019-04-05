package com.peerconnect.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public final class SecurityUtility {
    private SecurityUtility() {
    }

    public static String getUserName() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String userName = null;
        
        if (authentication != null) {
        	UserDetails userDetails = (UserDetails)authentication.getPrincipal();
            userName = userDetails.getUsername();
        }
        return userName;
    }
}