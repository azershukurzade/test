package az.azer.springsecsection2.filter;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthoritiesLoggingAfterFilter implements Filter {
    private final Logger LOG =
            Logger.getLogger(AuthoritiesLoggingAfterFilter.class.getName());
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null) {
            LOG.info("User " + authentication.getName() + " is authenticated and has the authorities " + authentication.getAuthorities() );
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }
}
