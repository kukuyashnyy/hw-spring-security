package org.itstep.service;

import org.itstep.domain.User;
import org.itstep.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> customUserOptional = userRepository.findUserByUsername(username);
        if (customUserOptional.isEmpty()) throw new UsernameNotFoundException("Not found by " + username);
        User user = customUserOptional.get();
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRole()));
    }
}
