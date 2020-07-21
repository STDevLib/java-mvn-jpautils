package com.froyo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class AuditRecord implements Serializable {

    private LocalDateTime auditDateTime;
    private String auditLogin;
    private String auditProgram;

}
