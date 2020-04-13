package com.laurokirsch.springbootmongo.services;

import com.laurokirsch.springbootmongo.domain.Post;
import com.laurokirsch.springbootmongo.domain.User;
import com.laurokirsch.springbootmongo.repository.PostRepository;
import com.laurokirsch.springbootmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
