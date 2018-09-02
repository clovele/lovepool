package cn.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;
import cn.itcast.utils.PageBean;

public interface CustomerService {
	//鍒嗛〉涓氬姟鏂规硶
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//保存对象
	void save(Customer customer);
	//根据id返回customer对象
	Customer getById(Long cust_id);

}
