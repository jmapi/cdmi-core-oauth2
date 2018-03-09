package pw.cdmi.core.oauth2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xujingfeng on 2017/8/7.
 */
@RestController
public class TestEndpoints {

    @RequestMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
        
        return "product id : " + id;
    }

    @RequestMapping("/order/{id}")
    public String getOrder(@PathVariable String id) {
        
        return "order id : " + id;
    }

}
