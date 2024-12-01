package sc.senai.controle_de_estoque.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String httpMetodo;
    private String classe;
    private String nomeMetodo;
    private LocalDateTime timestamp;

    public Log() {
        this.timestamp = LocalDateTime.now();
    }

    public Log(String httpMetodo, String classe, String nomeMetodo) {
        this.httpMetodo = httpMetodo;
        this.classe = classe;
        this.nomeMetodo = nomeMetodo;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHttpMetodo() {
        return httpMetodo;
    }

    public void setHttpMetodo(String httpMetodo) {
        this.httpMetodo = httpMetodo;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public void setNomeMetodo(String nomeMetodo) {
        this.nomeMetodo = nomeMetodo;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
