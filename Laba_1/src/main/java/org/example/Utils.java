package org.example;

public class Utils {
	 public static int compareTwoStrings (String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();



        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            char charFromStr1 = str1.charAt(i);
            char charFromStr2 = str2.charAt(i);

            if (charFromStr1 < charFromStr2)
                return -1;
            if (charFromStr1 > charFromStr2)
                return 1;
        }

        if (str1.length() == str2.length())
            return 0;
        if (str1.length() < str2.length())
            return -1;
        return 1;
    }

    public static Human[] quickSortByName(Human[] a, int beginIndex, int endIndex ){
        if (beginIndex < endIndex) {
            int dividingIndex = getDividingIndexString(a, beginIndex, endIndex);
            quickSortByName(a, beginIndex, dividingIndex - 1);
            quickSortByName(a, dividingIndex + 1, endIndex);
        }
        return a;
     }

	private static int getDividingIndexString(Human [] a, int beginIndex, int endIndex) {
        String key = a[endIndex].getName();
        int i = beginIndex - 1;
        for (int j = beginIndex; j < endIndex; j++) {
            if (compareTwoStrings(a[j].getName(), key) < 0) {
                i++;
				swapHumans(a, i, j);
            }
        }
        swapHumans(a, i + 1, endIndex);

        return i + 1;
    }

	private static void swapHumans(Human [] a, int i, int j) {
		Human temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

    private static void swapStudents(Student [] a, int i, int j) {
         Student temp = a[i];
         a[i] = a[j];
         a[j] = temp;
    }

    private static int getDividingIndexInt(Student [] a, int beginIndex, int endIndex) {
        int key = a[endIndex].getYear();
        int i = beginIndex - 1;
        for (int j = beginIndex; j < endIndex; j++) {
            if (a[j].getYear() < key) {
                i++;
                swapStudents(a, i, j);
            }
        }
        swapStudents(a, i + 1, endIndex);
        return i + 1;
    }

    public static Student[] quickSortByYear(Student[] a, int beginIndex, int endIndex ){
        if (beginIndex < endIndex) {
            int dividingIndex = getDividingIndexInt(a, beginIndex, endIndex);
            quickSortByYear(a, beginIndex, dividingIndex - 1);
            quickSortByYear(a, dividingIndex + 1, endIndex);
        }
        return a;
    }
}
