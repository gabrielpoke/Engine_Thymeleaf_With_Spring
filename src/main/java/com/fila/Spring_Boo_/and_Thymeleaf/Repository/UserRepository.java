package com.fila.Spring_Boo_.and_Thymeleaf.Repository;

import com.fila.Spring_Boo_.and_Thymeleaf.Model.Usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Usuarios, Long> {

    Usuarios findByUsername(String username);

}
