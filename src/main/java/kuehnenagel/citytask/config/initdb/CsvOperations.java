package kuehnenagel.citytask.config.initdb;

import com.opencsv.bean.CsvToBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Component
public class CsvOperations {

    public static List<CsvBean> beanBuilderExample(Path path, Class<? extends CsvBean> clazz) throws Exception {
        CsvTransfer csvTransfer = new CsvTransfer();
        try (Reader reader = Files.newBufferedReader(path)) {
            CsvToBean<CsvBean> cb = new CsvToBeanBuilder<CsvBean>(reader)
                    .withType(clazz)
                    .build();

            csvTransfer.setCsvList(cb.parse());
        }

        return csvTransfer.getCsvList();
    }

    public static String writeCsvFromBean(Path path) throws Exception {

        List<CsvBean> sampleData = Arrays.asList(
                new CityCsvBean(1, "Istanbul", "https://www.google.com/istanbul"),
                new CityCsvBean(1, "Izmir", "https://www.google.com/izmir")
        );

        try (Writer writer = new FileWriter(path.toString())) {
            StatefulBeanToCsv<CsvBean> sbc = new StatefulBeanToCsvBuilder<CsvBean>(writer)
                    .withQuotechar('\'')
                    .build();

            sbc.write(sampleData);
        }

        return Helpers.readFile(path);
    }
}