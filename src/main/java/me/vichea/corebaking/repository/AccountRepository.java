package me.vichea.corebaking.repository;

import me.vichea.corebaking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
