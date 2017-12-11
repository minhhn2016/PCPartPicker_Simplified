package pcpartpicker.test.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RamRepository extends CrudRepository<Ram, Long> {
    List<Ram> findByRamName (String ramName);
}
