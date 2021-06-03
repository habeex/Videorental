package com.example.videorental.repository;


import com.example.videorental.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface to manage {@code User} instances.
 *
 * @author Olorunishola Habeeb
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findById(long id);

	User findByEmail(String email);

	Page<User> findAll(Specification<User> spec, Pageable pageable);

}
