package kuehnenagel.citytask.config.initdb;

import kuehnenagel.citytask.entity.City;
import kuehnenagel.citytask.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class InitDB implements CommandLineRunner {

    @Autowired
    CityService cityService;

    @Autowired
    CsvOperations csvOperations;


    @Override
    public void run(String...args) throws Exception {
        long countCitiesInMongoDB = cityService.count();

        if (countCitiesInMongoDB == 0) {
            //this means database is empty and needs to inserted.
            log.info("CSV READ STARTED.");
            List<CsvBean> cityList =  csvOperations.beanBuilderExample(Helpers.namedCityCsv() , CityCsvBean.class);
            log.info(cityList.size() + " cities found in CSV.");
            log.info("CSV READ FINISHED.");

            log.info("MONGODB SAVE STARTED.");
            cityList.forEach(csvCity -> {
                City city = new City();
                city.setId(String.valueOf(((CityCsvBean)csvCity).getId()));
                city.setName(((CityCsvBean)csvCity).getName());
                city.setPhoto(((CityCsvBean)csvCity).getPhoto());

                cityService.saveCity(city);
            });
            log.info("MONGODB SAVE FINISHED.");
        }
    }

}
