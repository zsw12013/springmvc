package cn.bishiti.base.service;

import java.util.List;
import java.util.Map;

import cn.bishiti.base.commons.page.Page;
import cn.bishiti.base.model.TUser;

public interface TestService {
	List<TUser> selectPageByParam(Map<String,Object> map,Page page);

}
