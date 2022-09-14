package com.epicode.project.progettofinale.security.service.impl;

import com.epicode.project.progettofinale.security.repository.UserRepository;
import com.epicode.project.progettofinale.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUserName(userName);

        if (user.isPresent()) {
            return UserDetailsImpl.build(user.get());
        } else {
            throw new UsernameNotFoundException("User Not Found with username: " + userName);
        }
    }

}