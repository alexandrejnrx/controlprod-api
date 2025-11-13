package br.com.alexandrejnrx.controlprodapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "client_type",  nullable = false, length = 10)
    private ClientType clientType;
    @Column(nullable = false)
    private Boolean active;
}
