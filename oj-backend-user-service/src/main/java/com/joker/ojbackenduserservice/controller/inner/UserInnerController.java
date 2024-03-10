package com.joker.ojbackenduserservice.controller.inner;

import com.joker.ojbackendmodel.entity.User;
import com.joker.ojbackendserviceclient.service.UserFeignClient;
import com.joker.ojbackenduserservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("inner")
public class UserInnerController implements UserFeignClient {

    @Resource
    private UserService userService;

    @Override
    @GetMapping("/get/id")
    public User getById(long userId){
        return userService.getById(userId);
    }

    @Override
    @GetMapping("/get/ids")
    public List<User> listByIds(Collection<Long> idList){
        return userService.listByIds(idList);
    }
}
