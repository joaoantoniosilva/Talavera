package Entidades;

import com.example.demo.DetalhesEntrega;

import ch.qos.logback.core.net.server.Client;
import ch.qos.logback.core.status.Status;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPedido;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pedido_itens",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Pedido> itens;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entrega_id")
    private DetalhesEntrega entrega;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client cliente;

    // Outros atributos, construtores, getters e setters

    // Métodos construtores

    public Pedido() {
        this.dataPedido = new Date();
    }

    public Pedido(List<Pedido> itens, Status status, DetalhesEntrega entrega, Client cliente) {
        this.dataPedido = new Date();
        this.itens = itens;
        this.status = status;
        this.entrega = entrega;
        this.cliente = cliente;
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public List<Pedido> getItens() {
        return itens;
    }

    public void setItens(List<Pedido> itens) {
        this.itens = itens;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public DetalhesEntrega getEntrega() {
        return entrega;
    }

    public void setEntrega(DetalhesEntrega entrega) {
        this.entrega = entrega;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }
}
