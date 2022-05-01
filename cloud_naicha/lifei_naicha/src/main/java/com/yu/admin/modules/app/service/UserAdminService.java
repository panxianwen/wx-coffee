package com.yu.admin.modules.app.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yu.admin.modules.app.mapper.UserAdminMapper;
import com.yu.admin.modules.app.pojo.UserAdmin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserAdminService {

    @Resource
    private UserAdminMapper userAdminMapper;

    /**
     * 查询所有
     */
    public List<UserAdmin> getAllUserAdmins() {
        return userAdminMapper.selectList(null);
    }

    /**
     * 分页条件查询
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return Page<UserAdmin>
     */
    public Page<UserAdmin> getUserAdminByPage(int pageNo, int pageSize) {
        Page<UserAdmin> page = new Page<>(pageNo, pageSize);
        return userAdminMapper.selectPage(page, null);
    }

    // 增加
    @Transactional
    public int addUserAdmin(UserAdmin userAdmin) {
        return userAdminMapper.insert(userAdmin);
    }

    // 批量删除
    @Transactional
    public int deleteUserAdminBatchIds(List<Integer> userAdminIdList) {
        return userAdminMapper.deleteBatchIds(userAdminIdList);
    }

    // 修改
    @Transactional
    public int updateUserAdmin(UserAdmin userAdmin) {
        return userAdminMapper.updateById(userAdmin);
    }
}
