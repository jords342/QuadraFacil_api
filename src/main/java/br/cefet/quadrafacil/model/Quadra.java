package br.cefet.quadrafacil.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Quadra {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long id;

    @Column(length=60, nullable=false,unique = false)
    private String nome;

    @Column(length=60, nullable=false,unique = false)
    private String endereco;
}
