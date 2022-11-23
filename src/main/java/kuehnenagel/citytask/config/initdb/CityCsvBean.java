package kuehnenagel.citytask.config.initdb;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityCsvBean extends CsvBean {

    @CsvBindByName(column = "id")
    private int id;

    // also we can define this
    @CsvBindByName
    private String name;

    @CsvBindByName
    private String photo;

}
