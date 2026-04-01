package view;

import model.ToDoListModel;

public class ListView {

	//ToDo一覧表示
	public void todoListDisplay(ToDoListModel lm ) {

		
		System.out.println("=== 現在のToDoリスト ===");

		// 登録有無チェック
		if (lm.getFileNames() == null || lm.getFileNames().length == 0) {
			System.out.println("Todoは登録されていません");
			return;
		
		} else {
				
		int displayNo = 0; //表示番号

			//リスト表示
			for (String name : lm.getFileNames()) {
				name = name.replace(".txt", "");
				displayNo += 1;
				System.out.println(displayNo + "  |" + name);
			}
		}
		System.out.println("");

	}

}
