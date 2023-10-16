package firstSpring.firstDemo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${name.admin}")
    private String nameAdmin;

    // new end-point
    @GetMapping("/welcome")
    public String getWelcome(){
        return "Ciaoooo " + nameAdmin + "!!!!";
    }

}
