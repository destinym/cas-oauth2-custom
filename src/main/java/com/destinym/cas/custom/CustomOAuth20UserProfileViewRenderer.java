package com.destinym.cas.custom;

import com.destinym.cas.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apereo.cas.support.oauth.util.OAuth20Utils;
import org.apereo.cas.support.oauth.web.views.OAuth20UserProfileViewRenderer;
import org.apereo.cas.ticket.accesstoken.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by mengliang on 2018/12/30.
 */

@Slf4j
public class CustomOAuth20UserProfileViewRenderer implements OAuth20UserProfileViewRenderer {
    @Autowired
    private UserService userService;
    private final String ID ="id";

    @Override
    public String render(Map<String, Object> model, AccessToken accessToken) {
        try {
            String userId = (String) model.get(ID);
            if (userId != null) {
                return OAuth20Utils.jsonify(userService.findByUserName(userId));
            }
        }catch (Exception e){

        }
        return null;
    }
}
