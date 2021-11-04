package lk.abc.service.impl;

import lk.abc.entity.Admin;
import lk.abc.repo.AdminRepo;
import lk.abc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author Tharushi Welarathna <nirmanitharushi1@gmail.com>
 * @since 10/25/2021
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {



    @Autowired
    private AdminRepo adminRepo;


    enum admin_result{ADMINNOTFOUND,ADMINDETAILRIGHT,ADMINDETAILWRONG}




    @Override
    public Enum checkAdmin(String email, String password) {
        Optional<Admin> admin = adminRepo.findById(email);
        if(admin.isPresent()){
            Admin adminResult = admin.get();
            if(adminResult.getPassword().equals(password.trim())){
                return admin_result.ADMINDETAILRIGHT;
            }else {
                return admin_result.ADMINDETAILWRONG;
            }
        }
        return admin_result.ADMINNOTFOUND;
    }



}
