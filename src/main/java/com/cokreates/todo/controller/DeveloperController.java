package com.cokreates.todo.controller;

import antlr.ASTNULLType;
import com.cokreates.todo.model.Developer;
import com.cokreates.todo.model.Skill;
import com.cokreates.todo.repository.DeveloperRepository;
import com.cokreates.todo.repository.SkillRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Controller
public class DeveloperController {

	@Autowired
	DeveloperRepository repository;

	@Autowired
	SkillRepository skillRepository;

	@RequestMapping(value = "/developer/{id}", method = RequestMethod.GET)
	public String developer(@PathVariable Long id, Model model) {
		Optional<Developer> developer = repository.findById(id);
		model.addAttribute("developer", developer.get());
		model.addAttribute("skills", skillRepository.findAll());
		return "developer";
	}

	@RequestMapping(value = "/developers", method = RequestMethod.GET)
	public String developersList(Model model) {
		model.addAttribute("developers", repository.findAll());
		model.addAttribute("skills",skillRepository.findAll());
		return "developers";
	}

	@RequestMapping(value = "/developer/{id}/skills", method = RequestMethod.POST)
	public String addSkills(@PathVariable Long id, @RequestParam Long skillId, Model model){
		Optional<Developer> developer = repository.findById(id);
		Optional<Skill> skill = skillRepository.findById(skillId);

		if(developer.isPresent()){
			if(!developer.get().hasSkill(skill.get())){
				developer.get().getSkillList().add(skill.get());
				repository.save(developer.get());
			}
			model.addAttribute("developer", repository.findById(id).get());
			model.addAttribute("skills", skillRepository.findAll());
			return "redirect:/developer/" + developer.get().getId();
		}

		return "redirect:/developers";

	}




}
