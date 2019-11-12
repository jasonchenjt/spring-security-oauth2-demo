package com.hongkutech.oauth2.server.config.service;

import com.hongkutech.oauth2.server.domain.TbPermission;
import com.hongkutech.oauth2.server.domain.TbUser;
import com.hongkutech.oauth2.server.service.TbPermissionService;
import com.hongkutech.oauth2.server.service.TbUserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//自定义验证授权类
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbPermissionService tbPermissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //首先查询用户是否存在
        TbUser tbUser = tbUserService.getByUsername(s);

        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        //判断用户存在
        if (tbUser != null) {
            List<TbPermission> tbPermissions = tbPermissionService.selectByUserId(tbUser.getId());

            // 声明用户授权
            tbPermissions.forEach(tbPermission -> {
                if (tbPermission != null && tbPermission.getEnname() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
                    grantedAuthorities.add(grantedAuthority);
                }
            });
        }
        // 由框架完成认证工作
        return new User(tbUser.getUsername(), tbUser.getPassword(), grantedAuthorities);
    }
}