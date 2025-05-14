package exam.project.backend.backend_project_exam.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import exam.project.backend.backend_project_exam.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
