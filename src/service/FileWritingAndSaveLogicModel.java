package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import control.AskYesOrNoControl;
import model.ToDoListModel;
import model.ToDoModel;
import view.messageView;

//ファイル書き込みと保存（上書き含む）
public class FileWritingAndSaveLogicModel {

	messageView msgView = new messageView();
	AskYesOrNoControl ynControl = new AskYesOrNoControl();
	
	//書き込みと保存・上書き
	public String makeTodoFile(ToDoModel m ,ToDoListModel lm ) {
		
		//保存ファイルのパス
		String saveFileName;
		saveFileName = lm.getFolder() + "\\No." + m.getNo() + " " + m.getTask() + ".txt";

		
		//書き込み用テキストの用意
		lm.setWritingText( "No." + m.getNo() + "\n" +
				"タスク：" + m.getTask() + "\n"	+ 
				"ステータス：" + m.isStatus() + "\n" + 
				"期日：" + m.getDay() + "\n" +
				"メモ：" + m.getMemo());
		
		System.out.println("\n↓この内容で保存します↓\n" + lm.getWritingText() + "\n");

		
		//保存してOKか確認
		String lastAns = ynControl.askFinalAnswer();
		
		if(lastAns.equals("y")) {
		
			//ファイル書き込みと保存・上書き
			try (FileWriter fw = new FileWriter(saveFileName);) {
			
				//Write	
				fw.write(lm.getWritingText());
			
			} catch (IOException e) {
				
				msgView.errorMsg(); //Msg表示「処理エラーが発生しました。」
				return "エラー";
			}
		} else {
			
			System.out.println("保存を中止しました");
			return "キャンセル";
		}
		
		//ステータス完了の場合はファイル名を変更
		if(m.isStatus()) {
			
			renameFile(saveFileName, m, lm);
		}
		
		return "保存完了";
	}
	
	
	// ファイル名の変更
	public void renameFile(String oldFilename ,ToDoModel m ,ToDoListModel lm ) {
	
		// 変更前のファイル
		File oldFile = new File(oldFilename);
		
		// 変更後のファイル
		File newFile;
		
		if (oldFilename.indexOf("No.") == -1) {
		
			//最終ToDo番号保存用のファイル
			newFile = new File(lm.getFolder() + "\\" +  m.getNo() + ".txt");
		
		} else {
			
			// ToDoファイル名に【完了】を追加
			newFile = new File(lm.getFolder() + "\\【完了】No." + m.getNo() + " " + m.getTask() + ".txt");
		}
		
		// ファイル名の変更
		oldFile.renameTo(newFile);
		}
	
	
	//最終ToDo番号を更新して保存
	public void numUpdate(ToDoModel m ,ToDoListModel lm ) {
		
		String oldFilename =lm.getFolder() + "\\" + lm.getLatestNo() + ".txt";
		
		// ファイル名の変更
		renameFile(oldFilename, m, lm);
		
		//最終ToDo番号の更新
		lm.	setLatestNo(m.getNo());
		
	}
	
	
}
