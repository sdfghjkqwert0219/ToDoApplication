package model;

import java.time.LocalDate;

//ToDoデータ
public class ToDoModel {

	private int no;			//ToDo番号
	private String task;	//タスク
	private LocalDate day;	//期日
	private boolean status;//状態
	private String memo;	//メモ


	
	
	//ToDo番号ゲッター・セッター
	public int getNo() {
		return this.no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
		
	//タスクゲッター・セッター	
	public String getTask() {
		return this.task;
	}
	
	public void setTask(String task) {
		this.task = task;		
	}

	
	//期日ゲッター・セッター	
	public LocalDate getDay() {
		return this.day;
	}

	public void setDay(LocalDate day) {
		this.day = day;		
	}

	//状態ゲッター・セッター
	public Boolean isStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;		
	}

	
	//メモゲッター・セッター
	public String getMemo() {
		return this.memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;		
	}
	
	

	
	
	
}
