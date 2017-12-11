package pcpartpicker.test.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuildRepository extends CrudRepository<Build, Long> {
    List<Build> findByBuildName (String buildName);
}
