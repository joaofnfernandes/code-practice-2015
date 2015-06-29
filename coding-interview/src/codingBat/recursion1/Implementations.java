package codingBat.recursion1;

public class Implementations {

	public static int factorial(int n) {
		if(n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
	
	public static int bunnyEars2(int bunnies) {
		if(bunnies == 0) {
			return 0;
		}
		else if(bunnies == 1) {
			return 2;
		} else {
			if(bunnies % 2 == 0) {
				return 3 + bunnyEars2(bunnies - 1);
			} else {
				return 2 + bunnyEars2(bunnies - 1);
			}
		}
	}

	public static int count7(int n) {
		if(n < 10) {
			if(n == 7) {
				return 1;
			} else {
				return 0;
			}
		} else {
			if(n % 10 == 7) {
				return 1 + count7(n / 10);
			} else {
				return count7(n / 10);
			}
		}
	}
	
	public static int countX(String str) {
		if(str.isEmpty()) {
			return 0;
		} else {
			if(str.charAt(0) == 'x') {
				return 1 + countX(str.substring(1));
			} else {
				return countX(str.substring(1));
			}
		}
	}

	public static String changePi(String str) {
		  if(str.length() < 2) {
			  return str;
		  } else {
			  if(str.startsWith("pi")) {
				  return "3.14" + changePi(str.substring(2));
			  } else {
				  return str.charAt(0) + changePi(str.substring(1));
			  }
		  }
	}
	
	public static int array11(int[] nums, int index) {
		  if(index >= nums.length) {
			  return 0;
		  } else {
			  if(nums[index] == 11) {
				  return 1 + array11(nums, index + 1);
			  } else {
				  return array11(nums, index + 1);
			  }
		  }
	}
	
	public static String pairStar(String str) {
		if(str.isEmpty()) {
			return "";
		} else if(str.length() == 1) {
			  return str;
		} else {
			if(str.charAt(0) == str.charAt(1)) {
				return str.charAt(0) + "*" + pairStar(str.substring(1)); 
			} else {
				return str.charAt(0) + pairStar(str.substring(1));
			}
		}
	}

	
	public static int countAbc(String str) {
		  if(str.isEmpty()) {
			  return 0;
		  } else if (str.length() < 3) {
			  return 0;
		  } else {
			  if(str.charAt(0) == 'a' && str.charAt(1) == 'b' &&
					  (str.charAt(2) == 'a' || str.charAt(2) == 'c')) {
				  return 1 + countAbc(str.substring(3));
			  } else {
				  return countAbc(str.substring(1));
			  }
		  }
	}
	
	public static int countHi2(String str) {
		  if(str.length() < 2) {
			  return 0;
		  } else {
			  if(str.charAt(0) == 'h' && str.charAt(1) == 'i') {
				  return 1 + countHi2(str.substring(2));
			  } else if(str.charAt(0) == 'x' && str.charAt(1) == 'h') {
				  	return countHi2(str.substring(2));
			  } else {
				  return countHi2(str.substring(1));
			  }
		  }
	}
	
	public static int strCount(String str, String sub) {
		  if(str.isEmpty() || sub.isEmpty()) {
			  return 0;
		  } else {
			  if(str.startsWith(sub)) {
				  return 1 + strCount(str.substring(sub.length()), sub);
			  } else {
				  return strCount(str.substring(1), sub);
			  }
		  }
	}
	
	public static int bunnyEars(int bunnies) {
		  if(bunnies == 0) {
			  return 0;
		  } else {
			  return 2 + bunnyEars(bunnies - 1);
		  }
	}
	
	public static int triangle(int rows) {
		  if(rows == 0) {
			  return 0;
		  } else {
			  return rows + triangle(rows - 1);
		  }
	}
	
	public static int count8(int n) {
		if(n < 10) {
			if(n == 8) {
				return 1;
			} else {
				return 0;
			}
		} else {
			// check for ...88
			if(n % 10 == 8 && (n/10) % 10 == 8) {
				return 2 + count8(n / 10);
			} else if(n % 10 == 8) {
				return 1 + count8(n / 10);
			} else {
				return count8(n / 10);
			}
		}
	}
	
	public static int countHi(String str) {
		if(str.isEmpty() || str.length() < 2) {
			return 0;
		} else {
			if(str.startsWith("hi")) {
				return 1 + countHi(str.substring(2));
			} else {
				return countHi(str.substring(1));
			}
		}
	}

	public static String noX(String str) {
		  if(str.isEmpty()) {
			  return "";
		  } else {
			  if(str.charAt(0) == 'x') {
				  return noX(str.substring(1));
			  } else {
				  return str.charAt(0) + noX(str.substring(1));
			  }
		  }
	}

	public static boolean array220(int[] nums, int index) {
		  if(nums == null || index + 1 >= nums.length) {
			  return false;
		  } else {
			  if(nums[index] * 10 == nums[index + 1]) {
				  return true;
			  } else {
				  return array220(nums, index + 1);
			  }
		  }
	}
	
	public static String endX(String str) {
		if(str.isEmpty()) {
			return "";
		} else {
			if(str.charAt(0) == 'x') {
				return endX(str.substring(1)) + str.charAt(0);
			} else {
				return str.charAt(0) + endX(str.substring(1));
			}
		}
	}

	public static int count11(String str) {
		  if(str.isEmpty() || str.length() < 2) {
			  return 0;
		  }  else {
			  if(str.startsWith("11")) {
				  return 1 + count11(str.substring(2));
			  } else {
				  return count11(str.substring(1));
			  }
		  }
	}
	
	public static String parenBit(String str) {
		if(str.isEmpty()) {
			return "";
		}
		if (str.charAt(0) != '(') {
		    return parenBit(str.substring(1));
		}
		if (str.charAt(str.length()-1) != ')') {
			return parenBit(str.substring(0, str.length()-1));
		}
		return str;
	}
	
	public static boolean strCopies(String str, String sub, int n) {
		  if(n == 0) {
			  return true;
		  } else if(str.isEmpty()) {
			  return false;
		  } else {
			  if(str.startsWith(sub)) {
				  return strCopies(str.substring(1), sub, n - 1);
			  } else {
				  return strCopies(str.substring(1), sub, n);
			  }
		  }
	}

	public static int fibonacci(int n) {
		if(n < 1) {
			return 0;
		} else if(n == 1) {
			return 1;
		} else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}

	public static int sumDigits(int n) {
		  if(n <= 0) {
			  return 0;
		  } else {
			  return n % 10 + sumDigits(n / 10); 
		  }
	}

	public static int powerN(int base, int n) {
		  if(n == 1) {
			  return base;
		  } else {
			  return base * powerN(base, n - 1);
		  }
	}

	public static String changeXY(String str) {
		  if(str.isEmpty()) {
			  return "";
		  } else {
			  if(str.charAt(0) == 'x') {
				  return "y" + changeXY(str.substring(1));
			  } else {
				  return str.charAt(0) + changeXY(str.substring(1));
			  }
		  }
	}
	
	public static boolean array6(int[] nums, int index) {
		  if(index == nums.length) {
			  return false;
		  } else {
			  if(nums[index] == 6) {
				  return true;
			  } else {
				  return array6(nums, index + 1);
			  }
		  }
	}
	
	public static String allStar(String str) {
		  if(str.isEmpty()) {
			  return "";
		  } else if(str.length() == 1) {
			  return str;
		  } else {
			  return str.charAt(0) + "*" + allStar(str.substring(1));
		  }
	}
	
	public static int countPairs(String str) {
		  if(str.isEmpty() || str.length() < 3) {
			  return 0;
		  } else {
			  if(str.charAt(0) == str.charAt(2)) {
				  return 1 + countPairs(str.substring(1));
			  } else {
				  return countPairs(str.substring(1));
			  }
		  }
	}

	public static String stringClean(String str) {
		  if(str.isEmpty()) {
			  return "";
		  } else if(str.length() == 1) {
			  return str;
		  } else {
			  if(str.charAt(0) == str.charAt(1)) {
				  return stringClean(str.substring(1));
			  } else {
				  return str.charAt(0) + stringClean(str.substring(1));
			  }
		  }
	}
	
	public static boolean nestParen(String str) {
		  if(str.isEmpty()) {
			  return true;
		  } else if(str.length() == 1){
			  return false;
		  } else {
			  if(str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
				  return nestParen(str.substring(1, str.length() - 1));
			  } else {
				  return false;
			  }
		  }
	}

	public static int strDist(String str, String sub) {
		if(str.isEmpty()) {
			return 0;
		} else {
			if(!str.startsWith(sub)) {
				return strDist(str.substring(1), sub);
			}
			if(!str.endsWith(sub)) {
				return strDist(str.substring(0, str.length() - 1), sub);
			}
			return str.length();
		}
	}




}
