package com.ecom.Franchisee.controller;

import com.ecom.Franchisee.entity.FranchiseeEntity;
import com.ecom.Franchisee.service.FranchiseeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FranchiseeController {

    public final FranchiseeService franchiseeService;

   public FranchiseeController(FranchiseeService franchiseeService){
       this.franchiseeService = franchiseeService;
   }

    @GetMapping("/ping")
    public String ping(){
        return "the app is running";
    }
@PostMapping("/franchisee")
    public ResponseEntity<FranchiseeEntity> createFranchisee(@RequestBody FranchiseeEntity franchiseeEntity ){
    Optional<FranchiseeEntity> save = franchiseeService.saveFranchisee(franchiseeEntity);
       return ResponseEntity.status(HttpStatus.CREATED).body(save.get());
    }
@GetMapping("/franchisee/{id}")
    public ResponseEntity<FranchiseeEntity> getFranchisee( @PathVariable long id) {
    FranchiseeEntity franchiseeById = franchiseeService.getFranchiseeById(id);
    return ResponseEntity.status(HttpStatus.OK).body(franchiseeById);
}

@DeleteMapping("/franchisee/{id}")
    public ResponseEntity<String> deleteFranchisee(@PathVariable final long id){
       franchiseeService.deleteFranchisee(id);
       return ResponseEntity.status(HttpStatus.OK).body("Franchisee deleted successfully");
}

@PutMapping("/franchisee/{id}")
    public ResponseEntity<FranchiseeEntity> updateFranchisee(@PathVariable final long id, @RequestBody final FranchiseeEntity franchisee){
       var franchiseeUpdated = franchiseeService.updateFranchisee(id,franchisee);
       return ResponseEntity.status(HttpStatus.OK).body(franchiseeUpdated.get());
}

@PatchMapping("/franchisee/{id}")
    public ResponseEntity<FranchiseeEntity> partialUpdateFranchisee(@PathVariable final long id, @RequestBody final Map<Object, Object> fieldMap){
    var franchisee = franchiseeService.updateFranchiseePartial(id, fieldMap);
    return ResponseEntity.status(HttpStatus.OK).body(franchisee);
   }

}
