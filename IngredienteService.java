package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Entidades.Ingredientes;

import java.util.Arrays;
import java.util.List;

@Service
public class IngredienteService {

    private final String apiUrl = "https://www.talaverabar.com.br/js"; //  API Node.js

    @Autowired
    private RestTemplate restTemplate;

    public List<Ingredientes> listarIngredientes() {
        Ingredientes[] ingredientes = restTemplate.getForObject(apiUrl + "/ingredientes", Ingredientes[].class);
        return Arrays.asList(ingredientes);
    }

    public Ingredientes obterIngredientePorId(Long ingredienteId) {
        return restTemplate.getForObject(apiUrl + "/ingredientes/" + ingredienteId, Ingredientes.class);
    }

    public Ingredientes criarIngrediente(Ingredientes ingredientes) {
        return restTemplate.postForObject(apiUrl + "/ingredientes", ingredientes, Ingredientes.class);
    }

    public void atualizarIngrediente(Long ingredienteId, Ingredientes ingrediente) {
        restTemplate.put(apiUrl + "/ingredientes/" + ingredienteId, ingrediente);
    }

    public void excluirIngrediente(Long ingredienteId) {
        restTemplate.delete(apiUrl + "/ingredientes/" + ingredienteId);
    }

    // Outros métodos para interagir com a API Node.js
}
