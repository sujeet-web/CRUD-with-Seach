package com.infotech.corejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.infotech.corejava.entity.Product;
import com.infotech.corejava.service.ProductService;

@Controller
public class MyController {
	
	@Autowired
	private ProductService service;
	
	//1.Here trying to search by name(iphone) but i have given hardcoded value same will have to change in ProductService class.
	/*@RequestMapping(value="/index",method = RequestMethod.GET)
	public String viewHomePage(Model model) {
		String keyword="iphone";
		List<Product> listProducts = service.listAll(keyword);
		model.addAttribute("listProducts", listProducts);
		return "index";
	}*/
	
	//2. Geeting all product from DB.
	/*@RequestMapping(value="/index",method = RequestMethod.GET)
	public String viewHomePage(Model model) {
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		return "index";
	}*/
	
	//3. Now we are passing the keyword from UI.
		@RequestMapping(value="/index",method = RequestMethod.GET)
		public String viewHomePage(Model model,@Param("keyword") String keyword) {
			List<Product> listProducts = service.listAll(keyword);
			model.addAttribute("listProducts", listProducts);
			//model.addAttribute("keyword", keyword);
			return "index";
		}
		
	
	/*@RequestMapping(value="/index",method = RequestMethod.GET)
	public String viewHomePage(Model model) {
		
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		//model.addAttribute("keyword", keyword);
		
		return "index";
	}*/

	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		
		return "redirect:/index";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		
		Product product = service.get(id);
		mav.addObject("product", product);
		
		return mav;
	}	
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		service.delete(id);
		
		return "redirect:/index";
	}

}
