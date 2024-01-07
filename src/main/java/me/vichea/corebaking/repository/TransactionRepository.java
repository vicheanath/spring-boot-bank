package me.vichea.corebaking.repository;

import me.vichea.corebaking.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
