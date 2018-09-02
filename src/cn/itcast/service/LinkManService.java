package cn.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.LinkMan;
import cn.itcast.utils.PageBean;

public interface LinkManService {
	//保存联系人
	void save(LinkMan linkMan);
	//鑱旂郴浜哄垪琛�
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//鏍规嵁id鑾峰緱LinkMan瀵硅薄
	LinkMan getById(Long lkm_id);

}
