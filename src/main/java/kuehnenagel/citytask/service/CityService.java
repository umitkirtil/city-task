package kuehnenagel.citytask.service;

import kuehnenagel.citytask.entity.City;
import kuehnenagel.citytask.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public long count(){
        return cityRepository.count();
    }

    public City saveCity(City city){return cityRepository.save(city);}

    public List<City> findByName(String cityName) {
        return cityRepository.findByName(cityName);
    }

    public Page<City> findAllPageable(Pageable page){
        return cityRepository.findAll(page);
    }

    public String updateCity(String id, String cityName, String cityPhoto) {
        City city = cityRepository.findById(id).get();

        city.setName(cityName);
        city.setPhoto(cityPhoto);

        // repository.save will update existing city.
        return cityRepository.save(city).getId();
    }
}
