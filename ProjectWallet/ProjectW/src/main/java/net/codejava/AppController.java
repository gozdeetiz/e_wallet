package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@Autowired
    private PService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Project> listPr=service.listAll();
		model.addAttribute("listPr", listPr);
		
		return "index";
		
	}
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Project project=new Project();
		model.addAttribute("project",project);
		
		return "new_p";
		
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("project") Project project) {
	    service.save(project);
	     
	    return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_pr");
	    Project project = service.get(id);
	    mav.addObject("project", project);
	     
	    return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return "redirect:/";       
	}

}
