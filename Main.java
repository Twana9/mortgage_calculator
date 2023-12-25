package com.twana;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
      final static byte MONTHS_IN_YEAR = 12;
      final static byte PERCENT = 100;
    public static void main(String[] args) {

          int principal;
          float annualInterest;
          byte years;

          principal = (int) numberReader("Principal: ",1000,200_000 );
          annualInterest = numberReader("annual Interest Rate: ",1,40);
          years = (byte) numberReader("years: ",1,30);

          double mortgage = calculateMorgage(years,annualInterest,principal);
          String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
          System.out.println("MORTGAGE"+"\n--------");
          System.out.println("Monthly mayments: "+ mortgageFormatted);

          System.out.println("PAYMENT SCHEDULE"+"\n---------------");
          for (short month = 1; month <= MONTHS_IN_YEAR * years; month ++) {
                double balance = calculatebalance(years,annualInterest,principal,month);
                String lastBalance = NumberFormat.getCurrencyInstance().format(balance);
                System.out.println(lastBalance);
          }
    }
       public static double calculatebalance(byte years,
                                             float annualInterest,
                                             int principal,
                                             short numberOfPaymentsMade){

             int numberOfPayments = years * MONTHS_IN_YEAR;
             float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;

             double balance = principal * ((Math.pow(1 + monthlyInterest,numberOfPayments))
                              -(Math.pow(1 + monthlyInterest,numberOfPaymentsMade)))
                              /(Math.pow(1 + monthlyInterest,numberOfPayments) - 1);
             return balance;

       }
       public static double calculateMorgage(byte years,
                                             float annualInterest,
                                             int principal) {
             final byte MONTHS_IN_YEAR = 12;
             final byte PERCENT = 100;

             System.out.println("MONTHLY MAYMENTS"+"\n----------------");
             int numberOfPayments = years * MONTHS_IN_YEAR;
             float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
             double mortgage = principal *
                     (monthlyInterest * Math.pow(1 + monthlyInterest , numberOfPayments))/
                     ((Math.pow(1 + monthlyInterest , numberOfPayments)-1));
             return mortgage;
       }

        public static float numberReader(String prompt, int min, int max) {
              float value;
              while (true) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print(prompt);
                    value = scanner.nextFloat();
                    if (value >= min && value <= max)
                          break;
                    else
                          System.out.println("Input a number between " + min + " to " + max);
              }
                    return value;

        }

}
