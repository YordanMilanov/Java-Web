package bg.softuni.pizzashop.service.impl;

import bg.softuni.pizzashop.model.binding.CommentAddBindingModel;
import bg.softuni.pizzashop.model.entity.Comment;
import bg.softuni.pizzashop.model.entity.User;
import bg.softuni.pizzashop.repository.CommentRepository;
import bg.softuni.pizzashop.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
 public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    @Override
    public List<Comment> allComments() {
       return commentRepository.findAll();
    }

    @Override
    public Comment createdComment (CommentAddBindingModel commentAddBindingModel, User author) {
       Comment comment = new Comment();
       comment.setCreateTime(LocalDateTime.now());
       comment.setAuthor(author);
       comment.setTextContent(commentAddBindingModel.getTextContent());
       commentRepository.save(comment);
       return comment;
    }


}
