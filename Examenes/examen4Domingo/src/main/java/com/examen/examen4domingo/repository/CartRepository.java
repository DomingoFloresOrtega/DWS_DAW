package com.examen.examen4domingo.repository;

import com.examen.examen4domingo.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query(value = "select * from cart_item where user_id = :id", nativeQuery = true)
    public List<Cart> queryFindAllById(@Param("id") Optional<String> id);
}
