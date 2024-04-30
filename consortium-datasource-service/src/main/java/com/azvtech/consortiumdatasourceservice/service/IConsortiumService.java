package com.azvtech.consortiumdatasourceservice.service;

import com.azvtech.consortiumdatasourceservice.dto.ConsortiumRequest;
import com.azvtech.consortiumdatasourceservice.dto.ConsortiumResponse;
import com.azvtech.consortiumdatasourceservice.exception.ResourceNotFoundException;
import com.azvtech.consortiumdatasourceservice.mapper.ConsortiumMapper;
import com.azvtech.consortiumdatasourceservice.model.Consortium;
import com.azvtech.consortiumdatasourceservice.repository.ConsortiumRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Fellipe Toledo
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class IConsortiumService implements ConsortiumService {

    private final ConsortiumRepository repository;
    private final ConsortiumMapper mapper;

    @Override
    public void createConsortium(ConsortiumRequest consortiumRequest) {
        Consortium mappedConsortium = mapper.consortiumDtoToConsortiumDao(consortiumRequest);
        repository.save(mappedConsortium);
        log.info("Consortium {} is saved", mappedConsortium.getId());

    }

    @Override
    public void updateConsortium(ConsortiumRequest consortium, Long consortiumId) {
        Consortium findConsortium = repository.findById(consortiumId)
                .orElseThrow(() -> new ResourceNotFoundException("Consortium", "Id", consortiumId));
        findConsortium.setName(consortium.getName());
        repository.save(findConsortium);
        log.info("Consortium {} is updated", findConsortium.getId());
    }

    @Override
    public ConsortiumResponse getConsortiumById(Long consortiumId) {
        Consortium findConsortium = repository.findById(consortiumId)
                .orElseThrow(() -> new ResourceNotFoundException("Consortium", "Id", consortiumId));
        return mapper.consortiumDaoToConsortiumDto(findConsortium);
    }

    @Override
    public List<ConsortiumResponse> getAllConsortium() {
        List<Consortium> consortia = repository.findAll();
        return mapper.toConsortiumDtoList(consortia);
    }

    @Override
    public void deleteConsortium(Long consortiumId) {
        Consortium findConsortium = repository.findById(consortiumId)
                .orElseThrow(() -> new ResourceNotFoundException("Consortium", "Id", consortiumId));
        repository.deleteById(consortiumId);
        log.info("Consortium {} is deleted", findConsortium.getId());
    }
}
