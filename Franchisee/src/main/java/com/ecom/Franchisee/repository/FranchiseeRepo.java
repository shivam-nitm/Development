package com.ecom.Franchisee.repository;

import com.ecom.Franchisee.entity.FranchiseeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseeRepo extends JpaRepository<FranchiseeEntity,Long> {
    @Modifying
    @Query("update FranchiseeEntity set name =?1 where id = ?2" )
    int updateFranchisee(String name, long id);
}
