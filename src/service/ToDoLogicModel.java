package service;

import java.io.File;

import control.AskDoControl;
import control.AskYesOrNoControl;
import model.ToDoListModel;
import model.ToDoModel;
import view.MessageView;
import view.SingleView;

public class ToDoLogicModel {
	

	AskYesOrNoControl ynControl = new AskYesOrNoControl();
	
	SingleView singleView = new SingleView();
	MessageView msgView = new MessageView();
	UsersAnswerLogic userans = new UsersAnswerLogic();
	
	//詳細表示
	public void todoView(int targetNo ,ToDoListModel lm) {

		ToDoGetLogicModel getLogic = new ToDoGetLogicModel();
		
		//対象のToDoの指定
		int previewNo = targetNo;
		
		//対象ToDoの詳細読み込み
		getLogic.getTaskDetails(lm,previewNo);
		
		//表示
		singleView.todoPreview(lm);
	}

	
	//追加
	public void todoAdd(ToDoListModel lm) {
		
		ToDoInputLogicModel inputLogic = new ToDoInputLogicModel();
		FileWritingAndSaveLogicModel fileSaveLogic = new FileWritingAndSaveLogicModel();
		ToDoModel m = new ToDoModel(); 
		
		//内容入力
		inputLogic.inputNo(m,lm);//自動で採番
		inputLogic.inputTask(m);
		inputLogic.inputDay(m);
		inputLogic.inputMemo(m);
		
		//ファイルに書き込んで保存
		
		if(fileSaveLogic.makeTodoFile(m, lm).equals("保存完了")) {
		
		//最終ToDo番号と番号記録用のファイル名を更新
		fileSaveLogic.numUpdate(m, lm);

		//完了報告「登録完了しました」
		msgView.addCmpMsg();
		
		}
		
	}

	//更新・編集
	public void todoUpdate(int targetNo ,ToDoListModel lm) {
		
		ToDoModel m = new ToDoModel(); 
		ToDoGetLogicModel getLogic = new ToDoGetLogicModel();
		ToDoInputLogicModel inputLogic = new ToDoInputLogicModel();
		ForWritingLogicModel writingLogic = new ForWritingLogicModel();
		FileWritingAndSaveLogicModel fileSaveLogic = new FileWritingAndSaveLogicModel();
		AskDoControl doControl = new AskDoControl();
		
		int target = targetNo;

		//対象ToDoの詳細表示
		todoView(target ,lm);
		
		//内容を格納
		getLogic.roadingDataStorage(m,lm);
		
		//編集項目の選択・入力
		String editContents = doControl.askEditContents();
		writingLogic.writeSelectContents(editContents, m ,inputLogic);
		
		if(!(editContents.equals("5"))) {	//キャンセル以外の処理
			
			if(editContents.indexOf("1")>=0) {//タスク内容変更が含まれていれば元ファイル削除
			
				//元ファイル削除
				File file = new File(lm.getFolder() + "\\" + lm.getFileNames()[target]);
				//削除結果を判定
				if (file.delete()) {
				
				} else {
					System.out.println("元ファイルを削除出来ませんでした");
				}
			}
				
			//ファイルに書き込んで保存
			if(fileSaveLogic.makeTodoFile(m, lm).equals("保存完了")) {
				
				//完了報告「変更完了しました」
				msgView.chngCmpMsg();
			}
				
		} else {	//キャンセルの場合はなにもしないで終了
			
			return;
			
		}
			
	}

	
	//状態更新（ステータス完了）
	public void updateStatusOnly(int targetNo ,ToDoListModel lm ) {

		ToDoModel m = new ToDoModel(); 	
		ToDoGetLogicModel getLogic = new ToDoGetLogicModel();
		ToDoInputLogicModel inputLogic = new ToDoInputLogicModel();
		FileWritingAndSaveLogicModel fileSaveLogic = new FileWritingAndSaveLogicModel();
			
		//対象のToDo選択
		int target = targetNo;
		
		//対象ToDoの詳細表示
		todoView(target ,lm);
	
		//内容を格納
		getLogic.roadingDataStorage(m,lm);
		
		//ステータスの編集
		inputLogic.inputStatus(m);

		//ファイルに書き込んで上書き保存
		if(fileSaveLogic.makeTodoFile(m, lm).equals("保存完了")) {
	
			
			//完了報告「お疲れ様でした」
			msgView.stsCmpMsg();
		}
	}

	
	//削除
	public void todoDel(int targetNo ,ToDoListModel lm) {

		//対象のToDo選択
		int deleteNo = targetNo;
				
		//本当に削除するか聞く
		System.out.println( (deleteNo + 1) + "を削除します。");
		String lastAns = ynControl.askFinalAnswer();
		
		if(lastAns.equals("y")) {
	
			//ファイル削除
			File file = new File(lm.getFolder() + "\\" + lm.getFileNames()[deleteNo]);
			
			//結果報告
			if (file.delete()) {
				msgView.delCmpMsg();//「削除完了しました」
			} else {
				System.out.println("ファイル削除失敗しました");
			}
		} else {
			
			System.out.println("削除を中止しました");
		}
			
	}

}
