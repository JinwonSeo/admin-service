package kr.sproutfx.platform.adminservice.common.security.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.sproutfx.platform.adminservice.common.security.client.UserClient;
import kr.sproutfx.platform.adminservice.common.security.model.User;

@Service
public class UserService implements UserDetailsService {
    UserClient client;

    @Autowired
    public UserService(UserClient client) {
        this.client = client;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        User user = client.selectById(id);

        if (user == null) return null;

        else return new org.springframework.security.core.userdetails.User(user.getId(), user.getPassword(), new ArrayList<>());
    }
}
