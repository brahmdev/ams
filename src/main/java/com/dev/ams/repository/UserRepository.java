package com.dev.ams.repository;

import com.dev.ams.model.Authorities;
import com.dev.ams.model.Board;
import com.dev.ams.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Users, String> {

    @Query(value = "SELECT u FROM Users u WHERE u.username = :userName")
    public Optional<Users> findByUserName(@Param("userName") String userName);

    @Query(value = "SELECT a FROM Authorities a WHERE a.username = :userName")
    public Iterable<Authorities> findAllAuthoritiesByUsername(@Param("userName") String userName);
}
