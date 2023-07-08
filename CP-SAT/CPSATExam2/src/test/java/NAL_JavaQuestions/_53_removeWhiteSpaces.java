package NAL_JavaQuestions;

import org.apache.commons.*;

import bsh.StringUtil;

public class _53_removeWhiteSpaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "    This is Java Code      ";
		
		//using replace all
		String replaceallString =  s.replaceAll(" ","");
		System.out.println(replaceallString);
		
		//Using String Utils
		//StringUtils.deleteWhitespace(s);
		
		//Using for loop
		String s1 = "";
		for(int i=0;i<s.length();i++) {
			if((s.charAt(i)!=' ') && (s.charAt(i)!='\t')) {
				s1 = s1 + s.charAt(i);
			}
		}
		System.out.println(s1);
		
		//Using /s
		String slashString = s.replaceAll("\\s","");
		System.out.println(slashString);
		
		//Using Array and StringBuffer
		String[] s2 = s.split("\\s+");
		StringBuffer sBuffer=new StringBuffer();
		for(String cString : s2) {
			sBuffer.append(cString);
		}
		System.out.println(sBuffer);
	}

}
