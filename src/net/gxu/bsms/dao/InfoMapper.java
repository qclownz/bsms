package net.gxu.bsms.dao;

import net.gxu.bsms.entity.AllInfo;
import net.gxu.bsms.entity.NowInfo;

public interface InfoMapper {

    AllInfo getAllInfo();
    NowInfo getNowInfo();
}
