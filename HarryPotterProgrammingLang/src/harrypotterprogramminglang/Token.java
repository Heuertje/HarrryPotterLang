/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harrypotterprogramminglang;

/**
 *
 * @author Bas
 */

public class Token{
	
	public final 			int 			token;
	public final 			String			sequence;
	
	public final			int 			regelNummer;
	public final			int 			positieInRegel;
	public final			String 			tekst;
	
	public final			int 			level;
	public final			boolean 		PartnerAanwezig;
	
//	WAAROM heb ik specific een enumrator nodig???
	//public 					enum 			beschrijving {IF,ELSE,WHILE,METHOD,VARIABLE,INT,MULTIPLIER,DIVIDER,ADDITION,SUBSTRACTION}; //OF dit willekeurige token een WHILE is of ELSE, enz.
	
	
	
	
	
	public Token(int token,	String sequence, int regelNummer,
				int positieInRegel, String tekst, 
				int level, boolean PartnerAanwezig){
		super();
		this.token = token;
		this.sequence = sequence;
		this.regelNummer = regelNummer;
		this.positieInRegel = positieInRegel;
		this.tekst = tekst;
		this.level = level;
		this.PartnerAanwezig = PartnerAanwezig;
		
		
	/*	
		for(tuna people: tuna.values())
		{
			System.out.printf("%s\t%s\t%s\n",people,people.getDesc(), people.getYear());
		}
		*/
		
	}
	
	//Example of a enumrator class
	public enum tuna{
		
		bucky("nice", "22"),
		kelsey("cutie", "10"),
		julia("bigmistake","12");
		
		private final String desc;
		private final String year;
		
		tuna(String description, String birthday){
			desc = description;
			year = birthday;
		}
		
		
		public String getDesc()
		{
			return desc;
		}
		
		public String getYear()
		{
			return year;
		}
	}
	
}
