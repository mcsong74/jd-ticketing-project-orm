package com.cybertek.entity;

import com.cybertek.enums.Gender;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="users")
public class User extends BaseEntity{
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean enabled;
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id")
    private Role role;

    @Enumerated(EnumType.STRING)
    private Gender gender;


}
