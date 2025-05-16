package com.example.tp_api_rest_avec_retrofit.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp_api_rest_avec_retrofit.model.User;
import com.example.tp_api_rest_avec_retrofit.repository.UserRepository;

import java.util.List;

public class UserViewModel extends ViewModel {
    private MutableLiveData<List<User>> users;
    private UserRepository repository;

    public UserViewModel() {
        repository = new UserRepository();
        users = new MutableLiveData<>();
        loadUsers();
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    private void loadUsers() {
        repository.fetchUsers(users);

    }
}