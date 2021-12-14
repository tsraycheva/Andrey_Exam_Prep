package com.example.andrey_exam_prep.service.impl;

import com.example.andrey_exam_prep.model.entity.UserEntity;
import com.example.andrey_exam_prep.model.service.UserServiceModel;
import com.example.andrey_exam_prep.repository.UserRepository;
import com.example.andrey_exam_prep.service.UserService;
import com.example.andrey_exam_prep.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        UserEntity userEntity = modelMapper.map(userServiceModel, UserEntity.class);
        userRepository.save(userEntity);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository
                .findUserEntityByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);

    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id).setUsername(username).setAnonymous(false);

    }
}
