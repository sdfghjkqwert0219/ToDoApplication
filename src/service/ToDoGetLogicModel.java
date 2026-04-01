package service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import model.ToDoListModel;
import model.ToDoModel;

//ToDo詳細取得
public class ToDoGetLogicModel {

	
	//ToDo詳細読み込み
	public void getTaskDetails(ToDoListModel lm,int previewNo) {
		
		// 読み込むファイルパス
		Path path = Paths.get(lm.getFolder() +"\\" + lm.getFileNames()[previewNo]);
		
		 // UTF-8で全行読み込み（List<String>として取得）
		try {
			lm.setLines(Files.readAllLines(path, StandardCharsets.UTF_8))  ;
        
        } catch (IOException e) {
            System.err.println("ファイル読み込みエラー: " + e.getMessage());
        }
    }
		
	
	//内容格納
	public void roadingDataStorage(ToDoModel m,ToDoListModel lm) {
				
		//ToDo番号
		m.setNo(Integer.parseInt(lm.getLines().get(0).replace("No.", "")));
		
		//タスク内容
		m.setTask(lm.getLines().get(1).replace("タスク：", ""));
		
		//ステータス
		m.setStatus(Boolean.parseBoolean(lm.getLines().get(2).replace("ステータス：", "")));
		
		//期日
		String date = lm.getLines().get(3).replace("期日：", "");
		
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(6, 7));
		int day = Integer.parseInt(date.substring(9, 10));
		
		m.setDay(LocalDate.of(year, month, day));
		
		//メモ
		m.setMemo(lm.getLines().get(4).replace("メモ：", ""));
		
		
	}
	
}
