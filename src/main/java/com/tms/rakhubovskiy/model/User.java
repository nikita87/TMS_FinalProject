package com.tms.rakhubovskiy.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username; // логин для входа в приложение и аутентификации - email

    @Column(name = "password")
    private String password; // пароль для входа и проверки пользователя

    @Column(name = "firstname")
    private String firstname; // имя пользователя

    @Column(name = "lastname") // фамилия пользователя
    private String lastname;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
               joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
               inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;
}
