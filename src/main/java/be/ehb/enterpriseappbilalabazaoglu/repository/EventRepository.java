package be.ehb.enterpriseappbilalabazaoglu.repository;

import be.ehb.enterpriseappbilalabazaoglu.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EventRepository extends JpaRepository<Event, Long> {
   List<Event> findTop10ByOrderByDateDesc();
}
