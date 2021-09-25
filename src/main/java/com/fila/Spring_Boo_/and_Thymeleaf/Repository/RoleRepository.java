package com.fila.Spring_Boo_.and_Thymeleaf.Repository;

import com.fila.Spring_Boo_.and_Thymeleaf.Model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByRole(String role);

}
