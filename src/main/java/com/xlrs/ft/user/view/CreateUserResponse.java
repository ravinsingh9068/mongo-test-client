package com.xlrs.ft.user.view;

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
public class CreateUserResponse implements BaseView{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;

}
