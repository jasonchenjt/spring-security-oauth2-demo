package com.hongkutech.oauth2.resource.service;

import com.hongkutech.oauth2.resource.domain.TbContent;

import java.util.List;

public interface TbContentService{

    List<TbContent> selectAll();
    TbContent selectByPrimaryKey();

}
