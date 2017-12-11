package pcpartpicker.test.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MotherboardRepository extends CrudRepository<Motherboard, Long> {
    List<Motherboard> findByMotherboardName (String motherboardName);
}
