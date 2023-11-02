package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Entidades.Estoque;

import java.util.Arrays;
import java.util.List;

@Service
public class EstoqueService {

    private final String apiUrl = "https://www.talaverabar.com.br/js"; //  API Node.js

    @Autowired
    private RestTemplate restTemplate;

    public List<Estoque> listarInformacoesDeEstoque() {
        Estoque[] estoque = restTemplate.getForObject(apiUrl + "/estoque", Estoque[].class);
        return Arrays.asList(estoque);
    }

    public Estoque obterInformacoesDeEstoquePorId(Long estoqueId) {
        return restTemplate.getForObject(apiUrl + "/estoque/" + estoqueId, Estoque.class);
    }

    public Estoque criarInformacoesDeEstoque(Estoque estoque) {
        return restTemplate.postForObject(apiUrl + "/estoque", estoque, Estoque.class);
    }

    public void atualizarInformacoesDeEstoque(Long estoqueId, Estoque estoque) {
        restTemplate.put(apiUrl + "/estoque/" + estoqueId, estoque);
    }

    public void excluirInformacoesDeEstoque(Long estoqueId) {
        restTemplate.delete(apiUrl + "/estoque/" + estoqueId);
    }

   
}

