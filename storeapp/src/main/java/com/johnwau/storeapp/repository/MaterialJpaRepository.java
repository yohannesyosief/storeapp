package com.johnwau.storeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.johnwau.storeapp.entity.Materials;

@Component
public interface MaterialJpaRepository  extends JpaRepository<Materials,Long>{

	Materials findByName(String name);

}
