package org.example;


public class DataInputTest {

//    @Test
    public void TestGetInt() {

    }

    public static void main (String[] args) {
        int number = DataInput.getInt("Get int: ");
        System.out.println(number);
        int positiveNumber = DataInput.getNotNegativeInt("Get positive int: ");
        System.out.println(positiveNumber);
        double doubleNumber = DataInput.getDouble("Get double: ");
        System.out.println(doubleNumber);
    }

}