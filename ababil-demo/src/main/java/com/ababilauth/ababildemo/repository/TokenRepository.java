package com.ababilauth.ababildemo.repository;

import com.ababilauth.ababildemo.entity.TokenStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface  TokenRepository extends JpaRepository<TokenStore, Long> {

    public List<TokenStore> findByIsExpired(@Param("value") int value);
    public List<TokenStore> findByExpiresAtAfter(Date today);
    public List<TokenStore> findByExpiresAtGreaterThan(Integer present);
//    public void save(TokenStore);
}
