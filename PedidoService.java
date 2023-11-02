package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Entidades.Pedido;

@Service
public class PedidoService {

    private final String apiUrl = "https://www.talaverabar.com.br/js"; // Substitua pelo endereço real da sua API Node.js

    @Autowired
    private RestTemplate restTemplate;

    public Pedido criarPedido(Pedido pedido) {
        return restTemplate.postForObject(apiUrl + "/pedidos", pedido, Pedido.class);
    }

    public Pedido obterPedidoPorId(Long pedidoId) {
        return restTemplate.getForObject(apiUrl + "/pedidos/" + pedidoId, Pedido.class);
    }

    public List<Pedido> obterTodosPedidos() {
        ResponseEntity<List<Pedido>> response = restTemplate.exchange(
            apiUrl + "/pedidos",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Pedido>>() {}
        );

        return response.getBody();
    }

    public void atualizarPedido(Long pedidoId, Pedido pedido) {
        restTemplate.put(apiUrl + "/pedidos/" + pedidoId, pedido);
    }

    public void excluirPedido(Long pedidoId) {
        restTemplate.delete(apiUrl + "/pedidos/" + pedidoId);
    }

    // Outros métodos para interagir com a API Node.js
}
