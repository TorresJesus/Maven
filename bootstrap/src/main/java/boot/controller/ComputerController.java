package boot.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Computer;

import boot.service.ComputerService;


@Controller
public class ComputerController {

	@Autowired
	private ComputerService computerService;
	@GetMapping("computer")
	public String home(HttpServletRequest request){
		request.setAttribute("mode","MODE_HOME");
		return "computer";
	}
	//*Apartir de aqui nuevos metodos*/
	@GetMapping("/all-computers")
	public String allComputers(HttpServletRequest request){
		request.setAttribute("computers",computerService.findAll());
		request.setAttribute("mode","MODE_COMPUTERS");
		return "computer";
	}
	
	@GetMapping("/new-computer")
	public String newComputer(HttpServletRequest request){
		request.setAttribute("mode","MODE_NEW");
		return "computer";
	}
	@PostMapping("/save-computer")
	public String saveComputer(@ModelAttribute Computer computer,BindingResult bindingResult, HttpServletRequest request){
		computerService.save(computer);
		request.setAttribute("computers",computerService.findAll());
		request.setAttribute("mode","MODE_COMPUTERS");
		return "computer";
	}
	
	
	@GetMapping("/update-computer")
	public String updateComputer(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("computer",computerService.findcomputer(id));
		request.setAttribute("mode","MODE_UPDATE");
		return "computer";
	}
	@GetMapping("/delete-computer")
	public String deleteComputer(@RequestParam int id,HttpServletRequest request){
		computerService.delete(id);
		request.setAttribute("computers",computerService.findAll());
		request.setAttribute("mode","MODE_COMPUTERS");
		return "computer";
	}
}
