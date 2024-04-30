package com.azvtech.consortiumdatasourceservice.service;

import com.azvtech.consortiumdatasourceservice.dto.ConsortiumRequest;
import com.azvtech.consortiumdatasourceservice.dto.ConsortiumResponse;

import java.util.List;

/**
 * @author Fellipe Toledo
 */
public interface ConsortiumService {
    void createConsortium(ConsortiumRequest consortium);
    void updateConsortium(ConsortiumRequest consortium, Long consortiumId);
    ConsortiumResponse getConsortiumById(Long consortiumId);
    List<ConsortiumResponse> getAllConsortium();
    void deleteConsortium(Long consortiumId);
}
