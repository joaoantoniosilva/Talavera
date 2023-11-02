package Entidades;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Iterator;
import java.util.Set;

import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;

@Entity
@Table(name = "usuarios")
public class Usuario implements User {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String nome;
	    private String email;
	    private String senha;
	    
	   

	    @ElementCollection(targetClass = Papel.class, fetch = FetchType.EAGER)
	    @Enumerated(EnumType.STRING)
	    private Set<Papel> papeis;

	    // Outros atributos, construtores, getters e setters

	    // Métodos construtores

	    public Usuario() {
	    }

	    public Usuario(String nome, String email, String senha, Set<Papel> papeis) {
	        this.nome = nome;
	        this.email = email;
	        this.senha = senha;
	        this.papeis = papeis;
	    }

	    // Getters e setters

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getSenha() {
	        return senha;
	    }

	    public void setSenha(String senha) {
	        this.senha = senha;
	    }

	    public Set<Papel> getPapeis() {
	        return papeis;
	    }

	    public void setPapeis(Set<Papel> papeis) {
	        this.papeis = papeis;
	    }

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getFullName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setFullName(String fullName) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Iterator<Group> getGroups() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setPassword(String password) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Iterator<Role> getRoles() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public UserDatabase getUserDatabase() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setUsername(String username) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addGroup(Group group) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addRole(Role role) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean isInGroup(Group group) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isInRole(Role role) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void removeGroup(Group group) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeGroups() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeRole(Role role) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeRoles() {
			// TODO Auto-generated method stub
			
		}
	}
