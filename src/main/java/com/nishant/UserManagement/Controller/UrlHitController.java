package com.nishant.UserManagement.Controller;

import com.nishant.UserManagement.Service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class UrlHitController {

    @Autowired
    public UrlHitService urlHitService;

    //   GET API

    @GetMapping("count")
    public String getHitCount(){
        return urlHitService.getHitCount();
    }

    @GetMapping("userId/{id}/count")
    public String getUserHitCount(@PathVariable Long id){
        return urlHitService.getUserHitCount(id);
    }

    //   PUT API

    @PutMapping("count_update/userId/{id}")
    public String hitForUser(@PathVariable Long id){
        urlHitService.hit("api/v1/visitor-count-app/userId/{id}/count",id);
        return "Done";
    }


}
