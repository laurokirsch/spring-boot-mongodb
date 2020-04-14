package com.laurokirsch.springbootmongo.resources;

import com.laurokirsch.springbootmongo.domain.Post;
import com.laurokirsch.springbootmongo.resources.util.URL;
import com.laurokirsch.springbootmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    PostService service;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    ResponseEntity<Post> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @RequestMapping(value="/search", method=RequestMethod.GET)
    ResponseEntity<List<Post>> findByTitle(@RequestParam(value="title", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value="/searchQuery", method=RequestMethod.GET)
    ResponseEntity<List<Post>> findByTitleQuery(@RequestParam(value="title", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitleQuery(text);
        return ResponseEntity.ok().body(list);
    }


    @RequestMapping(value="/fullsearch", method=RequestMethod.GET)
    ResponseEntity<List<Post>> fullSearch(
        @RequestParam(value="text", defaultValue = "") String text,
        @RequestParam(value="minDate", defaultValue = "") String minDate,
        @RequestParam(value="maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = service.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);

    }

}
