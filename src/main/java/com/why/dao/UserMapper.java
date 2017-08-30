package com.why.dao;

import com.why.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User getEntity(Integer id);
}
