package com.maiko7.aibi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maiko7.aibi.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Maiko7
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2024-05-23 08:14:51
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




