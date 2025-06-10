package com.perfulandia.soporte.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "clientes")
public class Cliente {
    @Id
    @Column(name = "id_cliente")
    private Integer id;
}
