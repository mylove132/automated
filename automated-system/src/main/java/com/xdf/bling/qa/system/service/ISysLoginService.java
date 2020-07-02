package com.xdf.bling.qa.system.service;

import com.xdf.bling.qa.system.domain.SysUser;

public interface ISysLoginService {

    SysUser login(String username, String password);

    void recordLoginInfo(SysUser sysUser);
}
