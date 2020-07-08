/*
 * Copyright 1999-2020 Mitbook Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mitbook.rest;

import com.mitbook.annotation.MitRequestMapping;
import com.mitbook.annotation.MitRequestParam;
import com.mitbook.annotation.MitRestController;
import com.mitbook.entity.UserEntity;
import com.mitbook.response.GeneralResponse;
import com.mitbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author pengzhengfa
 */
@MitRestController
public class RestUser {


    @Autowired
    private UserService userService;

    /**
     * 无条件查询（查询所有的用户）
     *
     * @return
     */
    @MitRequestMapping(uri = "findAllUser")
    public GeneralResponse findAllUser() {
        List<UserEntity> userList = userService.selectAllUser();
        return GeneralResponse.success(userList);
    }

    /**
     * 有条件查询(据主键查询用户)
     *
     * @param id
     * @return
     */
    @MitRequestMapping(uri = "findUserById")
    public GeneralResponse findAllIdUser(@MitRequestParam(name = "id") Integer id) {
        List<UserEntity> userList = userService.selectAllIdUser(id);
        return GeneralResponse.success(userList);
    }


    /**
     * 插入（录入数据）
     *
     * @param userEntity
     * @return
     */
    @MitRequestMapping(uri = "insertUserData", method = RequestMethod.POST)
    public GeneralResponse insertUserData(@RequestBody UserEntity userEntity) {
        int insertUserData = userService.insertUserData(userEntity);
        return GeneralResponse.success(insertUserData);
    }


    /**
     * 更改用户信息
     *
     * @param userEntity
     * @return
     */
    @MitRequestMapping(uri = "updateUserById", method = RequestMethod.POST)
    public GeneralResponse updateUserById(@RequestBody UserEntity userEntity) {
        int updateUserData = userService.updateUserData(userEntity);
        return GeneralResponse.success(updateUserData);
    }

    /**
     * 冻结用户信息
     *
     * @param userEntity
     * @return
     */
    @MitRequestMapping(uri = "deleteUserById", method = RequestMethod.POST)
    public GeneralResponse deleteUserById(@RequestBody UserEntity userEntity) {
        int deleteUserById = userService.deleteUserById(userEntity);
        return GeneralResponse.success(deleteUserById);
    }
}
