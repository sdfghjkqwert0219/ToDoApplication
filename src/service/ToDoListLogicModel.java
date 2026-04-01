package service;

import java.io.File;
import java.util.ArrayList;

import model.ToDoListModel;


//ToDoリスト一覧取得
public class ToDoListLogicModel {

		

	//ToDoリストの取得
	public void getToDoList(ToDoListModel lm) {

		File dir = new File(lm.getFolder());
		String[] filesAll = dir.list();
		
		ArrayList<String> progressing = new  ArrayList<>();
		ArrayList<String> completed = new  ArrayList<>();
		
		
		// ディレクトリ存在チェック
		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("指定されたパスは存在しないか、ディレクトリではありません。");
			return;
		}
				
		for(String name:filesAll) {
			if (name.indexOf("【完了】") >= 0) {
				
				completed.add(name);
				
			} else if (name.indexOf("No.") == -1) {
				
				//最終ToDo番号として格納
				name = name.replace(".txt", "");
				lm.setLatestNo(Integer.parseInt(name));
				
				
			} else {
				progressing.add(name);
			}
			
		}
		
		
		// 一覧リストへ格納
		lm.setFileNames(progressing.toArray(new String[0]));
		lm.setOldFileNamess(completed.toArray(new String[0]));
	}
	
	
	
}
