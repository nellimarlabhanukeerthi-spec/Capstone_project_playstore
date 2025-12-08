package com.playstore.adminms.service;

import com.playstore.adminms.entity.Admin;

import java.util.List;

public interface AdminService {

    Admin createAdmin(Admin admin);
    List<Admin> getAllAdmins();
    Admin getAdminById(Long id);
    void deleteAdmin(Long id);
}
