package com.example.parcialfrancoback.Modelos;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import java.util.Date;
import org.hibernate.annotations.SQLDelete;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "status = 0")
@SQLDelete(sql = "UPDATE contrato SET status = 1 WHERE id=?")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String identificador;
    private Double valor;
    private String nombre_contratante;
    private String documento_contratante;
    private String nombre_contratantista;
    private String documento_contratantista;
    private Date fecha_inicial;
    private Date fecha_final;

}
