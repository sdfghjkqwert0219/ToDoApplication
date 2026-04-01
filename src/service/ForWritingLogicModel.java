package service;

import model.ToDoModel;

//書き込み準備
public class ForWritingLogicModel {
	
	//編集項目の選択～編集内容入力
	public void writeSelectContents(String editContents ,ToDoModel m ,ToDoInputLogicModel inputModel) {
	
		
		//編集項目の選択
		String contents = editContents;
		
		//選択した数字の中に「5：キャンセル」があった場合はキャンセル処理のみに書き換える
		if(!(contents.indexOf("5") == -1)) {
			contents = "5";
		}
		
		for(int i = 0 ; i < contents.length() ; i++ ) {
			
			switch (contents.charAt(i)) {
			
				case '1' -> {	//タスク内容
					inputModel.inputTask(m);
				}
				
				case '2' -> { //ステータス
					inputModel.inputStatus(m);
				}
				
				case '3' -> {	//期日
					inputModel.inputDay(m);
				}
				
				case '4' -> {	//メモ
					inputModel.inputMemo(m);
				}
				
				case '5' -> {
					System.out.println("終了します");
				}
				
			}
		}
		
	}
	
	
	
}
