package bg.softuni.pizzashop.service;

import bg.softuni.pizzashop.model.binding.CommentAddBindingModel;
import bg.softuni.pizzashop.model.entity.Comment;
import bg.softuni.pizzashop.model.entity.User;

import java.util.List;

public interface CommentService {

    List<Comment> allComments();

    Comment createdComment (CommentAddBindingModel commentAddBindingModel, User author);
}
