package com.xlrs.ft.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xlrs.ft.commons.controller.AbstractRestHandler;
import com.xlrs.ft.commons.exception.ApplicationException;
import com.xlrs.ft.commons.exception.NoResultFoundException;
import com.xlrs.ft.commons.view.ResponseView;
import com.xlrs.ft.user.service.UserService;
import com.xlrs.ft.user.view.UserView;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/mongo")
@Slf4j
public class MongoController extends AbstractRestHandler {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageSource messages;

	@PostMapping("/create")
	public ResponseView createUser(@RequestBody UserView createUserView) throws Exception {
		log.debug("Requested payload is : " + createUserView);
		
		try {
			return new ResponseView(userService.createUser(createUserView));
		} catch (NoResultFoundException e) {
			throw new NoResultFoundException(e.getMessage());
		} catch (Exception e) {
			throw new ApplicationException(messages.getMessage("err.general.error.message", null, null));
		}
	}
	
	
}
