package me.vichea.corebaking.repository;

import me.vichea.corebaking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
