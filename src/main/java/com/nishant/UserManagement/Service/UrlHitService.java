package com.nishant.UserManagement.Service;

import com.nishant.UserManagement.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlHitService {

    @Autowired
    Repository repo;
    public String getHitCount() {
        final Integer[] c = {0};
        repo.getUserMap()
                .forEach((id,user)->{
                    user.getHits()
                        .forEach((url,count)-> c[0] +=count);
                });
        return c[0].toString();
    }

    public String getUserHitCount(Long id) {
        hit("api/v1/visitor-count-app/userId/{id}/count",id);
        return repo.getUserMap().get(id).getHits().toString();
    }

    public void hit(String url, Long id){
        repo.getUserMap()
                .get(id)
                .getHits()
                .put(url,repo.getUserMap()
                        .get(id)
                        .getHits()
                        .getOrDefault(url,0)+1);
    }

}
