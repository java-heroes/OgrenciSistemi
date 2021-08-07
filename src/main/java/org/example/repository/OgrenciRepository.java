package org.example.repository;

import org.example.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface OgrenciRepository extends JpaRepository<Ogrenci , Integer> {
}
