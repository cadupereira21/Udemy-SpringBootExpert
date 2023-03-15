package io.github.m4nko.model;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTE") // Somente necessário quando o nome da classe é diferente da tabela
public class Cliente {
    @Id // Define primary key (Obrigatório em uma entidade)
    @GeneratedValue(strategy = GenerationType.AUTO) // Usado por conta do auto_generated
    @Column(name = "ID") // Se comporta da mesma forma que @Table
    private Integer id;
    @Column(name = "NOME", length = 100)
    private String nome;

    public Cliente() {
    }
    public Cliente(String nome) {
        this.nome = nome;
    }
    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
