package com.sh.validator.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataIn {
	
	@JsonProperty
	@NotNull(message="name can not be null")
	@NotBlank(message="name can not be empty")
	private String name;
	
	@JsonProperty
	@NotNull(message="age can not be null")
	private Integer age;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "DataIn [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
}
