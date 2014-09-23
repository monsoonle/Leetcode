package com.ll.Frequency_5;

/***
 * 
 * @author Le
 * 
 *         Validate if a given string is numeric.
 * 
 *         Some examples: "0" => true; " 0.1 " => true; "abc" => false; "1 a"
 *         =>false ; "2e10" => true ; Note: It is intended for the problem
 *         statement to be ambiguous. You should gather all requirements up
 *         front before implementing one.
 *
 */
public class Valid_Number {
	public boolean isNumber(String s) {
		int len = s.length();
		int i = 0, e = len - 1;
		while (i <= e && Character.isWhitespace(s.charAt(i))) {
			i++;
		}

		if (i > len - 1) {
			return false;
		}

		while (e >= i && Character.isWhitespace(s.charAt(e))) {
			e--;
		}

		// skip leading +/-
		if (s.charAt(i) == '+' || s.charAt(i) == '-') {
			i++;
		}

		boolean num = false; // is a digit
		boolean dot = false; // is a '.'
		boolean exp = false; // is a 'e'
		while (i <= e) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = true;
			} else if (c == '.') {
				if (exp || dot)
					return false;
				dot = true;
			} else if (c == 'e') {
				if (exp || num == false) {
					return false;
				}

				exp = true;
				num = false;
			} else if (c == '+' || c == '-') {
				if (s.charAt(i - 1) != 'e') {
					return false;
				}

			} else {
				return false;
			}
			i++;
		}
		return num;
	}
}




//public boolean isNumber(String s) {
//    if(s == null)
//        return false;
//    s = s.trim();
//    if(s.length() == 0)
//        return false;
//    boolean dotFlag = false;
//    boolean eFlag = false;
//    for(int i = 0;i < s.length();i++)
//    {
//        switch(s.charAt(i))
//        {
//            case '.':
//                if(dotFlag || eFlag || ((i == 0 || !(s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9')) && (i == s.length() - 1 || !(s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9'))))
//                    return false;
//                dotFlag = true;
//                break;
//            case '+':
//            case '-':
//                if((i > 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) 
//                	|| (i == s.length() - 1 || !(s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9' || s.charAt(i + 1) == '.')))
//                    return false;
//                break;
//            case 'e':
//            case 'E':
//                if(eFlag || i == s.length() - 1 || i == 0)
//                    return false;
//                eFlag = true;
//                break;
//            case '0':
//            case '1':
//            case '2':
//            case '3':
//            case '4':
//            case '5':
//            case '6':
//            case '7':
//            case '8':
//            case '9':
//                break;
//            default:
//                return false;
//        }
//    }
//    return true;
//}











//我的想法， 极其简单， I could not find anything wrong, I found most of the 
//solutions are difficult to write and easy to make mistakes.
//
//you can finish the following in less than 5 minutes and most importantly 
//hard to make mistakes.
//
//bool isValide(char *string)
//{
//  char *p = string;
//
//  if (p == NULL) return false;
//
//   p += skipWhiteSpaces(p);
//   p += skipSigns(p);
//
//   int n1 = skipDigits(p);
//   p+= n1;
//   if (*p == '.') p++;
//  
//   int n2 = skipDigits(p);
//   p += n2;
//
//   if (n1 == 0 && n2 == 0) return false;
//  
//   if (*p == 'e' || *p == 'E')
//   {
//      p++;
//      p += skipSigns(p);
//      int n3 = skipDigits(p);
//      if (n3 == 0) return false;
//      p += n3;
//   }
//
//   p += skipWhiteSpaces(p);
//  return  *p == '\0';
//}
//
//those helper functions are easy to understand and write.
