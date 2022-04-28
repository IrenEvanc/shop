package company.repository;

import company.entity.Check;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CheckRepository extends JpaRepository<Check, Long> {
}
