package com.azvtech.consortiumdatasourceservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * @author Fellipe Toledo
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsortiumRequest {
    @NotBlank
    private String name;
}
