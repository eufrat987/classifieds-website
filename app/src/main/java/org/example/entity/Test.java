package org.example.entity;

import jakarta.persistence.*;

@Entity
public class Test {
	@Id
	private Long id;

	@Column(nullable = false, length = 30)
	private String desc;
}
