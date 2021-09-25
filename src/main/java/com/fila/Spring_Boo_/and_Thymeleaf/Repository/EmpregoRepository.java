package com.fila.Spring_Boo_.and_Thymeleaf.Repository;

import com.fila.Spring_Boo_.and_Thymeleaf.Model.Emprego;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpregoRepository extends CrudRepository <Emprego, Long> {
}
