package service;

import java.time.LocalDate;

import model.ToDoListModel;
import model.ToDoModel;

//ToDo情報入力
public class ToDoInputLogicModel {

	UsersAnswerLogic userans = new UsersAnswerLogic();
	
	//ToDo番号採番
	public void inputNo(ToDoModel m ,ToDoListModel lm) {
		m.setNo(lm.getLatestNo() + 1);	
	}

	
	//タスク内容
	public void inputTask(ToDoModel m) {
		m.setTask(userans.answerStr("タスクを入力"));
	}

	
	//状態
	public void inputStatus(ToDoModel m) {
		
		if(!(m.isStatus())) {
			System.out.println("ステータスを完了にします");
			m.setStatus(true);
		}
		
		
	}

	
	//期日
	public void inputDay(ToDoModel m) {
		String d = userans.answerStr("期日を入力（yyyymmdd）");

		int year = Integer.parseInt(d.substring(0, 4));
		int month = Integer.parseInt(d.substring(4, 6));
		int day = Integer.parseInt(d.substring(6, 8));
		m.setDay(LocalDate.of(year, month, day));
	}


	//メモ
	public void inputMemo(ToDoModel m) {
		m.setMemo(userans.answerStr("メモを入力"));
	}

}
