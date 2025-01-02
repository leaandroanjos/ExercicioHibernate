package br.com.leandro.domain;


import javax.persistence.*;

@Entity
@Table(name = "TB_PRODUTOS")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    @SequenceGenerator(name = "seq_produto", sequenceName = "produto_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "NOME", length = 40, nullable = false)
    private String nome;

    @Column(name = "CODIGO", length = 50, nullable = false)
    private String codigo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
