package com.manuel.company.company;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

}
