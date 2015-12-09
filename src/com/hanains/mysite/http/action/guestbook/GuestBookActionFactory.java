package com.hanains.mysite.http.action.guestbook;

import com.hanains.http.action.Action;
import com.hanains.http.action.ActionFactory;
import com.hanains.mysite.http.action.main.IndexAction;

public class GuestBookActionFactory extends ActionFactory{

	@Override
	public Action getAction(String actionName) {
		Action action =null;
		if("insert".equals(actionName)){
			action = new InsertAction();
		}else if("form".equals(actionName)){
			action = new FormAction();
		}else if("delete".equals(actionName)){
			action = new DeleteAction();
		}else if("list".equals(actionName)){
			action = new ListAction();
		}
		else{
			action = new IndexAction();
		}
		
		return action;
	}

}
