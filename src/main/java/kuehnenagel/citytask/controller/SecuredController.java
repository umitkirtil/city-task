package kuehnenagel.citytask.controller;

import kuehnenagel.citytask.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("user")
public class SecuredController {

    @Autowired
    CityService cityService;


    @PostMapping("/editCity")
    @ResponseBody
    public String sayHello(String id , String cityName , String cityPhoto) {
        return cityService.updateCity(id , cityName , cityPhoto);
    }
}