package Service;

import java.util.HashSet;
import java.util.List;


import javax.management.relation.Role;
import javax.swing.text.PasswordView;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Entidades.Usuario;
import Repository.UserRepository;


@Service
public class UsuarioService {

    private final String apiUrl = "https://www.talaverabar.com.br/js"; // Substitua pelo endereço real da sua API Node.js


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;
    
    @SuppressWarnings("rawtypes")
	@Autowired
    private CrudRepository roleRepository;

    @Autowired
    private PasswordView passwordEncoder;

    public User saveUser(User user) {
        // Codificar a senha antes de salvar no banco de dados
        user.setPassword((user.getPassword()));
        return userRepository.save(user);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public void assignRoles(User user, List<String> roleNames) {
        List<Role> roles = roleRepository(roleNames);
        deleteUser(new HashSet<>(roles));
        userRepository.save(user);
    }

    private void deleteUser(Object userId) {
		
	}

	private List<Role> roleRepository(List<String> roleNames) {
		return null;
	}

	public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void deleteUser(Long userId) {
    	  userRepository.deleteById(userId);
    }

	public String getApiUrl() {
		return apiUrl;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public CrudRepository<?, ?> getRoleRepository() {
		return roleRepository;
	}

	public void setRoleRepository(CrudRepository<?, ?> roleRepository) {
		this.roleRepository = roleRepository;
	}

	public PasswordView getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordView passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
}
      
    

    

    // Outros métodos para interagir com a API Node.js
