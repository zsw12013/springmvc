package cn.bishiti.base.service;

import java.util.List;
import java.util.Map;

import cn.bishiti.base.commons.page.Page;
import cn.bishiti.base.model.TUser;
import cn.bishiti.base.model.Users;

public interface TestService {
	List<Users> selectPageByParam(Map<String,Object> map,Page page);
	 int insert(Users users);
	 int deleteByPrimaryKey(Integer id);
	 int updateByPrimaryKeySelective(Users record);
	 int updateByPrimaryKey(Users record);
}
