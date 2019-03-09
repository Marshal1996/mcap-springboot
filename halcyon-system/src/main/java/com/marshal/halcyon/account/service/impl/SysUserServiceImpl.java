package com.marshal.halcyon.account.service.impl;

import com.github.pagehelper.PageHelper;
import com.marshal.halcyon.account.entity.SysUser;
import com.marshal.halcyon.account.mapper.SysUserMapper;
import com.marshal.halcyon.account.service.SysUserService;
import com.marshal.halcyon.core.service.BaseService;
import com.marshal.halcyon.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * author: Marshal
 * Date: 2018/10/26
 * Time: 20:10
 * Description:
 */
@Service
@Transactional
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public List<Map> getUserOptions() {
        return sysUserMapper.getUserOptions();
    }
}
