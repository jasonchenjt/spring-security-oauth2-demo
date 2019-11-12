package com.hongkutech.oauth2.server.service;

import com.hongkutech.oauth2.server.domain.TbUser;
import tk.mybatis.mapper.MyMapper;

public interface TbUserService{

    public TbUser getByUsername(String username);
}
