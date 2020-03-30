package edu.uniandes.podam.config;

import edu.uniandes.podam.model.Pojo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class ApiController {

    @GetMapping(value = "")
    public String hello() {
        return "Hola Mundo";
    }

    @GetMapping(value = "/pojos")
    public Pojo get() {

        PodamFactory factory = new PodamFactoryImpl();

        Pojo myPojo = factory.manufacturePojoWithFullData(Pojo.class);

        return myPojo;
    }

    @GetMapping(value = "/pojos/{amount}")
    public List<Pojo> get(@PathVariable int amount) {

        PodamFactory factory = new PodamFactoryImpl();

        List<Pojo> pojoList = new ArrayList<Pojo>();
        for (int i = 0; i < amount; i++) {
            Pojo myPojo = factory.manufacturePojoWithFullData(Pojo.class);
            pojoList.add(myPojo);
        }

        return pojoList;
    }
}
