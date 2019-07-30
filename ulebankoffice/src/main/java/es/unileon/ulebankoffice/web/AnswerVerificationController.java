package es.unileon.ulebankoffice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnswerVerificationController {
	@RequestMapping(value="/answerok")
	public String controllerVacio(){
		return "answer-verification";
	}
}
