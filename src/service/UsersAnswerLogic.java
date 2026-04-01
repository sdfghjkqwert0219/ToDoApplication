package service;

public class UsersAnswerLogic {
	
	//数字の回答用
	public int answerInt(String question) {
		
		System.out.println(question);
		int ansValue = new java.util.Scanner(System.in).nextInt();
		
		return ansValue;
	}
	
	
	//文字列の回答用
	public String answerStr(String question) {
		
		System.out.println(question);
		String ansString = new java.util.Scanner(System.in).nextLine();
		
		return ansString;
	}

	
	

}
