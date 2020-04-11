package net.gxu.bsms.test;

import net.gxu.bsms.entity.Admin;
import net.gxu.bsms.service.AdminService;

public class AdminTest {
    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        Admin admin;

        admin = adminService.getAdminByName("admin2");
        System.out.println(admin);
        admin.setPassword("admin123");
////        System.out.println(admin);
        int flag = adminService.updatePwd(admin);
        System.out.println(flag);
////        admin = adminService.getAdminByName("admin");
////        System.out.println(admin);
        }

}
