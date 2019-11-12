package com.hongkutech.oauth2.server.service;

import com.hongkutech.oauth2.server.domain.TbPermission;
import tk.mybatis.mapper.MyMapper;

import java.security.Permission;
import java.util.List;

public interface TbPermissionService{

    public List<TbPermission> selectByUserId(Long userId);

}
