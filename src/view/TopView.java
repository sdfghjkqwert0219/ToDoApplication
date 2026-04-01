package view;

import model.ToDoListModel;
import service.ToDoListLogicModel;

public class TopView {
	
	
	public void home(ToDoListModel lm ,ToDoListLogicModel listLogic ,ListView listView ) {
	
	//リスト取得
	listLogic.getToDoList(lm);
		
	//リスト表示
	listView.todoListDisplay(lm);
	
	//件数表示
	System.out.println("件数：" + lm.getFileNames().length + "件");
	
	System.out.println("");
	
	}

}
