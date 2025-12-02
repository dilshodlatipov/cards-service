package com.example.cardsservice.domain;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class defines basic fields of domains.
 * */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class BaseIdentity {
    @Id
    private UUID id;
    @CreatedBy
    private UUID createdById;
    @LastModifiedBy
    private UUID modifiedById;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;
    @Builder.Default
    private boolean deleted = false;
}
