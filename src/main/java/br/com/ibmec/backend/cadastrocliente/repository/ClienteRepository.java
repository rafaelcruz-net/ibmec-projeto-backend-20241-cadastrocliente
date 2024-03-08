package br.com.ibmec.backend.cadastrocliente.repository;

import br.com.ibmec.backend.cadastrocliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
