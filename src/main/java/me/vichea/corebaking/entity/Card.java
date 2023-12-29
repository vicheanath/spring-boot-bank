package me.vichea.corebaking.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Card {
//    -cardNumber: String
//    -expiryDate: Date
//    -cardType: String
//    -status: String
    @Id
    private String cardNumber;
    private LocalDateTime expiryDate;
    private CardType cardType;
    private CardStatus status;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account accountHolder;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
