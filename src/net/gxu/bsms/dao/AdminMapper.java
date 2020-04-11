package net.gxu.bsms.dao;

import net.gxu.bsms.entity.Admin;

public interface AdminMapper {
    Admin getAdminByName(String name);
    int updatePwd(Admin admin);

}
