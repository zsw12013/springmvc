package cn.bishiti.base.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bishiti.base.commons.page.Page;
import cn.bishiti.base.dao.UsersMapper;
import cn.bishiti.base.model.Users;
import cn.bishiti.base.model.UsersExample;
import cn.bishiti.base.service.TestService;
@Service
public class TestServiceImpl  implements TestService {
	 @Autowired
	private UsersMapper usersMapper;
	@Override
	public List<Users> selectPageByParam(Map<String, Object> map, Page page) {
		
		UsersExample usersExample =new UsersExample();
		 return usersMapper.selectByExample(usersExample);
	}
	
	@Override
	public int insert(Users users) {
 		return usersMapper.insert(users);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
 		return usersMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Users record) {
 		return usersMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Users record) {
		return usersMapper.updateByPrimaryKey(record);
	}
}
