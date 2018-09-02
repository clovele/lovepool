package cn.itcast.web.action;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.PageBean;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private Customer customer = new Customer();
	
	private CustomerService cs;
	
	private File photo;

	private String photoFileName;

	private String photoContentType;
	
	private Integer currentPage;
	private Integer pageSize;
	public String list() throws Exception {
	
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		
		if(StringUtils.isNotBlank(customer.getCust_name())){
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		
		
		PageBean pb = cs.getPageBean(dc,currentPage,pageSize);
		
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	

	public String add() throws Exception {
		if(photo!=null){
		System.out.println(":"+photoFileName);
		System.out.println(":"+photoContentType);
	
		photo.renameTo(new File("E:/upload/haha.jpg"));
		}
		
		//---------------------------------------------------------------------
		cs.save(customer);
		
		return "toList";
	}

	public String toEdit() throws Exception {
		
		//1.调用service根据id获得客户对象
		Customer c = cs.getById(customer.getCust_id());
		//2.将客户对象放置到request域,并转发到编辑页面
		//System.out.println("111");
		ActionContext.getContext().put("customer", c);
		//System.out.println("222");
		return "edit";
	}


	@Override
	public Customer getModel() {
		return customer;
	}

	public void setCs(CustomerService cs) {
		this.cs = cs;
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



	public File getPhoto() {
		return photo;
	}



	public void setPhoto(File photo) {
		this.photo = photo;
	}



	public String getPhotoContentType() {
		return photoContentType;
	}



	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}



	public String getPhotoFileName() {
		return photoFileName;
	}



	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	
	
}
