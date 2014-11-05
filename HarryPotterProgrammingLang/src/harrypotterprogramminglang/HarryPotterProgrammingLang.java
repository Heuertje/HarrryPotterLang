/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harrypotterprogramminglang;

import java.util.StringTokenizer;

/**
 *
 * @author Bas
 */
public class HarryPotterProgrammingLang {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String str = "Harry ( 1 == 1 ) \n"
                + " { \n"
                + "print 'test' \n"
                + "} \n "
                + "print 'lala' \n";
	StringTokenizer st = new StringTokenizer(str, "\n");
 
	//---- Split by space ------
	while (st.hasMoreElements()) {
            System.out.println(st.nextElement());
	}   
    }
    
    public void iftoken(){
        
    }
    
}
