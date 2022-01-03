package com.xlrs.ft.user.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.xlrs.ft.commons.entity.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude(Include.NON_NULL)
public class Users extends AbstractEntity{

	private static final long serialVersionUID = 1779829476650834122L;
	
	@NotEmpty(message = "{user.ssn.mandatory.feild.notempty}")
	private String ssn;
	@NotEmpty(message = "{user.name.mandatory.feild.notempty}")
	private String name;
	
	

}
