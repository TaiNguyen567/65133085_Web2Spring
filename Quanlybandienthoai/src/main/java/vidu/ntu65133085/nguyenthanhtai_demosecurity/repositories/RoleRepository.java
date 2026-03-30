package vidu.ntu65133085.nguyenthanhtai_demosecurity.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vidu.ntu65133085.nguyenthanhtai_demosecurity.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(String name);
}