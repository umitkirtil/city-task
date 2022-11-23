package kuehnenagel.citytask.controller;

import kuehnenagel.citytask.entity.City;
import kuehnenagel.citytask.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/city")
public class PublicController {

    @Autowired
    CityService cityService;


    @GetMapping("/hello")
    public String sayHello(String userName) {
        return "Hi  " + userName + "!";
    }

    @GetMapping("/getCity")
    @ResponseBody
    public List<City> getCity(@Param("cityName") String cityName) {
        return cityService.findByName(cityName);
    }

    @GetMapping("/getCities")
    @ResponseBody
    public Page<City> getAllPageable(@Param("page") Integer page , @Param("size") Integer size) {
        Pageable pageable = PageRequest.of(page , size);
        return cityService.findAllPageable(pageable);
    }
}