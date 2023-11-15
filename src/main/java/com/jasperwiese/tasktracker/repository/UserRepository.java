package com.jasperwiese.tasktracker.repository;

import com.jasperwiese.tasktracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserByEmail(String email);
    /*
    * Update DAO methods for firstName,lastName,mobile,email,password*/
    @Query(
            value = "update user set first_name = :firstName where user_id = :userId",
            nativeQuery = true
    )
    @Modifying
    Integer updateUserFirstNameByUserId(
            @Param("firstName") String firstName,
            @Param("userId") UUID userId
    );
    @Query(
            value = "update user set last_name = :lastName where user_id =:userId",
            nativeQuery = true
    )
    @Modifying
    Integer updateUserLastNameByUserId(
            @Param("lastName") String lastName,
            @Param("userId") UUID userId
    );
    @Query(
            value = "update user set mobile =:mobile where user_id =:userId",
            nativeQuery = true
    )
    @Modifying
    Integer updateUserMobileByUserId(
            @Param("mobile") String mobile,
            @Param("userId") UUID userId
    );
    @Query(
            value = "update user set email =:email where user_id =:userId",
            nativeQuery = true
    )
    @Modifying
    Integer updateUserEmailByUserId(
            @Param("email") String email,
            @Param("userId") UUID userId
    );
    @Query(
            value = "update user set password =:password where user_id=:userId",
            nativeQuery = true

    )
    @Modifying
    Integer updateUserPasswordByUserId(
            @Param("password") String password,
            @Param("userId") UUID userId
    );
    Integer deleteByUserId(UUID userId);
}
