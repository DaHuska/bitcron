package bg.softuni.bitchron.repository;

import bg.softuni.bitchron.model.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UserRoleEntity, Long> {

}
