package com.example.cpmpgroup.dao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class BondeCommandeDTO {
    private  long id;
    private String codebc;
    private float montant;
    private long delais;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDebutTraveaux;
    private long idEntrep;
    private String nomEntrep;
}
