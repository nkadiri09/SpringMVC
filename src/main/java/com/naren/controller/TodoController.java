package com.naren.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.naren.dao.TodoDao;
import com.naren.model.Todo;
import com.naren.todo.service.TodoService;

@Controller
public class TodoController {

	/*
	 * @Autowired private TodoService service;
	 */

	TodoDao todoDao = new TodoDao();

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		model.addAttribute("todos", todoDao.retrieveTodos("in28Minutes"));
		return "list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodo(ModelMap model, @ModelAttribute("todo") Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}
		model.addAttribute("todo", new Todo(0, "in28Minutes", "Default desc", new Date(), false));
		return "todo";
	}

	@RequestMapping(value = "/add-todos", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @RequestParam String desc) {
		todoDao.addTodo("in28Minutes", desc, new Date(), false);
		// service.addTodo("in28Minutes", desc, new Date(), false);
		model.clear();
		return "redirect:list-todos";
	}

	/*
	 * @RequestMapping(value = "delete-todo", method = RequestMethod.GET) public
	 * String deleteTodo(ModelMap model, @RequestParam int id) {
	 * service.deleteTodo(id); model.clear(); return "redirect:list-todos"; }
	 */

}