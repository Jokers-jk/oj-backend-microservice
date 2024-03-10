package com.joker.ojbackendserviceclient.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.joker.ojbackendcommon.common.ErrorCode;
import com.joker.ojbackendcommon.exception.BusinessException;
import com.joker.ojbackendmodel.dto.user.UserQueryRequest;
import com.joker.ojbackendmodel.entity.User;
import com.joker.ojbackendmodel.enums.UserRoleEnum;
import com.joker.ojbackendmodel.vo.LoginUserVO;
import com.joker.ojbackendmodel.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

import static com.joker.ojbackendcommon.constant.UserConstant.USER_LOGIN_STATE;

/**
 * 用户服务
 */
@FeignClient(name = "oj-backend-user-service",path = "/api/user/inner")
public interface UserFeignClient {

    @GetMapping("/get/id")
    User getById(@RequestParam("userId") long userId);
    @GetMapping("/get/ids")
    List<User> listByIds(@RequestParam("idList") Collection<Long> idList);
    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
     default User getLoginUser(HttpServletRequest request){
         // 先判断是否已登录
         Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
         User currentUser = (User) userObj;
         if (currentUser == null || currentUser.getId() == null) {
             throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
         }
         return currentUser;
     }



    /**
     * 是否为管理员
     *
     * @param user
     * @return
     */
    default boolean isAdmin(User user){
        return user != null && UserRoleEnum.ADMIN.getValue().equals(user.getUserRole());
    }



    /**
     * 获取脱敏的用户信息
     *
     * @param user
     * @return
     */
    default UserVO getUserVO(User user){
        if (user == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }





}
