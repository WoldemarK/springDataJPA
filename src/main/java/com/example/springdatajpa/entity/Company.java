package com.example.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class Company implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Builder.Default
    @ElementCollection
    @MapKeyColumn(name = "lang")
    @Column(name = "description")
    @CollectionTable(name = "company_locales",
            joinColumns = @JoinColumn(name = "company_id"))
    public Map<String, String> locales = new HashMap<>();

}
