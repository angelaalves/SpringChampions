package com.academyproject.championsacademyleague.accesingdatamysql.events;

import org.springframework.data.repository.CrudRepository;

public interface EventsRepository extends CrudRepository<Events, Integer> {
}
