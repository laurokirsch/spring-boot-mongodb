package com.laurokirsch.springbootmongo.services;

import com.laurokirsch.springbootmongo.domain.User;
import com.laurokirsch.springbootmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
}
