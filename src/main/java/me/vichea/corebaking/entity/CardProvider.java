package me.vichea.corebaking.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "card_provider")
public class CardProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardProviderId;
    private String cardProviderName;
    private String description;
    private String code;
    private String logo;
    private String status;

}
