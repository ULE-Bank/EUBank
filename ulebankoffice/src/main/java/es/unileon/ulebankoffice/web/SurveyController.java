package es.unileon.ulebankoffice.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.unileon.ulebankoffice.domain.AdvisorUser;
import es.unileon.ulebankoffice.domain.Answer;
import es.unileon.ulebankoffice.domain.Answers;
import es.unileon.ulebankoffice.domain.Client;
import es.unileon.ulebankoffice.domain.Compound;
import es.unileon.ulebankoffice.domain.FinancialAdvisorRequest;
import es.unileon.ulebankoffice.domain.Option;
import es.unileon.ulebankoffice.domain.OptionHandler;
import es.unileon.ulebankoffice.domain.Question;
import es.unileon.ulebankoffice.domain.QuestionStore;
import es.unileon.ulebankoffice.domain.Simple;
import es.unileon.ulebankoffice.domain.Test;
import es.unileon.ulebankoffice.repository.AdvisorUserRepository;
import es.unileon.ulebankoffice.repository.ClientRepository;
import es.unileon.ulebankoffice.repository.FinancialAdvisorRequestsRepository;
import es.unileon.ulebankoffice.repository.QuestionStoreRepository;
import es.unileon.ulebankoffice.repository.TestRepository;

@Controller
@RequestMapping("/offersconsulting/survey")
public class SurveyController {
	private static final Logger logger = Logger.getLogger("ulebankLogger");
	private static final String VIEW = "survey";

	@Autowired
	private FinancialAdvisorRequestsRepository repo;
	
	@Autowired
	TestRepository testRepository;
	
	@Autowired
	QuestionStoreRepository qSRepository;
	
	@GetMapping
	public String get(ModelMap model, HttpServletRequest req,Principal principal, HttpServletResponse resp, @RequestParam(value = "id") String id) {		
		Test.populateSingleton(testRepository);
		model.addAttribute("listQuestions", Test.getInstance().getQuestions());
		model.addAttribute("id", id);
		return VIEW;
	}

	@PostMapping
	public String survey(ModelMap model, Principal principal, HttpServletRequest req, HttpServletResponse resp, @RequestParam(value = "id") String id) {
		Test.populateSingleton(testRepository);
		QuestionStore.populateSingleton(qSRepository);
		Answers answers = new Answers();
		Test test = Test.getInstance();
		testRepository.save(test);
		
		List<Question> testQuestions = test.getQuestions();
		
		for (Question question : testQuestions) {
			String answerId = req.getParameter("select-q" + question.getId().toString());
			
			if(answerId.equals("empty")) {
				model.addAttribute("listQuestions", Test.getInstance().getQuestions());
				model.addAttribute("emptyQuestions", true);
				return VIEW;
			}

			Option option = question.search(new OptionHandler(Long.parseLong(answerId)));
			if (option != null) {
				if (option.getOptions().size() > 0) {
					String subAnswerId = req.getParameter("select-q" + question.getId().toString()+"-a"+option.getHandler().toString());

					if(subAnswerId.equals("empty")) {
						model.addAttribute("listQuestions", Test.getInstance().getQuestions());
						model.addAttribute("emptyQuestions", true);
						return VIEW;
					
					}
					Compound compoundOption = (Compound) option;
					option = compoundOption.search(new OptionHandler(Long.parseLong(subAnswerId)));
				}

				try {
					answers.add(new Answer(question.getHandler(), option.getHandler()));
				} catch (Exception e) {
					logger.error("Option " + option.toString() +" doesn't match with any options from question " + question.toString());
					return VIEW;					
				}
			}
		}
		
		FinancialAdvisorRequest request = repo.findById(id);
		request.setTestAnswers(answers);
		request.setTestAnswered(true);
		request.generateInvestorProfile();
		repo.save(request);
		
        return "redirect:/offersconsulting";
    }
}
