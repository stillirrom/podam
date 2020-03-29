package edu.uniandes.podam.config;

import edu.uniandes.podam.model.Pojo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@AllArgsConstructor
@RestController
public class ApiController {

    @GetMapping(value = "")
    public String hello() {
        return "Hola Mundo";
    }

    @GetMapping(value = "/employees")
    public Pojo all() {
        // Simplest scenario. Will delegate to Podam all decisions
        PodamFactory factory = new PodamFactoryImpl();

        // This will use constructor with minimum arguments and
        // then setters to populate POJO
        Pojo myPojo = factory.manufacturePojo(Pojo.class);

        // This will use constructor with maximum arguments and
        // then setters to populate POJO
        Pojo myPojo2 = factory.manufacturePojoWithFullData(Pojo.class);

        // If object instance is already available,
        // Podam can fill it with random data
        return myPojo;
    }
}
