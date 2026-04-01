package model;

import java.util.List;

public class ToDoListModel {

	private String folder = "C:\\Users\\pm\\Documents\\workspace\\ToDo\\Todo";
	//private String folder = "C:\\Users\\User\\Documents\\職業訓練\\水曜\\Todo"; // 対象ディレクトリのパス
	private String[] fileNames;	//ToDo一覧リスト
	private String[] oldFileNames;	//ToDo一覧リスト(完了分)
	private int latestNo;			//最終ToDo番号
	private List<String> lines;	//ToDo詳細読み込み内容（１件分）
	private String wittingText;	//ToDo詳細書込み内容（１件分）


	
	//folderゲッター・セッター
	public String getFolder() {
		return this.folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	
	//fileNamesゲッター・セッター
	public String[] getFileNames() {
		return this.fileNames;
	}

	public void setFileNames(String[] fileNames) {
		this.fileNames = fileNames;
	}

	
	//oldFileNamesゲッター・セッター
	public String[] getOldFileNames() {
		return this.oldFileNames;
	}

	public void setOldFileNamess(String[] oldFileNames) {
		this.oldFileNames = oldFileNames;
	}

	//latestNoゲッター・セッター
	public int getLatestNo() {
		return this.latestNo;
	}

	public void setLatestNo(int latestNo) {
		this.latestNo = latestNo;
	}

	
	//linesゲッター・セッター
	public List<String> getLines() {
		return this.lines;
	}

	public void setLines(List<String> lines) {
		this.lines = lines;
	}

	
	//wittingTextゲッター・セッター
	
	public String getWritingText() {
		return this.wittingText = wittingText;
	}
	
	public void setWritingText(String wittingText) {
		this.wittingText = wittingText;
	}
		
}
