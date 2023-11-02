package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Entidades.Mesa;

import java.util.Arrays;
import java.util.List;

@Service
public class MesaService {

    private final String apiUrl = "https://www.talaverabar.com.br/js"; //  API Node.js

    @Autowired
    private RestTemplate restTemplate;

    public List<Mesa> listarMesas() {
        Mesa[] mesas = restTemplate.getForObject(apiUrl + "/mesas", Mesa[].class);
        return Arrays.asList(mesas);
    }

    public Mesa obterMesaPorId(Long mesaId) {
        return restTemplate.getForObject(apiUrl + "/mesas/" + mesaId, Mesa.class);
    }

    public Mesa criarMesa(Mesa mesa) {
        return restTemplate.postForObject(apiUrl + "/mesas", mesa, Mesa.class);
    }

    public void atualizarMesa(Long mesaId, Mesa mesa) {
        restTemplate.put(apiUrl + "/mesas/" + mesaId, mesa);
    }

    public void excluirMesa(Long mesaId) {
        restTemplate.delete(apiUrl + "/mesas/" + mesaId);
    }

   
}
