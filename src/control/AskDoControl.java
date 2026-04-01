package control;

import java.util.InputMismatchException;

import model.ToDoListModel;
import service.ToDoListLogicModel;
import service.ToDoLogicModel;
import service.UsersAnswerLogic;
import view.ListView;
import view.TopView;
import view.messageView;

//操作指示受け取り
public class AskDoControl {

	UsersAnswerLogic userans = new UsersAnswerLogic();
	messageView msgView = new messageView();
	AskYesOrNoControl ynControl = new AskYesOrNoControl();
	ToDoLogicModel logicModel = new ToDoLogicModel();
	TopView topView = new TopView();
	
	int targetNo;
	
	//詳細表示・追加・編集・完了・削除の操作指定
	public int askOperation(ToDoListModel lm ,ToDoLogicModel logicModel ,ToDoListLogicModel listLogic ,ListView listView) throws InputMismatchException {
		
		int opeNo;	//指定操作番号
		String operation = null;	//指定操作番号
		
			//登録０件の場合の選択肢
			if(lm.getFileNames().length == 0) {
			
				do {
					//操作選択
				    opeNo = userans.answerInt("何をしますか？\n 1:タスク追加・5:キャンセル");
	
				    //入力チェック
				    if (!(opeNo == 1 || opeNo == 5)) {
				        System.out.println("\n半角数字1または5で入力してください");
				    }
				    
				} while (!(opeNo == 1 || opeNo == 5));
				        
			} else {
			
			//登録1件以上の場合の選択肢		
				do {
					//操作選択
				    opeNo = userans.answerInt("何をしますか？\n 0:詳細表示・1:タスク追加・2:編集・3:ステータス更新・4:削除・5:キャンセル");
		
				  //入力チェック
				    if (!(opeNo == 0 || opeNo == 1 || opeNo == 2 || opeNo == 3 || opeNo == 4 || opeNo == 5)) {
				        System.out.println("\n半角数字0～5で入力してください");
				    }
		
				} while (!(opeNo == 0 || opeNo == 1 || opeNo == 2 || opeNo == 3 || opeNo == 4 || opeNo == 5));
	
			}
		
		do {
			
			//条件分岐
			switch (opeNo) {
			
				case 0 -> {	
					operation = "詳細表示";
					System.out.println("\nToDo詳細を表示します");
					logicModel.todoView(askSelectTarget(lm),lm);
					
					//操作選択
				    int moreOpeNum = userans.answerInt("\n 0:戻る・1:編集・2:削除");

				    //入力チェック
					do {
					    if (!(moreOpeNum == 0 || moreOpeNum == 1 || moreOpeNum == 2)) {
					        System.out.println("\n半角数字1または5で入力してください");
					    }
					    
					} while (!(moreOpeNum == 0 || moreOpeNum == 1 || moreOpeNum == 2));

					
					//条件分岐
					switch (moreOpeNum) {
					
						case 0 -> {	//キャンセル
							System.out.println("戻ります");;
						}
						case 1 -> {	//編集
							logicModel.todoUpdate(targetNo,lm );
						}
						case 2 -> {	//削除
							logicModel.todoDel(targetNo,lm);
						}
					}
				}
				
				case 1 -> {	
					operation = "新規登録";
					System.out.println("\nToDoを新規作成します");
					logicModel.todoAdd(lm);
				}
				
				case 2 -> {	
					operation = "内容変更";
					System.out.println("\nToDoの内容を変更します");
					logicModel.todoUpdate(askSelectTarget(lm),lm );
				}
				
				case 3 -> {	
					operation = "ステータス変更";
					System.out.println("\nToDoのステータスを更新します");
					logicModel.updateStatusOnly(askSelectTarget(lm),lm) ;
				}
				
				case 4 -> {	//削除
					operation = "削除";
					System.out.println("\nToDoを削除します");
					logicModel.todoDel(askSelectTarget(lm),lm);
				}
				
				case 5 -> {	//終了
					System.out.println("\n処理を終了します");
					return opeNo;
				}
			}
			topView.home(lm, listLogic, listView);

			
			//処理を続けるか確認	
		} while(ynControl.askContinue(operation).equals("y"));
		
		//msg表示「トップページに戻ります」
		msgView.goHomeMsg();	

		return opeNo;
	}

	
	
	//操作対象のToDoを指定
	public int askSelectTarget(ToDoListModel lm) {
		
		do {
			//対象指定
			targetNo = userans.answerInt("\n表示番号で対象のToDoを指定してください") - 1;
			
			if(targetNo >= lm.getFileNames().length || targetNo < 0) {
			
				System.out.println("\n表示番号の範囲外です。1～" + lm.getFileNames().length + "の数字で入力してください");
			}	
		} while(targetNo >= lm.getFileNames().length || targetNo < 0); {
			
		}
		
		return targetNo;
	}

	
	
	//編集項目を指定
	public String askEditContents() {
		
		String editContentsNo;
		char a;
		int count;
		
		do {
			
			//項目選択
			editContentsNo =userans.answerStr("\n編集したい項目を選んでください。\n"
					+ "複数ある場合は数字を続けて入力（例：タスク内容とメモ→14）\n "
					+ "1:タスク内容・2:ステータス・3:期日・4:メモ・5:キャンセル");
			count = 0;

			//入力チェック
			for(int i = 0 ; i < editContentsNo.length() ;i++ ) {

				a = editContentsNo.charAt(i);
				
				if (!(a == '1' || a == '2' || a == '3' || a == '4' || a == '5')) {
					
					System.out.println("\n半角数字1～5で入力してください");
					
			    	
			    } else {
			    	count++;	
			    }
			}

		} while (count < editContentsNo.length());
	
		return editContentsNo;
	}
	
}
