/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harrypotterprogramminglang;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jdk.nashorn.internal.parser.Token;


// Tokenizer class

public class Tokenizer {

	private LinkedList<TokenInfo> tokenInfos;
	private LinkedList<Token> tokens;
	
	//public static String testString = " Harry>  x==5   <  [ Potter>   \"It Works! x = x++1\"   < ]";
	
//  \ en / even vervangd met [ en ] om foutmeldingen in Eclipse te vermijden

	//	public static String testString = " Harry>x==5<[ Poop>It Works! x = x++1<]";
	
	public static String testString = "Harry ( x == 5 ) Potter(\" hi \" )";
	public Tokenizer()
	{
		tokenInfos = new LinkedList<TokenInfo>();
		tokens = new LinkedList<Token>();
	}
	
	public void add(String regex, int token, String tekst)
	{
		tokenInfos.add( new TokenInfo(Pattern.compile("^("+regex+")"), token, tekst));
	}
		
		//tokens = new LinkedList<Token>();
	
	
	
	public static void main(String[] commandLine_Arguments)
	{
		Tokenizer tokenizer = new Tokenizer();
		
		
//		    tokenizer.add("sin|cos|exp|ln|sqrt", 1); 	// function
//  		tokenizer.add("\\(", 2); 					// open bracket
//  		tokenizer.add("\\)", 3); 					// close bracket
//  		tokenizer.add("[+-]", 4); 					// plus or minus
//  		tokenizer.add("[*//]", 5); 					// mult or divide  FIX!!! remove // between * and 5!
// 			tokenizer.add("\\^", 6); 					// raised
// 			tokenizer.add("[0-9]+",7); 					// integer number
// 			tokenizer.add("[a-zA-Z][a-zA-Z0-9_]*", 8); 	// variable

		
		tokenizer.add("Harry",2,"if");			//Function (
//		tokenizer.add(">",3, "(");				
//		tokenizer.add("<",4, ")");
		tokenizer.add("\\(",3, "(");				
		tokenizer.add("\\)",4, ")");
		tokenizer.add("\\[",5, "{");
		tokenizer.add("\\]",6, "}");
		tokenizer.add("==",7,"==");
		tokenizer.add("=",8,"=");
		tokenizer.add("x",9,"x");
		tokenizer.add("\\+", 10,"+");
		tokenizer.add("\\++", 11, "++");
		tokenizer.add("Potter", 12,"System.out.println");
		tokenizer.add("\"", 13, "\"");
		tokenizer.add(";", 14, ";");
		tokenizer.add("[0-9]+",15, "[0-9]"); 					// integer number
		tokenizer.add("[a-zA-Z][a-zA-Z0-9_]*", 16, "[a-zA-Z][a-zA-Z0-9_]*"); 	// variable
		
		try{
			//tokenizer.tokenize(" sin(x) * (1 + var_12) ");
			tokenizer.tokenize(testString);
			
			// Original: Tokenizer.Token     BUT THIS DOES NOT WORK
			// IMPORTANT NOTE!
			// BECAUSE the TOKEN class is in it's OWN JAVA file now.
			// Tokenizer.Token will ONLY work if the TOKEN class was declared WITHIN
			// the Tokenizer class!
			
			for(Token tok : tokenizer.getTokens())
			{
				System.out.println("Token: " + tok.token + "\n Sequence: " + tok.sequence + "\n Level: " + tok.level + 
								   "\n PositieRegel: " + tok.positieInRegel + "\n RegelNummer: " + tok.regelNummer + "\n Tekst: " + tok.tekst +
								   "\n Partner Aanwezig: " + tok.PartnerAanwezig + "\n \n");
				
			}
		}
		catch (ParseException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	public void tokenize(String str) throws ParseException
	{
		//What's the difference ????????????? 
		// Which one is better?faster? use less memory??
		// which one? WHICH ONE?!? 
		// :D XD
		// String s = str;
		// String s = new String(str);
		
		//String s = new String(str).trim();
		String s = str.trim();

		tokens.clear();
		
		while(!s.equals(""))
		{
			boolean match = false;
			
			
			for(TokenInfo info : tokenInfos)
			{
				Matcher m = info.regex.matcher(s);
				if(m.find())
				{
					match = true;
					
					
					String sequence = m.group().trim();
					s = m.replaceFirst("").trim();
					
					//MEER parameters moeten ingevuld worden!
					tokens.add(new Token(info.token, sequence, 0,str.indexOf(info.token),info.tekst,0,false));
					
					break;				
				}	
			}
			
					
		if(!match) 	
		{
			// Warning: 87 is gewoon een bedachte regelnummer!
			throw new ParseException("Unexpected character in input: "+s, 87);
		
		}
		
			
			
		}

		
		
		
		
		
	}
	
	public LinkedList<Token> getTokens()
	{
		return tokens;
	}
	
	
	
	
	private class TokenInfo{
		
		
		public final Pattern regex;
		
		public final int token;
		
		public final String tekst;
	
		public TokenInfo(Pattern regex, int token, String tekst)
		{
			super();
			
			this.regex = regex;
			this.token = token;
			this.tekst = tekst;
		}
		
	}
}



