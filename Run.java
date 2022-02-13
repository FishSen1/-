package top.fishsen;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws Exception {

        FileSearch.mkRootFolder();//新建目录
        CardServer cardServer = new CardServer();
        File file = new File("C:/Card");
        ObjectInputStream ois = null;
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            if(files != null){
                for(File files1:files) {
                    if(files1.isDirectory()){
                        File[] files2 = files1.listFiles();
                        if(files2 != null){
                            for(File files3:files2){
                                if(files3.isFile()){  //导入用户对象
                                    ois = new ObjectInputStream(new FileInputStream(files3));
                                    cardServer.user.add((User)ois.readObject());
                                }
                                else if(files3.isDirectory()){
                                    //给record预留
                                }
                            }
                        }
                    }
                }
            }
        }
        if(ois != null){
            ois.close();
        }

        int option;
        boolean flag;
        String id = null;
        Scanner scanner= new Scanner(System.in);

        while(true) {
            flag = true;
            Menu.mainMenu();  //主菜单
            System.out.print("请输入你的选项(0~6):");
            option = scanner.nextInt();
            boolean flag3 = true;
            switch (option) {
                case 1:  //行为模拟
                    while(flag){
                        if(flag3) {
                            while (true) {
                                System.out.print("请输入要进行模拟卡号id:");
                                id = scanner.next();
                                int ret = cardServer.isInUser(id);
                                if (ret != -1 && ret != -2) {
                                    break;
                                } else {
                                    System.out.println("该用户不存在,请重试");
                                }
                            }
                        }
                        Menu.behave();  //行为模拟菜单
                        System.out.print("请输入你的选项:");
                        option = scanner.nextInt();
                        boolean flag2 = true;
                        switch(option){
                            case 1:  //超市
                                while(flag2){
                                    Menu.superMarket();
                                    System.out.print("请输入你的选项:");
                                    option = scanner.nextInt();
                                    switch (option){
                                        case 1:  //消费模拟
                                            cardServer.shopping(id);
                                            System.out.println("欢迎下次光临~~~");
                                            break;
                                        case 0:flag2 = false;//返回上级
                                            flag3 = false;
                                            break;
                                        default:
                                            System.out.println("输入错误,请重新输入");
                                    }
                                }
                                break;
                            case 2:  //银行
                                while(flag2){
                                    Menu.bank();
                                    System.out.print("请输入你的选项:");
                                    option = scanner.nextInt();
                                    switch (option){
                                        case 1:  //银行卡绑定
                                            cardServer.setBank(id);
                                            break;
                                        case 0:flag2 = false;  //返回上级
                                            flag3 = false;
                                            break;
                                        default:
                                            System.out.println("输入错误,请重新输入");
                                    }
                                }
                                break;
                            case 3:  //车站
                                while(flag2){
                                    Menu.station();
                                    System.out.print("请输入你的选项:");
                                    option = scanner.nextInt();
                                    switch (option){
                                        case 1:  //刷卡进站
                                            Menu.showCode();
                                            System.out.print("按1出示健康码:");
                                            option = scanner.nextInt();
                                            switch(option){
                                                case 1:
                                                    boolean isGreen = cardServer.checkCode(id);
                                                    if(isGreen){
                                                        System.out.println("您是绿码,可以进站");
                                                    }
                                                    else{
                                                        System.out.println("您不是绿码,请跟我们走一趟");
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("未出示健康码,不得进站");
                                            }
                                            break;
                                        case 0:flag2 = false;  //返回上级
                                            flag3 = false;
                                            break;
                                        default:
                                            System.out.println("输入错误,请重新输入");
                                    }
                                }
                                break;
                            case 4:  //公交
                                while(flag2){
                                    Menu.bus();
                                    System.out.print("请输入你的选项:");
                                    option = scanner.nextInt();
                                    switch (option){
                                        case 1:  //刷卡消费
                                            cardServer.shopping(id);
                                            break;
                                        case 0:flag2 = false;  //返回上级
                                            flag3 = false;
                                            break;
                                        default:
                                            System.out.println("输入错误,请重新输入");
                                    }
                                }
                                break;
                            case 5:  //地铁
                                while(flag2){
                                    Menu.subway();
                                    System.out.print("请输入你的选项:");
                                    option = scanner.nextInt();
                                    switch (option){
                                        case 1:  //刷卡进站
                                            cardServer.shopping(id);
                                            break;
                                        case 2:  //健康码出示
                                            Menu.showCode();
                                            System.out.print("按1出示健康码:");
                                            option = scanner.nextInt();
                                            switch(option){
                                                case 1:
                                                    boolean isGreen = cardServer.checkCode(id);
                                                    if(isGreen){
                                                        System.out.println("您是绿码,可以进站");
                                                    }
                                                    else{
                                                        System.out.println("您不是绿码,请跟我们走一趟");
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("未出示健康码,不得进站");
                                            }
                                            break;
                                        case 0:flag2 = false;  //返回上级
                                            flag3 = false;
                                            break;
                                        default:
                                            System.out.println("输入错误,请重新输入");
                                    }
                                }
                                break;
                            case 6:  //医院
                                while(flag2){
                                    Menu.hospital();
                                    System.out.print("请输入你的选项:");
                                    option = scanner.nextInt();
                                    switch (option){
                                        case 1:
                                            System.out.println(".........");
                                            break;
                                        case 0:flag2 = false;
                                            flag3 = false;
                                            break;
                                        default:
                                            System.out.println("输入错误,请重新输入");
                                    }
                                }
                                break;
                            case 0:  //返回上级
                                flag = false;
                                break;
                            default:
                                System.out.println("输入错误,请重新输入");
                        }
                    }
                    break;
                case 2:  //卡片管理
                    while(flag){
                        Menu.cardMannger();  //卡片管理菜单
                        System.out.print("请输入你的选项:");
                        option = scanner.nextInt();
                        switch(option){
                            case 1:  //余额查询
                                cardServer.showBalance(InputTool.inputId(scanner));
                                break;
                            case 2:  //卡片充值
                                cardServer.charge(InputTool.inputId(scanner));
                                break;
                            case 3:  //卡片创建
                                cardServer.creUser(InputTool.inputId(scanner),InputTool.inputName(scanner),
                                                   InputTool.inputSex(scanner),InputTool.inputPhone(scanner));
                                break;
                            case 4:  //卡片注销
                                cardServer.delUser(InputTool.inputId(scanner));
                                break;
                            case 5:  //显示所有
                                 cardServer.showAll();
                                break;
                            case 6:  //健康码设置
                                cardServer.setCode(InputTool.inputId(scanner));
                                break;
                            case 0:  //返回上级
                                flag = false;
                                break;
                            default:
                                System.out.println("输入错误,请重新输入");
                        }
                    }
                    break;
                case 0:  //退出系统
                    System.out.println("退出系统成功");
                    scanner.close();
                    return;
                default:
                    System.out.println("输入错误,请重新输入");
            }
        }
    }
}
