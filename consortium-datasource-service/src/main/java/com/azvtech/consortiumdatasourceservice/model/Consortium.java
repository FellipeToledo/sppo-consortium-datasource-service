package com.azvtech.consortiumdatasourceservice.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Fellipe Toledo
 */

@Entity
@Getter
@Setter
@Table(name = "companies")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consortium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

}
