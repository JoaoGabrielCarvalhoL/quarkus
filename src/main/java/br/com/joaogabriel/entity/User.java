package br.com.joaogabriel.entity;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The @UserDefinition annotation must be present on a Jakarta Persistence entity,
 * regardless of whether simplified Hibernate ORM with Panache is used or not.
 *
 * The @Username and @Password field types are always String.
 *
 * The @Roles field must either be String, Collection<String>, or a Collection<X>,
 *  where X is an entity class with a single String field annotated as @RolesValue.
 * */

@Entity
@Table(name = "tb_user")
@UserDefinition
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    @Username
    private String username;

    @Column(nullable = false)
    @Password
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @Roles
    private List<Role> roles = new ArrayList<>();

    public User() {}

    public User(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = BcryptUtil.bcryptHash(password);
        this.roles = roles;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
