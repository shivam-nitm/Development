package com.ecom.Franchisee.service;

import com.ecom.Franchisee.entity.FranchiseeEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public interface FranchiseeService {

     FranchiseeEntity getFranchiseeById(long id);
     Optional<FranchiseeEntity> saveFranchisee(FranchiseeEntity franchiseeEntity);
     void deleteFranchisee(long id);
     Optional<FranchiseeEntity> updateFranchisee(long id, FranchiseeEntity franchiseeEntity);
     String partiallyUpdateFranchiseeName(long id, String name);
     FranchiseeEntity updateFranchiseePartial(long id, Map<Object, Object> fieldMap);
}
