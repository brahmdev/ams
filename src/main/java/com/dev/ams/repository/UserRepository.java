package com.dev.ams.repository;

import com.dev.ams.model.Authorities;
import com.dev.ams.model.ParentDetails;
import com.dev.ams.model.StudentDetails;
import com.dev.ams.model.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<Users, String> {

    @Query(value = "SELECT u FROM Users u WHERE u.username = :userName")
    Optional<Users> findByUserName(@Param("userName") String userName);

    @Query(value = "SELECT sd FROM StudentDetails sd WHERE sd.users.id = :id")
    Set<StudentDetails> findStudentDetailsById(@Param("id") int id);

    @Query(value = "SELECT pd FROM ParentDetails pd WHERE pd.users.id = :id")
    Set<ParentDetails> findParentDetailsById(@Param("id") int id);

    @Query(value = "SELECT a FROM Authorities a WHERE a.username = :userName")
    Iterable<Authorities> findAllAuthoritiesByUsername(@Param("userName") String userName);

    @Query(value = "SELECT u FROM Users u WHERE u.id IN (SELECT a.users.id FROM Authorities a WHERE a.authority = :type) AND u.branch.id = :branchId")
    Iterable<Users> findByUsersByType(Integer branchId, @Param("type") String type);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Users u WHERE u.id = :userId")
    void deleteUserById(Integer userId);
}
