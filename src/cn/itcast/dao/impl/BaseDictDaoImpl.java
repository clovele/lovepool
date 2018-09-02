package cn.itcast.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.itcast.dao.BaseDictDao;
import cn.itcast.domain.BaseDict;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		//Criteria
		
		//获取离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		//执行add方法保存
		dc.add(Restrictions.eq("dict_type_code", dict_type_code));
		//查询结果封装为list对象
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
		
		return list;
	}}
