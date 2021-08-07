package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="ogrenci")
@NoArgsConstructor
public class Ogrenci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ogrenciname")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "department")
    private String department;

}


