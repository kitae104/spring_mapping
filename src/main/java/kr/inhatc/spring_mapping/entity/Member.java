package kr.inhatc.spring_mapping.entity;

import jakarta.persistence.*;
import kr.inhatc.spring_mapping.constant.Role;
import kr.inhatc.spring_mapping.utils.audit.entity.BaseEntity;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    private String address;

    @Enumerated(EnumType.STRING)  // 문자열 형태로 사용
    @Column(nullable = false, length = 20, columnDefinition = "varchar(20) default 'USER'")
    private Role role;
}
