package control;

import java.util.InputMismatchException;

import model.ToDoListModel;
import service.ToDoListLogicModel;
import service.ToDoLogicModel;
import view.ListView;
import view.TopView;

public class Main {

	public static void main(String[] args) {

		AskDoControl doControl = new AskDoControl();
		ToDoListModel lm = new ToDoListModel();
		ToDoListLogicModel listLogic = new ToDoListLogicModel();
		ToDoLogicModel logicModel = new ToDoLogicModel();
		ListView listView = new ListView();
		TopView topView = new TopView();
		
		int opeNo;	//指定操作番号
		
		System.out.println("ようこそ");

		do {

			try {
			topView.home(lm, listLogic, listView);	
			opeNo = doControl.askOperation(lm, logicModel,listLogic, listView);

			} catch (InputMismatchException e) {
				System.out.println("入力規則に違反しました。もう一度入力して下さい");
				opeNo = doControl.askOperation(lm, logicModel, listLogic, listView);

			}
	
		} while(!(opeNo ==5));
	
		System.out.println("またね");
		
	}

}

