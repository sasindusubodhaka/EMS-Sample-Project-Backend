package admin.demo.repository;

import admin.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findByName(String name);

    @Query("SELECT COUNT(*) FROM Department")
    Integer getDepartmentsCount();


}
