package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Entidades.Cardapio;

import java.util.Arrays;
import java.util.List;

@Service
public class CardapioService {

    private final String apiUrl = "https://www.talaverabar.com.br/js"; // Substitua pelo endereço real da sua API Node.js

    @Autowired
    private RestTemplate restTemplate;

    public List<Cardapio> listarItensDoCardapio() {
        Cardapio[] itens = restTemplate.getForObject(apiUrl + "/cardapio", Cardapio[].class);
        return Arrays.asList(itens);
    }

    public Cardapio obterItemDoCardapioPorId(Long itemId) {
        return restTemplate.getForObject(apiUrl + "/cardapio/" + itemId, Cardapio.class);
    }

    public Cardapio criarItemDoCardapio(Cardapio item) {
        return restTemplate.postForObject(apiUrl + "/cardapio", item, Cardapio.class);
    }

    public void atualizarItemDoCardapio(Long itemId, Cardapio item) {
        restTemplate.put(apiUrl + "/cardapio/" + itemId, item);
    }

    public void excluirItemDoCardapio(Long itemId) {
        restTemplate.delete(apiUrl + "/cardapio/" + itemId);
    }

    // Outros métodos para interagir com a API Node.js
}
