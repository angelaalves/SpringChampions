package com.academyproject.championsacademyleague.accesingdatamysql;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called playerRepository
// CRUD refers Create, Read, Update, Delete

public interface playerRepository extends CrudRepository<player, Integer> {
}