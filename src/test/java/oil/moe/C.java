package oil.moe;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        int lastday = 0, lastmonth = 0, lastyear = 0;
        int day, month, year;
        boolean c1, c2, c3;
        System.out.println("Enter today's date in form MM DD YYYY");
        Scanner scanner = new Scanner(System.in);
        month = scanner.nextInt();
        day = scanner.nextInt();
        year = scanner.nextInt();
        c1 = (day >= 1) && (day <= 31);
        c2 = (month >= 1) && (month <= 12);
        c3 = (year >= 1812) && (year <= 2012);
        if (!c1)
            System.out.println("Value of day not in the range 1...31");
        if (!c2)
            System.out.println("Value of month not in the range 1...12");
        if (!c3)
            System.out.println("Value of year not in the range 1812...2012");
        do {
            switch (month) {
                case 5:
                case 7:
                case 10:
                case 12:
                    if (day > 1) {
                        lastday = day - 1;
                        lastmonth = month;
                        lastyear = year;
                    } else {
                        lastday = 30;
                        lastmonth = month - 1;
                        lastyear = year;
                    }
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                case 9:
                case 11:
                    if (day > 1) {
                        lastday = day - 1;
                        lastmonth = month;
                        lastyear = year;
                    } else {
                        lastday = 31;
                        lastmonth = month - 1;
                        lastyear = year;
                    }
                    break;
                case 3:
                    if (day > 1) {
                        lastday = day - 1;
                        lastmonth = month;
                        lastyear = year;
                    } else {
                        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                            lastday = 29;
                            lastmonth = 2;
                            lastyear = year;
                        } else {
                            lastday = 28;
                            lastmonth = 2;
                            lastyear = year;
                        }
                    }
                    break;
                case 1:
                    if (day > 1) {
                        lastday = day - 1;
                        lastmonth = month;
                        lastyear = year;
                    } else {
                        lastday = 31;
                        lastmonth = 12;
                        if (year != 1812)
                            lastyear = year - 1;
                        else
                            System.out.println("lastyear is not in range");
                    }
                    break;
                default:
                    System.out.println("error!");

            }
            if (c1 && c2 && c3)
                System.out.println("the lastday is" + lastmonth + lastday + lastyear);
            return;
        } while (c1 && c2 && c3);
    }
}
