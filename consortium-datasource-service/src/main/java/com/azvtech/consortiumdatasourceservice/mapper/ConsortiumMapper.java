package com.azvtech.consortiumdatasourceservice.mapper;

import com.azvtech.consortiumdatasourceservice.dto.ConsortiumRequest;
import com.azvtech.consortiumdatasourceservice.dto.ConsortiumResponse;
import com.azvtech.consortiumdatasourceservice.model.Consortium;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fellipe Toledo
 */
@Component
@RequiredArgsConstructor
public class ConsortiumMapper {
    private final ModelMapper mapper;

    public ConsortiumResponse consortiumDaoToConsortiumDto(Consortium consortium) {
        return mapper.map(consortium, ConsortiumResponse.class);
    }
    public Consortium consortiumDtoToConsortiumDao(ConsortiumRequest consortium) {
        return mapper.map(consortium, Consortium.class);
    }

    public List<ConsortiumResponse> toConsortiumDtoList(List<Consortium> consortia) {
        return consortia.stream().map(this::consortiumDaoToConsortiumDto)
                .collect(Collectors.toList());
    }
}
