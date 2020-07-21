package com.tms.rakhubovskiy.config.security;

import com.tms.rakhubovskiy.model.User;
import com.tms.rakhubovskiy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppAuthenticationProvider implements AuthenticationProvider {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AppAuthenticationProvider(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        User user = userService.findUserByUsername(auth.getName());
        if (user == null){
            throw new UsernameNotFoundException(String.format("User not found: %s", auth.getName()));
        }

        String password = auth.getCredentials().toString();
        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new BadCredentialsException("Incorrect username and password");
        }

        List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(it -> new SimpleGrantedAuthority("ROLE_" + it.getName())).collect(Collectors.toList());

        //сетаю в сессию имя пользовтеля
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attributes.getRequest().getSession(false);
        session.setAttribute("attr", user.getUsername());

        return new UsernamePasswordAuthenticationToken(user, null, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
