package com.hanains.mysite.http.action.board;

import com.hanains.http.action.Action;
import com.hanains.http.action.ActionFactory;

public class BoardActionFactory extends ActionFactory{

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("list".equals(actionName)){
			action = new BoardListAction();
		}else if("search".equals(actionName)){
			action = new SearchAction();
		}else if("update".equals(actionName)){
			action = new UpdateAction();
		}else if("updateform".equals(actionName)){
			action = new BoardUpdateFormAction();
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
