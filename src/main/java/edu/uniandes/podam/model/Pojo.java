package edu.uniandes.podam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Pojo{

    Integer id;
    String name;
    String description;
    EnumType type;
    Date creation_date;
    String apk;
    String url;
    List<Versions> versions;
}
