package ru.mtuci.antonapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Catalog extends AbstractBaseEntity {
    @NotBlank
    private String vendor;
    @NotBlank
    private String model;
    @NotNull
    private String cpu;
    @NotNull
    private Integer ram;

}