package com.mx.api.book.challenge.app.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -980737105923724895L;

    /*@Id
    @GeneratedValue
    private Long id;*/
    @Id
    private String username;
    private String password;
    private String role;
}
