package org.itstep.service;

import org.itstep.domain.CustomUser;
import org.itstep.repository.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private CustomUserRepository customUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<CustomUser> customUserOptional = customUserRepository.findUserByUsername(username);
        if (customUserOptional.isEmpty()) throw new UsernameNotFoundException("Not found by " + username);
        CustomUser customUser = customUserOptional.get();
        return new User(customUser.getUsername(),
                customUser.getPassword(),
                AuthorityUtils.createAuthorityList(customUser.getRole()));
    }
}
