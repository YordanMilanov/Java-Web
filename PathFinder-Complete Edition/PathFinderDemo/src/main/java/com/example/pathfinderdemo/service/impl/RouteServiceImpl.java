package com.example.pathfinderdemo.service.impl;

import com.example.pathfinderdemo.model.entity.Route;
import com.example.pathfinderdemo.model.service.RouteServiceModel;
import com.example.pathfinderdemo.model.view.RouteViewModel;
import com.example.pathfinderdemo.repository.RouteRepository;
import com.example.pathfinderdemo.service.CategoryService;
import com.example.pathfinderdemo.service.RouteService;
import com.example.pathfinderdemo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    private final UserService userService;
    private final ModelMapper modelMapper;

    private final CategoryService categoryService;

    public RouteServiceImpl(RouteRepository routeRepository, UserService userService, ModelMapper modelMapper, CategoryService categoryService) {
        this.routeRepository = routeRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public List<RouteViewModel> findAllRoutesView() {
        return routeRepository
                .findAll()
                .stream()
                .map(route -> {
                    RouteViewModel routeViewModel = modelMapper.map(route, RouteViewModel.class);
                    if (route.getPictures().isEmpty()) {
                        routeViewModel.setPictureUrl("/images/pic4.jpg");
                    } else {
                        routeViewModel.setPictureUrl(route.getPictures().stream().findFirst().get().getUrl());
                    }

                    return routeViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public void addNewRoute(RouteServiceModel routeServiceModel) {
        Route route = modelMapper.map(routeServiceModel, Route.class);
        route.setAuthor(userService.findCurrentLoginUserEntity());

        route.setCategories(routeServiceModel
                .getCategories()
                .stream()
                .map(categoryService::findCategoryByName)
                .collect(Collectors.toSet())
        );

        routeRepository.save(route);
    }
}

