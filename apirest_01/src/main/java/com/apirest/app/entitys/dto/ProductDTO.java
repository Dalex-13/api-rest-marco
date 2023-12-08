package com.apirest.app.entitys.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ProductDTO {

    private Integer id;

    @NotEmpty
    @Size(min = 5, max = 50,message = "el name deberia tener mas de 4 caracteres")
    private String name;

    private String description;

    private double price;

    private int amount;

    private boolean discount;

}
