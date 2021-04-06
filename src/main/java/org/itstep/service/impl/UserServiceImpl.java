package org.itstep.service.impl;

import org.itstep.domain.User;
import org.itstep.repository.UserRepository;
import org.itstep.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User dto) {
        String encodedPassword = new BCryptPasswordEncoder().encode(dto.getPassword());
        dto.setPassword(encodedPassword);
        dto.setRole("ROLE_USER");
        return repository.save(dto);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<User> findOne(Integer id) {
        return Optional.empty();
    }

    @Override
    public void delete(Integer id) {

    }
}
