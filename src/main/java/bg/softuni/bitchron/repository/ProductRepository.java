package bg.softuni.bitchron.repository;

import bg.softuni.bitchron.model.entity.WatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<WatchEntity, Long> {
    List<WatchEntity> findAll();
    Optional<WatchEntity> findById(Long id);
}
