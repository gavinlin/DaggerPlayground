package com.gavincode.daggerplayground.presentation.view;

import com.gavincode.daggerplayground.presentation.model.User;

import java.util.Collection;

/**
 * Created by gavinlin on 31/07/15.
 */
public interface UserListView extends LoadDataView{
    void renderUserList(Collection<User> userCollection);

    void viewUser(User user);
}
