package com.froyo.model.entity;

import lombok.Data;
import org.apache.logging.log4j.ThreadContext;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.froyo.model.entity.ContextKey.AUDIT_LOGIN;
import static com.froyo.model.entity.ContextKey.AUDIT_PROGRAM_NAME;

@Data
public class AbstractAuditableEntity {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "auditDateTime",column = @Column(name = "audit_datetime_insert",updatable = false)),
            @AttributeOverride(name = "auditLogin",column = @Column(name = "audit_login_insert",updatable = false)),
            @AttributeOverride(name = "auditProgram",column = @Column(name = "audit_program_insert",updatable = false))
    })
    private AuditRecord auditRecordInsert;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "auditDateTime",column = @Column(name = "audit_datetime_update",insertable = false)),
            @AttributeOverride(name = "auditLogin",column = @Column(name = "audit_login_update",insertable = false)),
            @AttributeOverride(name = "auditProgram",column = @Column(name = "audit_program_update",insertable = false))
    })
    private AuditRecord auditRecordUpdate;

    @PrePersist
    public void insertAutoSetting(){
        setAuditRecordInsert(new AuditRecord(LocalDateTime.now(), //
                ThreadContext.get(AUDIT_LOGIN),ThreadContext.get(AUDIT_PROGRAM_NAME)));
    }

    @PreUpdate
    public void updateAutoSetting(){
        setAuditRecordUpdate(new AuditRecord(LocalDateTime.now(), //
                ThreadContext.get(AUDIT_LOGIN),ThreadContext.get(AUDIT_PROGRAM_NAME)));
    }

}
