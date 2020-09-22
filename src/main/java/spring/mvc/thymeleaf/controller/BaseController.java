package spring.mvc.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.thymeleaf.entities.Employee;

@Controller
public class BaseController {

	@RequestMapping(value = { "/", "/addEmployee" }, method = RequestMethod.GET)
	public String addEmployee(@ModelAttribute(value = "employee") Employee employee, Model model) {
		List<String> listFavorite = new ArrayList<String>();
		listFavorite.add("Swimming");
		listFavorite.add("Listening Music");
		listFavorite.add("Walking");
		listFavorite.add("Watching movie");
		listFavorite.add("Reading Comic");
		List<String> listPosition = new ArrayList<String>();
		listPosition.add("Developer");
		listPosition.add("Designes");
		listPosition.add("Tester");
		listPosition.add("QA");

		model.addAttribute("listFavorite", listFavorite);
		model.addAttribute("listPosition", listPosition);
		return "add-employee";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView doAddEmployee(@ModelAttribute(value = "employee") Employee employee) {
		return new ModelAndView("view-employee", "employee", employee);
	}
}
