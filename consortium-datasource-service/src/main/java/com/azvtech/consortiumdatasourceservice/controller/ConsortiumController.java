package com.azvtech.consortiumdatasourceservice.controller;

import com.azvtech.consortiumdatasourceservice.dto.ConsortiumRequest;
import com.azvtech.consortiumdatasourceservice.dto.ConsortiumResponse;
import com.azvtech.consortiumdatasourceservice.service.ConsortiumService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Fellipe Toledo
 */
@RestController
@RequestMapping("/api/v1/rioonibus-datasource/consortium")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConsortiumController {
    private final ConsortiumService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createConsortium(
            @Valid
            @RequestBody
            ConsortiumRequest consortium) {
        service.createConsortium(consortium);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateConsortium(
            @Valid
            @RequestBody
            ConsortiumRequest consortium,
            @PathVariable("id") long id) {
        this.service.updateConsortium(consortium, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteConsortium(
            @PathVariable("id")
            long id) {
        this.service.deleteConsortium(id);

    }

    @GetMapping("/all")
    public List<ConsortiumResponse> getAllConsortium() {
        return service.getAllConsortium();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsortiumResponse> getConsortiumById(
            @PathVariable
            long id) {
        return ResponseEntity.ok(this.service.getConsortiumById(id));
    }
}
