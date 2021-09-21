package com.fila.Spring_Boo_.and_Thymeleaf.Repository;

import com.fila.Spring_Boo_.and_Thymeleaf.Model.Emprego;
import org.springframework.data.repository.CrudRepository;

public interface EmpregoRepository extends CrudRepository <Emprego, Long> {
}
