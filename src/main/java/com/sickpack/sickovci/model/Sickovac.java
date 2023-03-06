package com.sickpack.sickovci.model;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Table("SICKOVCI")
public class Sickovac {
	@Id
	private Integer id;
	@NotBlank
	private String name;
	@Column("LAST_NAME")
	private String lastName;
	private Level level;
	private Integer age;
	@Column("DATE_ADDED")
	private LocalDateTime dateAdded;
	@Column("DATE_MODIFIED")
	private LocalDateTime dateModified;
}
