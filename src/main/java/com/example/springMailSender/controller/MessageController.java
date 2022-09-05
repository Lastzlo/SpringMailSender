package com.example.springMailSender.controller;

import com.example.springMailSender.model.Message;
import com.example.springMailSender.service.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/messages")
public class MessageController {

	private final MailService mailService;

	public MessageController(MailService mailService) {
		this.mailService = mailService;
	}

	@GetMapping("/create")
	public String create(Model model) {
		System.out.println("Hello Heroku");
		System.out.println("Hello Heroku");
		model.addAttribute("message", new Message());
		return "message-create";
	}

	@PostMapping("/create")
	public String send(@ModelAttribute("message") Message message, Model model) {
		//send message
		System.out.println("message = " + message);
		mailService.send(message);
		model.addAttribute("message", new Message());
		return "message-create";
	}
}
