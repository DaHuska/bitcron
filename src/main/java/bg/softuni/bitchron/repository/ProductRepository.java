package bg.softuni.bitchron.repository;

import bg.softuni.bitchron.model.entity.WatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<WatchEntity, Long> {

}
