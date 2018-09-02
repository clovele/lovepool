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
		
		//��ȡ���߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		//ִ��add��������
		dc.add(Restrictions.eq("dict_type_code", dict_type_code));
		//��ѯ�����װΪlist����
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
		
		return list;
	}}
