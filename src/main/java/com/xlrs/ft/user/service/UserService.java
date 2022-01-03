package com.xlrs.ft.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlrs.ft.commons.constant.CommonConstants;
import com.xlrs.ft.commons.entity.BaseRepository;
import com.xlrs.ft.user.entity.Users;
import com.xlrs.ft.user.repository.MongoDBService;
import com.xlrs.ft.user.repository.UserRepository;
import com.xlrs.ft.user.view.UserView;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MongoDBService mongoDBService;
	
	@Autowired
	private BaseRepository<Users> baseRepository;

	public UserView createUser(UserView userView) throws Exception {
		Users user = new Users() ;
		user.setName(userView.getName());
		user.setId(userView.getId());
		user.setSsn(userView.getSsn());
		
		user = userRepository.save(baseRepository.addAuditFeilds(user, null, CommonConstants.STATUS_ACTIVE));
		log.info("insert user object ::" + user.toString());
		
		mongoDBService.insert(user.toString());
		return new UserView(user.getId(), user.getName(), user.getSsn());
	}

	
}
