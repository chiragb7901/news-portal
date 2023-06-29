package com.s2p.controller;

import com.s2p.model.Comment;
import com.s2p.model.Tutorial;
import com.s2p.service.ICommentService;
import com.s2p.service.ITutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("comment")
@RestController
public class CommentController {
    @Autowired
    ICommentService commentService;
    @GetMapping("getall")
    public List<Comment> getAll(){
        return commentService.getAll();
    }

    @PostMapping("{tutorial_id}/add")
    public Comment add(@PathVariable(value = "tutorial_id") long tutorial_id,@RequestBody Comment t){
        return commentService.add(tutorial_id,t);
    }
}
