package com.app.check.repo;

import com.app.check.model.Check;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * Интерфейс CheckRepository является репозиторием для работы с данными о студентах в базе данных.
 *
 * Аннотация @Repository указывает, что интерфейс является репозиторием Spring Data.
 * Интерфейс наследует JpaRepository, который предоставляет методы для работы с базой данных.
 * Метод findByCassir выполняет поиск чека по кассиру.
 */
public interface  CheckRepository extends JpaRepository<Check, Long> {
    List<Check> findByName(String name);
}
