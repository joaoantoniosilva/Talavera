package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Entidades.Reservas;

import java.util.Arrays;
import java.util.List;

@Service
public class ReservaService {

    private final String apiUrl = "https://www.talaverabar.com.br/js"; //  API Node.js

    @Autowired
    private RestTemplate restTemplate;

    public List<Reservas> listarReservas() {
        Reservas[] reservas = restTemplate.getForObject(apiUrl + "/reservas", Reservas[].class);
        return Arrays.asList(reservas);
    }

    public Reservas obterReservaPorId(Long reservaId) {
        return restTemplate.getForObject(apiUrl + "/reservas/" + reservaId, Reservas.class);
    }

    public Reservas criarReserva(Reservas reserva) {
        return restTemplate.postForObject(apiUrl + "/reservas", reserva, Reservas.class);
    }

    public void atualizarReserva(Long reservaId, Reservas reserva) {
        restTemplate.put(apiUrl + "/reservas/" + reservaId, reserva);
    }

    public void excluirReserva(Long reservaId) {
        restTemplate.delete(apiUrl + "/reservas/" + reservaId);
    }

  
}
