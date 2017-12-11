package pcpartpicker.test.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GpuRepository extends CrudRepository<Gpu, Long> {
    List<Gpu> findByGpuName (String gpuName);
}
