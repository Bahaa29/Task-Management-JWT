package com.example.banquemisr.challenge05.model;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import jakarta.persistence.*;
@Entity
@Data
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
