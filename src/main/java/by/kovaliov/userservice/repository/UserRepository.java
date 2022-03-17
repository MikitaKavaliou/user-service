package by.kovaliov.userservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.kovaliov.userservice.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {}
