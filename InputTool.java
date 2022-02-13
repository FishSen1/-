package top.fishsen;

import java.util.Scanner;

public class InputTool {

    public static String inputId(Scanner s)
    {
        System.out.print("请输入id:");
        return s.next();
    }

    public static String inputName(Scanner s){
        System.out.print("请输入姓名:");
        return s.next();
    }

    public static String inputSex(Scanner s){
        System.out.print("请输入性别:");
        return s.next();
    }

    public static String inputPhone(Scanner s){
        System.out.print("请输入电话号码:");
        return s.next();
    }

    public static double inputBalance(Scanner s){
        System.out.print("请输入金额:");
        return s.nextDouble();
    }


}
