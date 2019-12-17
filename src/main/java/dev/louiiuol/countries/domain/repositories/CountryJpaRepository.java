package dev.louiiuol.countries.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.louiiuol.countries.domain.entities.Country;

public interface CountryJpaRepository extends JpaRepository<Country, Long> {
    
    boolean existsByCode(String codeIso);

    Country findByCode(String codeIso);

}