package br.com.leandro.domain;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "TB_MATRICULA")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matricula_sq")
    @SequenceGenerator(name = "matricula_sq", sequenceName = "sq_matricula", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "codigo", length = 10, nullable = false, unique = true)
    private String codigo;
    @Column(name = "valor",  nullable = false)
    private Double valor;
    @Column(name = "status",  nullable = false)
    private String status;
    @Column(name = "data_matricula",  nullable = false)
    private Instant dataMatricula;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Instant dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
}
