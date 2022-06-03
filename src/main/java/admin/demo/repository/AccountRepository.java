package admin.demo.repository;

import admin.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByEmail(String email);

    @Query("SELECT COUNT(*) FROM Account")
    Integer getRegisteredUserCount();

    @Query("SELECT COUNT(DISTINCT role) FROM Account")
    Integer getUserRoleCount();

    @Query("SELECT u.createdOn FROM Account u ")
    List<LocalDate> getRegisteredDates();

    @Query("SELECT COUNT(*) FROM Account a WHERE a.department= :department")
    Integer getUserCount(@Param("department") String department);

}
