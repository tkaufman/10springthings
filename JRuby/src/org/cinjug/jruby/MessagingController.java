package org.cinjug.jruby;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class MessagingController extends AbstractController {

	@Autowired
	private MessageService msgService;
	
	public MessageService getMsgService() {
		return msgService;
	}
	public void setMsgService(MessageService msgService) {
		this.msgService = msgService;
	}


	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {

		ModelAndView mav = new ModelAndView("message");
		mav.addObject("msg", getMsgService().getMessage());
		mav.addObject("now", new Date().toString());

		return mav;
	}

}
