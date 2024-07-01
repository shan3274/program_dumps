package com.accenture.lkm.service;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accenture.lkm.business.bean.CustomerBean;
import com.accenture.lkm.business.bean.CustomerTypeBean;
import com.accenture.lkm.dao.CustomerDAOWrapper;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAOWrapper customerDAOWrapper;

	@Override
	public List<CustomerBean> getCustomerDetails(Date startDate, Date endDate) throws Exception{

		List<CustomerBean> beanList =
				customerDAOWrapper.getCustomerDetails(startDate, endDate);
		if(beanList==null || beanList.isEmpty()) {
			System.out.println("No data found");
			throw new RuntimeException("No Customer found within given date range");
		}
		else {
			return beanList;
		}
	}
	@Override
	public Integer addCustomer(CustomerBean customerBean) throws Exception{
		CustomerTypeBean customerTypeBean = new CustomerTypeBean();
		customerTypeBean = customerDAOWrapper.getCustomerTypeDetails(customerBean.getCustomerType());
		double maxBill = customerTypeBean.getMaximumBill();
		double minBill = customerTypeBean.getMinimumBill();

		if(customerBean.getBill()>=minBill &&
			customerBean.getBill()<=maxBill) {
			return customerDAOWrapper.addCustomer(customerBean);
		}
		else {
			throw new RuntimeException("Bill is not in the given range");
		}
	}
	@Override
	public Map<String, String> getCustomerTypes() throws Exception {
		List<String> customerTypesList =
		customerDAOWrapper.getCustomerTypes();
		Map<String, String> map = new HashMap<String, String>();

		for(String type : customerTypesList) {

			switch(type) {
			case "P" : map.put(type, "Platinum");
			break;
			case "G" : map.put(type, "Gold");
			break;
			case "S" : map.put(type, "Silver");
			break;

			}

		}

		return map;

	}

}