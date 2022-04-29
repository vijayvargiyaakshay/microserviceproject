package com.sp.user.service;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sp.user.VO.Department;
import com.sp.user.VO.ResponseTemplateVO;
import com.sp.user.entity.User;
import com.sp.user.repository.UserRepository;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
		 log.info("Inside saveUser of UserService"); 
        return userRepository.save(user);
    }
    public User getUser(Long id) {
		 log.info("Inside saveUser of UserService"); 
		 System.out.println("This is User Data "+ userRepository.findByUserId(id));
       return userRepository.findByUserId(id);
   }
    	
    public ResponseTemplateVO getUserWithDepartment(Long userId) {
		 log.info("Inside getUserWithDepartment of UserService"); 
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        System.out.println("This is user data   "+user);
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
                        ,Department.class);
        System.out.println("This is department data   "+user.getDepartmentId());
        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;
    }
}
