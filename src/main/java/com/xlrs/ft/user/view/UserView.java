package com.xlrs.ft.user.view;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.xlrs.ft.commons.view.BaseView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class UserView implements BaseView{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message = "{user.name.mandatory.feild.notempty}")
	private String name;
	
	@NotEmpty(message = "{user.ssn.mandatory.feild.notempty}")
	private String ssn;
}
