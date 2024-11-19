package com.example.parcialfrancoback.Dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DTOContrato {

    private long id;
    private String identificador;
    private Double valor;
    private String nombre_contratante;
    private String documento_contratante;
    private String nombre_contratantista;
    private String documento_contratantista;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_inicial;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_final;
    private int status;
    
}
