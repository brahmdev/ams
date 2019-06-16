package com.dev.ams.repository;

import com.dev.ams.model.Authorities;
import com.dev.ams.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Users, String> {

    @Query(value = "SELECT u FROM Users u WHERE u.username = :userName")
    Optional<Users> findByUserName(@Param("userName") String userName);

    @Query(value = "SELECT a FROM Authorities a WHERE a.username = :userName")
    Iterable<Authorities> findAllAuthoritiesByUsername(@Param("userName") String userName);

    @Query(value = "SELECT u FROM Users u WHERE u.id IN (SELECT a.users.id FROM Authorities a WHERE a.authority = :type) AND u.branch.id = :branchId")
    Iterable<Users> findByUsersByType(Integer branchId, @Param("type") String type);
}
