package kr.inhatc.spring_mapping.entity;

import jakarta.persistence.*;
import kr.inhatc.spring_mapping.constant.OrderStatus;
import kr.inhatc.spring_mapping.utils.audit.entity.BaseEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;                        // 주문 id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;                  // 주문 회원

    private LocalDateTime orderDate;        // 주문 일

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;        // 주문 상태

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();
}
