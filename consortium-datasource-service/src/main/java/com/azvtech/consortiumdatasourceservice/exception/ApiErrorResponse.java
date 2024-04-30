package com.azvtech.consortiumdatasourceservice.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Fellipe Toledo
 */
@Builder
@Getter
@Setter
public class ApiErrorResponse {
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;
    private Integer code;
    private String status;
    private List<String> errors;
}
