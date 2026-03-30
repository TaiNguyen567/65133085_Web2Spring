package vidu.ntu65133085.nguyenthanhtai_demosecurity.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vidu.ntu65133085.nguyenthanhtai_demosecurity.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}