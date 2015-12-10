package com.hanains.mysite.http.action.board;

import com.hanains.http.action.Action;
import com.hanains.http.action.ActionFactory;

public class BoardActionFactory extends ActionFactory{

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("list".equals(actionName)){
			action = new BoardListAction();
		}else if("modify".equals(actionName)){
			action = new ModifyAction();
		}else if("view".equals(actionName)){
			action = new ViewAction();
		}else if("write".equals(actionName)){
			action = new WriteAction();
		}else if("writeform".equals(actionName)){
			action = new BoardInsertFormAction(); 
		}
		return action;
	}

}
