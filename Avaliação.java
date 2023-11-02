package Entidades;

import ch.qos.logback.core.net.server.Client;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "avaliacoes")
public class Avaliação {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client cliente;

    @ManyToOne
    @JoinColumn(name = "prato_id")
    private Cardapio prato;

    private int pontuacao;
    private String comentario;

    // Outros atributos, construtores, getters e setters

    // Métodos construtores

    public void Avaliacao() {
    }

    public void Avaliacao(Client cliente, Cardapio prato, int pontuacao, String comentario) {
        this.cliente = cliente;
        this.prato = prato;
        this.pontuacao = pontuacao;
        this.comentario = comentario;
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public Cardapio getPrato() {
        return prato;
    }

    public void setPrato(Cardapio prato) {
        this.prato = prato;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
