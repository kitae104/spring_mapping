package kr.inhatc.spring_mapping.entity;

import jakarta.persistence.*;
import kr.inhatc.spring_mapping.utils.audit.entity.BaseEntity;
import lombok.*;

@Entity
@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;                    // 주문 상품 id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;                // 주문

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;                  // 주문 상품

    private int orderPrice;             // 주문 가격

    private int count;                  // 주문 수량
}
