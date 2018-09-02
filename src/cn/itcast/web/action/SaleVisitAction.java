package cn.itcast.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Customer;
import cn.itcast.domain.SaleVisit;
import cn.itcast.domain.User;
import cn.itcast.service.SaleVisitService;
import cn.itcast.utils.PageBean;

public class SaleVisitAction  extends ActionSupport implements ModelDriven<SaleVisit>{
	private SaleVisit saleVisit = new SaleVisit();
	
	private SaleVisitService svs ;
	
	//��ӿͻ��ݷü�¼
	public String add() throws Exception {
		//0 ȡ����½�û�,����SaleVisitʵ��.����ϵ
			User u = (User) ActionContext.getContext().getSession().get("user");
			saleVisit.setUser(u);
		//1 ����Service����ͻ��ݷü�¼
			svs.save(saleVisit);
		//2 �ض��򵽰ݷü�¼�б�Action
		return "toList";
	}
	private Integer currentPage;
	private Integer pageSize;
	public String list() throws Exception {
		//��װ���߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		//�жϲ���װ����
		if(saleVisit.getCustomer()!=null &&saleVisit.getCustomer().getCust_id()!=null){
			dc.add(Restrictions.eq("customer.cust_id",saleVisit.getCustomer().getCust_id()));
		}
		
		//1 ����Service��ѯ��ҳ����(PageBean)
		PageBean pb = svs.getPageBean(dc,currentPage,pageSize);
		//2 ��PageBean����request��,ת�����б�ҳ����ʾ
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}


	//ȥ���༭ҳ�����
	public String toEdit() throws Exception {
			//1 ����Service����id��ѯ�ͻ��ݷö���
			SaleVisit sv = svs.getById(saleVisit.getVisit_id());
			//2 ���������request��
			ActionContext.getContext().put("saleVisit", sv);
			//3 ת����add.jsp
			return "add";
	}







	@Override
	public SaleVisit getModel() {
		return saleVisit;
	}

	public void setSvs(SaleVisitService svs) {
		this.svs = svs;
	}



	public Integer getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}



	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
