package net.codejava.customer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService service;
    
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("index");
		List<Customer> listCustomer = service.listAll();
		mav.addObject("listCustomer", listCustomer);
		return mav;
	}
	
	@RequestMapping("/new")
	public String newCustomerForm(Map<String, Object> model) {
		model.put("customer", new Customer());
		return "new_customer";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		service.saveCustomer(customer);
		return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editCustomerForm(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("edit_customer");
		Customer customer = service.get(id);
		mav.addObject("customer", customer);
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteCustomerForm(@RequestParam("id") Long id) {
		service.deleteCustomer(id);
		return "redirect:/";
	}
	
	@RequestMapping("/search")
	public ModelAndView searchCustomer(@RequestParam("keyword") String keyword) {
		ModelAndView mav = new ModelAndView("search");
		List<Customer> customer = service.search(keyword);
		mav.addObject("result", customer);
		
		return mav;
	}
	
}
