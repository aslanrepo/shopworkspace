package ru.baa.shop.root.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class CreationDateEntity extends BaseEntity {
	protected LocalDateTime creationDate;

	protected CreationDateEntity() {
	}
}
