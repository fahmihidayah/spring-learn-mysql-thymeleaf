package com.widsons.sprone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.widsons.sprone.domain.ClassRoom;
import com.widsons.sprone.service.ClassRoomService;

@Controller
@RequestMapping("/class_room")
public class ClassRoomController {

	@Autowired
	ClassRoomService classRoomService;
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("classRoom", new ClassRoom());
		return "class_room_form";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String save(@ModelAttribute ClassRoom classRoom){
		classRoomService.save(classRoom);
		return "redirect:/class_room/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("classRooms", classRoomService.findAll());
		return "class_room_list";
	}
}
