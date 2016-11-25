package boot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.HarvestRaw;
import boot.service.HarvestRawService;

@Controller
public class HarvestRawController {

	@Autowired
	private HarvestRawService harvestRawService;
	@GetMapping("harvest-raw")
	public String home(HttpServletRequest request){
		request.setAttribute("mode","MODE_HOME");
		return "harvest_raw";
	}
	//*Apartir de aqui nuevos metodos*/
	@GetMapping("/all-harvest-raws")
	public String allHarvestRaws(HttpServletRequest request){
		request.setAttribute("harvestRaws",harvestRawService.findAll());
		request.setAttribute("mode","MODE_HARVEST_RAWS");
		return "harvest_raw";
	}
	
	@GetMapping("/new-harvest-raw")
	public String newHarvestRaw(HttpServletRequest request){
		request.setAttribute("mode","MODE_NEW");
		return "harvest_raw";
	}
	@PostMapping("/save-harvest-raw")
	public String saveHarvestRaw(@ModelAttribute HarvestRaw harvestRaw,BindingResult bindingResult, HttpServletRequest request){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date sampleDate = new Date();
		try{
			sampleDate  = format.parse(request.getParameter("sampleDate"));
		}catch (ParseException e){
			e.printStackTrace();
		}
		harvestRaw.setSampleDate(sampleDate);
		
		harvestRawService.save(harvestRaw);
		request.setAttribute("harvestRaws",harvestRawService.findAll());
		request.setAttribute("mode","MODE_HARVEST_RAWS");
		return "harvest_raw";
	}
	
	
	@GetMapping("/update-harvest-raw")
	public String updateHarvestRaw(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("harvestRaw",harvestRawService.findHarvestRaw(id));
		request.setAttribute("mode","MODE_UPDATE");
		return "harvest_raw";
	}
	@GetMapping("/delete-harvest-raw")
	public String deleteHarvestRaw(@RequestParam int id,HttpServletRequest request){
		harvestRawService.delete(id);
		request.setAttribute("harvestRaws",harvestRawService.findAll());
		request.setAttribute("mode","MODE_HARVEST_RAWS");
		return "harvest_raw";
	}
	
}
