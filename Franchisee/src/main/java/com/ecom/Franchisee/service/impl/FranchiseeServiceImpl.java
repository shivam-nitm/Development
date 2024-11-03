package com.ecom.Franchisee.service.impl;

import com.ecom.Franchisee.entity.FranchiseeEntity;
import com.ecom.Franchisee.exception.FranchiseeNotFoundException;
import com.ecom.Franchisee.repository.FranchiseeRepo;
import com.ecom.Franchisee.service.FranchiseeService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class FranchiseeServiceImpl implements FranchiseeService {

    @Autowired
    public FranchiseeRepo franchiseeRepo;

    @Override
    public FranchiseeEntity getFranchiseeById(long id) {
        var franchisee = franchiseeRepo.findById(id);
       return franchisee.orElseThrow(FranchiseeNotFoundException::new);
    }
    @Override
    public Optional<FranchiseeEntity> saveFranchisee(FranchiseeEntity franchiseeEntity) {
        return Optional.of(franchiseeRepo.saveAndFlush(franchiseeEntity));
    }

    @Override
    public void deleteFranchisee(long id) {
        franchiseeRepo.deleteById(id);
    }

    @Override
    public Optional<FranchiseeEntity> updateFranchisee(long id, final FranchiseeEntity franchiseeEntity) {
        var franchisee = franchiseeRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Franchisee not found"));
        BeanUtils.copyProperties(franchiseeEntity, franchisee);
        return Optional.ofNullable(Optional.of(franchiseeRepo.save(franchisee)).orElseThrow(() -> new RuntimeException("Updated failed")));
    }

    @Override
    public String partiallyUpdateFranchiseeName(long id, String name) {
        var franchiseeUpdated = franchiseeRepo.updateFranchisee(name,id);
        return "Franchisee updated" + franchiseeUpdated;
    }

    @Override
    public FranchiseeEntity updateFranchiseePartial(long id, Map<Object, Object> fieldMap) {
        var franchisee =  franchiseeRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        FranchiseeEntity franchiseeEntity = mapper.convertValue(fieldMap, FranchiseeEntity.class);
        FranchiseeEntity franchiseeEntity1 = FranchiseeEntity.getEntity(franchiseeEntity,franchisee);
        return franchiseeRepo.saveAndFlush(franchiseeEntity1);
    }
}
