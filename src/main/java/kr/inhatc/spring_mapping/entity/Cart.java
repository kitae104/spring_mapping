package kr.inhatc.spring_mapping.entity;

import jakarta.persistence.*;
import kr.inhatc.spring_mapping.utils.audit.entity.BaseEntity;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id")     // 외래키
    private Member member;
}
