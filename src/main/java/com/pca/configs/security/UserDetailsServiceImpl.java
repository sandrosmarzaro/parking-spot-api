package com.pca.configs.security;

import com.pca.models.UserModel;
import com.pca.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserModel userModel = userRepository.findByUsername(username).orElseThrow(
                () -> new RuntimeException("User not found"));
        return new User(userModel.getUsername(), userModel.getPassword(),
                true, true, true, true,
                userModel.getAuthorities());
    }
}
