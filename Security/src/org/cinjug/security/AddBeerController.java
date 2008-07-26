package org.cinjug.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/addBeer.do")
public class AddBeerController {

	@Autowired
	private BeerService brewSvc;

	@RequestMapping(method = RequestMethod.GET)
	public  String setupForm(Model model) {
		model.addAttribute("beer", new Beer());
		return "addBeer";
	}


	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("beer") Beer beer, BindingResult result, SessionStatus status) {

		brewSvc.stockFridge(beer);
		return "redirect:beer.do";
	}
}
