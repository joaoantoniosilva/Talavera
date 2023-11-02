package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Entidades.CategoriaDoCardapio;


import java.util.Arrays;
import java.util.List;

@Service
public class CategoriaService<CategoriaDocardapio> {

    private final String apiUrl = "https://www.talaverabar.com.br/js"; // Substitua pelo endereço real da sua API Node.js

    @Autowired
    private RestTemplate restTemplate;


    public List<CategoriaDoCardapio> listarCategoriasDoCardapio() {
        CategoriaDoCardapio[] categorias = restTemplate.getForObject(apiUrl + "/categorias", CategoriaDoCardapio[].class);
        return Arrays.asList(categorias);
    }

    public CategoriaDoCardapio criarCategoria(CategoriaDoCardapio categoria) {
        return restTemplate.postForObject(apiUrl + "/categorias", categoria, CategoriaDoCardapio.class);
    }

    public void atualizarCategoria(Long categoriaId, CategoriaDoCardapio categoria) {
        restTemplate.put(apiUrl + "/categorias/" + categoriaId, categoria);
    }

    public void excluirCategoria(Long categoriaId) {
        restTemplate.delete(apiUrl + "/categorias/" + categoriaId);
    }

    // Outros métodos para interagir com a API Node.js
    public List<CategoriaDoCardapio> buscarCategoriasPorNome(String nome) {
        CategoriaDoCardapio[] categorias = restTemplate.getForObject(apiUrl + "/categorias?nome=" + nome, CategoriaDoCardapio[].class);
        return Arrays.asList(categorias);
    }

    public List<CategoriaDoCardapio> buscarCategoriasPorDescricao(String descricao) {
        CategoriaDoCardapio[] categorias = restTemplate.getForObject(apiUrl + "/categorias?descricao=" + descricao, CategoriaDoCardapio[].class);
        return Arrays.asList(categorias);
    }

    // Adicione outros métodos conforme necessário para atender às operações da API Node.js
}
