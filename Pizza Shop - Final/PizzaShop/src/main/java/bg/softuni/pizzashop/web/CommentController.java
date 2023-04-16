package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.entity.Comment;
import bg.softuni.pizzashop.model.view.CommentView;
import bg.softuni.pizzashop.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CommentController {

    private final CommentService commentService;
    private final ModelMapper modelMapper;
    @Autowired
    public CommentController(CommentService commentService, ModelMapper modelMapper) {
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/api/comments")
    public ResponseEntity<List<CommentView>> allComments() {
        List<Comment> comments = commentService.allComments();
        List<CommentView> collect = comments.stream().map(comment -> modelMapper.map(comment, CommentView.class)).collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }

}
