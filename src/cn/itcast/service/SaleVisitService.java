package cn.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.SaleVisit;
import cn.itcast.utils.PageBean;

public interface SaleVisitService {
	//����ͻ��ݷü�¼
	void save(SaleVisit saleVisit);
	//�ͻ��ݷü�¼�ķ�ҳ�б�
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//����id��ÿͻ�����
	SaleVisit getById(String visit_id);

}
