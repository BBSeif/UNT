package kz.prog.repository;

import kz.prog.entity.Results;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Results, Long > {
}
