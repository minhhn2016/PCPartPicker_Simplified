package pcpartpicker.test.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CpuRepository extends CrudRepository<Cpu, Long> {
    List<Cpu> findByCpuName(String cpuName);
}
