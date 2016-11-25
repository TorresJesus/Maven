package boot.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Friend;
import boot.model.Task;
import boot.service.FriendService;
import boot.service.TaskService;

@Controller
public class FriendController {

	@Autowired
	private FriendService friendService;
	@GetMapping("friend")
	public String home(HttpServletRequest request){
		request.setAttribute("mode","MODE_HOME");
		return "friend";
	}
	//*Apartir de aqui nuevos metodos*/
	@GetMapping("/all-friends")
	public String allFriends(HttpServletRequest request){
		request.setAttribute("friends",friendService.findAll());
		request.setAttribute("mode","MODE_FRIENDS");
		return "friend";
	}
	
	@GetMapping("/new-friend")
	public String newFriend(HttpServletRequest request){
		request.setAttribute("mode","MODE_NEW");
		return "friend";
	}
	@PostMapping("/save-friend")
	public String saveFriend(@ModelAttribute Friend friend,BindingResult bindingResult, HttpServletRequest request){
		friendService.save(friend);
		request.setAttribute("friends",friendService.findAll());
		request.setAttribute("mode","MODE_FRIENDS");
		return "friend";
	}
	
	
	@GetMapping("/update-friend")
	public String updateFriend(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("friend",friendService.findFriend(id));
		request.setAttribute("mode","MODE_UPDATE");
		return "friend";
	}
	@GetMapping("/delete-friend")
	public String deleteFriend(@RequestParam int id,HttpServletRequest request){
		friendService.delete(id);
		request.setAttribute("friends",friendService.findAll());
		request.setAttribute("mode","MODE_FRIENDS");
		return "friend";
	}
}
