package com.why.service;

import com.why.bean.User;
import com.why.config.DataSource;
import com.why.config.DataSourceType;

public interface UserService {

    @DataSource(DataSourceType.SLAVE)
//    @DataSource(DataSourceType.MASTER)
    User getEntity(Integer id);

}
