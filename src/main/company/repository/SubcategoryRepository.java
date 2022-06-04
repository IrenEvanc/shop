package company.repository;

import company.entity.Category.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
}
