package me.vichea.corebaking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AccountType {
    @Id
    @GeneratedValue
    private Long typeId;
    private String typeName;
    private String description;
}
