package dev.louiiuol.countries.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.louiiuol.countries.domain.entities.Country;

public interface CountryJpaRepository extends JpaRepository<Country, Long> {

	Optional<Country> findByCode(String iso);

}