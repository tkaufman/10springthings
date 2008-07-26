package org.cinjug.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BeerController {
	
	@Autowired
	private BeerService brewSvc;

	@RequestMapping("/beer.do")
	protected ModelAndView getBeerSuggestion() throws Exception {

		ModelAndView mav = new ModelAndView("beer");
		mav.addObject("beer", brewSvc.suggestBeer());

		return mav;
	}

}
