package org.cinjug.scheduling;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleReminderService implements ReminderService {

	List<String> todos;
	Log log = LogFactory.getLog(getClass());
	
	public List<String> getTodos() {
		return todos;
	}

	public void setTodos(List<String> todos) {
		this.todos = todos;
	}

	public void outputThingsToDo() {
		for (String todo : getTodos())
		{
			log.info(todo);
		}
	}

}
