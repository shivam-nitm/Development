package com.ecom.Franchisee.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Franchisee")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FranchiseeEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "location")
    private String location;

    public static FranchiseeEntity getEntity(FranchiseeEntity franchiseeEntity, FranchiseeEntity franchiseeEntity2 ){
       FranchiseeEntity franchisee = new FranchiseeEntity();
       franchisee.setId(franchiseeEntity.getId() != 0L ? franchiseeEntity.getId() : franchiseeEntity2.getId());
       franchisee.setCity(franchiseeEntity.getCity() != null ? franchiseeEntity.getCity() : franchiseeEntity2.getCity());
       franchisee.setName(franchiseeEntity.getName() != null ? franchiseeEntity.getName() : franchiseeEntity2.getName());
       franchisee.setState(franchiseeEntity.getState() != null ? franchiseeEntity.getState() : franchiseeEntity2.getState());
       franchisee.setLocation(franchiseeEntity.getLocation() != null ? franchiseeEntity.getLocation() : franchiseeEntity2.getLocation());
       return franchisee;
    }
}
