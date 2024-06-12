package com.bbeltranl.evaluation.service;

import com.bbeltranl.evaluation.dto.UserRequest;
import com.bbeltranl.evaluation.model.User;

import java.util.List;

public interface UserService {

    User registerUser(UserRequest user);

    List<User> listAll();
}
