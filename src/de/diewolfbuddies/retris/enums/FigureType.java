package de.diewolfbuddies.retris.enums;

public enum FigureType {



	TypeI(new boolean[][] {
		
//	░░░░
//	▓▓▓▓
//	░░░░
//	░░░░
		
	{	false, false, false, false,
		true, true, true, true,
		false, false, false, false,
		false, false, false, false,
	},

//	░░▓░
//	░░▓░
//	░░▓░
//	░░▓░
	
	{
		false, false, true, false,
		false, false, true, false,
		false, false, true, false,
		false, false, true, false,
	},
	
//	░░░░
//	░░░░
//	▓▓▓▓
//	░░░░
	
	{
		false, false, false, false,
		false, false, false, false,
		true, true, true, true,
		false, false, false, false,
	},
	
//	░▓░░
//	░▓░░
//	░▓░░
//	░▓░░
	
	{
		false, true, false, false,
		false, true, false, false, 
		false, true, false, false, 
		false, true, false, false,
	}
	});
	
	
	FigureType(boolean[][] boolarray) {
		
	}
	
	
}
