package com.prymodev.iliwap.service;


import com.prymodev.iliwap.entity.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
