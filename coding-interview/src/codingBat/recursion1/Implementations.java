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

	/* Counts the number of 'abc' and 'aba' substrings	 */
	public static int countAbc(String str) {
		  if(str.isEmpty()) {
			  return 0;
		  } else if (str.length() < 3) {
			  return 0;
		  } else {
			  if(str.charAt(0) == 'a' && str.charAt(1) == 'b' &&
					  (str.charAt(2) == 'a' || str.charAt(2) == 'c')) {
				  return 1 + countAbc(str.substring(1));
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

	/** Checks if its possible to sum numbers in an array, so they sum into a target value */
	public static boolean groupSum(int start, int[] nums, int target) {
		if(target == 0) {
			return true;
		} if(nums == null || start >= nums.length || target < 0) {
			return false;
		} else {
			// Explore two paths: one we use the number, other we don't
			return groupSum(start + 1, nums, target - nums[start]) ||
					groupSum(start + 1, nums, target);
		}
	}
	
	/*
	 * Given an array of ints, is it possible to choose a group of some of the ints,
	 * such that the group sums to the given target with these additional constraints: 
	 *  - all multiples of 5 in the array must be included in the group.
	 *  If the value immediately following a multiple of 5 is 1, it must not be chosen.
	 */
	public static boolean groupSum5(int start, int[] nums, int target) {
		  if(target == 0 && start == nums.length) {
			  return true;
		  } if(nums == null || start >= nums.length || target < 0 ) {
			  return false;
		  } else {
			  // Use the number if it's a multiple of 5
			  if(nums[start] % 5 == 0) {
				  return groupSum5(start + 1, nums, target - nums[start]);
			  } else if(nums[start] == 1 && start > 0 && nums[start - 1] % 5 == 0) {
				  // Don't use 1's if they follow a 5 multiple
				  return groupSum5(start + 1, nums, target);
			  } else {
				  // Explore two paths: one we use the number, other we don't
				  return groupSum5(start + 1, nums, target - nums[start]) ||
						  groupSum5(start + 1, nums, target);
			  }
		  }
	}

	/*
	 * Given an array of ints, is it possible to divide the ints into two groups,
	 * so that the sum of one group is a multiple of 10, and the sum of the other group is odd.
	 * Every int must be in one group or the other.
	 */
	public static boolean splitOdd10(int[] nums) {
		  return splitOdd10(0, nums, 0, 0);
	}
	
	private static boolean splitOdd10(int start, int[] nums, int multiple10, int odd) {
		if(start < 0 || nums == null || nums.length == 0) {
			return false;
		} else if(start == nums.length) {
			return (multiple10 % 10 == 0) && (odd % 2 == 1);
		} else {
			return splitOdd10(start + 1, nums, multiple10 + nums[start], odd) ||
					splitOdd10(start + 1, nums, multiple10, odd + nums[start]);
		}
	}
	
	/*
	 * Given an array of ints, is it possible to choose a group of some of the ints,
	 * beginning at the start index, such that the group sums to the given target?
	 * However, with the additional constraint that all 6's must be chosen
	 */
	public static boolean groupSum6(int start, int[] nums, int target) {
		  if(start < 0 || start > nums.length || nums == null || target < 0) {
			  return false;
		  } else if(start == nums.length) {
			  return target == 0;
		  } if(nums[start] == 6) {
			  // If the number is 6, use it
			  return groupSum6(start + 1, nums, target - nums[start]);
		  } else {
			  // Try the path were the nbr is include and the path number not included
			  return groupSum6(start + 1, nums, target - nums[start]) ||
					  groupSum6(start + 1, nums, target);
		  }
	}

	/*
	 * Given an array of ints, is it possible to choose a group of some of the ints,
	 * such that the group sums to the given target, with this additional constraint:
	 * if there are numbers in the array that are adjacent and the identical value,
	 * they must either all be chosen, or none of them chosen
	 */
	public static boolean groupSumClump(int start, int[] nums, int target) {
		if(start < 0 || start > nums.length || nums == null || target < 0) {
			return false;
		} else if(start == nums.length) {
			return target == 0;
		} else {
			// Compute adjacent numbers that have the same value
			int adjacents = 1;
			while(start + adjacents < nums.length && nums[start + adjacents] == nums[start]) {
				adjacents++;
			}
			// Try path where we use the number, and path that we don't
			return groupSumClump(start + adjacents, nums, target - nums[start] * adjacents) ||
					groupSumClump(start + adjacents, nums, target);
		}
	}
	
	/*
	 * Given an array of ints, is it possible to divide the ints into two groups,
	 * so that the sum of the two groups is the same, with these constraints:
	 * all the values that are multiple of 5 must be in one group,
	 * and all the values that are a multiple of 3 (and not a multiple of 5) must be in the other
	 */
	public static boolean split53(int[] nums) {
		  return split53(0, nums, 0, 0);
	}
	
	private static boolean split53(int start, int[] nums, int sumGroup1, int sumGroup2) {
		if(start < 0 || start > nums.length || nums == null || nums.length < 1) {
			return false;
		} if(start == nums.length) {
			return sumGroup1 == sumGroup2;
		} else {
			// Multiples of 5 go in group 1
			if(nums[start] % 5 == 0) {
				return split53(start + 1, nums, sumGroup1 + nums[start], sumGroup2);
			} else if(nums[start] % 3 == 0) {
				// Multiples of 3 go in group 2
				return split53(start + 1, nums, sumGroup1, sumGroup2 + nums[start]);
			} else {
				// Try path where number is added to group 1, and path for group 2
				return split53(start + 1, nums, sumGroup1 + nums[start], sumGroup2) ||
						split53(start + 1, nums, sumGroup1, sumGroup2 + nums[start]);
			}
		}
	}

	/*
	 * Given an array of ints, is it possible to choose a group of some of the ints,
	 * such that the group sums to the given target with this additional constraint:
	 * If a value in the array is chosen to be in the group, the value immediately
	 * following it in the array must not be chosen.
	 */
	public static boolean groupNoAdj(int start, int[] nums, int target) {
		if(target == 0) {
			return true;
		} else if(start < 0 || start >= nums.length || nums == null || target < 0) {
			return false;
		} else {
			// Try path where number is added, and where number is discarded
			return groupNoAdj(start + 2, nums, target - nums[start]) ||
					groupNoAdj(start + 1, nums, target); 
		}
	}

	/*
	 * Given an array of ints, is it possible to divide the ints into two groups,
	 * so that the sums of the two groups are the same.
	 * Every int must be in one group or the other.
	 */
	public static boolean splitArray(int[] nums) {
		  return splitArray(0, nums, 0, 0);
	}
	
	private static boolean splitArray(int start, int[] nums, int sumGroup1, int sumGroup2) {
		if(start < 0 || start > nums.length || nums == null) {
			return false;
		} else if(start == nums.length) {
			return sumGroup1 == sumGroup2;
		} else {
			// Try path where nbr is added to group 1, and path number added to group 2
			return splitArray(start + 1, nums, sumGroup1 + nums[start], sumGroup2) ||
					splitArray(start + 1, nums, sumGroup1, sumGroup2 + nums[start]);
		}
	}

}
