package Entidades;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CategoriaDoCardapio {

   

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String descricao;

	    void CategoriaMenu(String descricao) {
	        this.descricao = descricao;
	    }

	    public String getDescricao() {
	        return descricao;
	    }
}
