package control;

import java.text.Normalizer;

import service.UsersAnswerLogic;

public class AskYesOrNoControl {

	UsersAnswerLogic userans = new UsersAnswerLogic();
	
	//続けるか確認
	public String askContinue(String operation) {
		
		String ans;
		
		do {
			ans =userans.answerStr("\n"+ operation + "を続けますか?入力してください\n　y：はい、n：いいえ");
			
			//全角は半角に変換
			ans = Normalizer.normalize(ans, Normalizer.Form.NFKC);
		
			//入力チェック
			if (!(ans.equals("y") || ans.equals("n"))) {
		        System.out.println("\n「y」または「n」で入力してください");
		    }
			
		} while (!(ans.equals("y") || ans.equals("n")));
	
		return ans;
	}
	
	
	//最終確認
	public String askFinalAnswer() {
	
		String lastAns;
		
		do {
			lastAns =userans.answerStr("\nよろしいですか？\n　y：はい、n：いいえ");
	
			//全角は半角に変換
			lastAns = Normalizer.normalize(lastAns, Normalizer.Form.NFKC);
			
			//入力チェック
			if (!(lastAns.equals("y") || lastAns.equals("n"))) {
		        System.out.println("\n「y」または「n」で入力してください");
		    }
			
		} while (!(lastAns.equals("y") || lastAns.equals("n")));
	
		return lastAns;
	}
	
}
