package view;

import model.ToDoListModel;

public class SingleView {

	// ToDo詳細表示
	public void todoPreview(ToDoListModel lm) {

		for (String line : lm.getLines()) {
			System.out.println(line);
		}
		System.out.println("");
	}
	
}
