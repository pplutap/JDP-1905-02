package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Modifying
    @Query("update User u set u.status = :status where u.id=:id")
    int updateUserSetStatusForId(@Param("status") String status, @Param("id") Long id);

    @Modifying
    @Query("update User u set u.userKey = :userKey where u.id=:id")
    int updateUserSetUserKeyForId(@Param("userKey") Long userKey, @Param("id") Long id);



}
