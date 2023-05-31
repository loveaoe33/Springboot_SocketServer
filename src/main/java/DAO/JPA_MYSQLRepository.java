package DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface JPA_MYSQLRepository extends JpaRepository<JPA_MYSQL, Long> {
    @Query(value = "select * from cnnface c where c.id=:id", nativeQuery = true)
    JPA_MYSQL QueryOne_JPA(int id);
}