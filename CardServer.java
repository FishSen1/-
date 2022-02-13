package top.fishsen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CardServer {
    public ArrayList<User> user;

    public CardServer(){
        this.user = new ArrayList<>();
    }


    public void showBalance(String id){  //余额查询
        int ret = isInUser(id);
        if(ret != -1 && ret !=-2){
            double balance = user.get(ret).getBalance();
            System.out.println("该用户的余额为:"+balance);
        }
        else{
            System.out.println("该用户不存在,请重试");
        }
    }

    public void charge(String id){  //卡片充值
        int ret = isInUser(id);
        if(ret != -1 && ret !=-2){
            Scanner s = new Scanner(System.in);
            while(true) {
                System.out.print("请输入充值金额:");
                double charge = s.nextDouble();
                if (charge > 0) {
                    user.get(ret).setBalance(user.get(ret).getBalance()+charge);
                    FileSearch.storeUser(user.get(ret),FileSearch.rootPath + "/" + id + "/"+id+".txt");
                    System.out.println("充值成功!");
                    System.out.println("当前余额为:"+user.get(ret).getBalance());
                    break;
                } else {
                    System.out.println("输入金额有误,请重新输入");
                }
            }
        }
        else{
            System.out.println("该用户不存在,请重试");
        }
    }


    public void creUser(String id, String name, String sex, String phone) throws IOException {  //创建用户
        int ret = isInUser(id);
        if(ret == -1 || ret == -2) {
            user.add(new User(id, name, sex, phone));
            FileSearch.mkFolder(FileSearch.rootPath + "/" + id);
            FileSearch.storeUser(user.get(user.size()-1),FileSearch.rootPath + "/" + id + "/"+id+".txt");
            System.out.println("创建用户成功!");
        }
        else{
            System.out.println("用户ID的重复,请重试");
        }
    }

    public void delUser(String id) {  //删除用户
        int ret = isInUser(id);
        if(ret != -1 && ret != -2){
            user.remove(ret);
            FileSearch.delFolder(FileSearch.rootPath+"/"+id);
            System.out.println("用户删除成功!");
        }
        else{
            System.out.println("该用户不存在,请重试");
        }
    }


    public void showAll(){  //显示所有
        if(user.size() > 0){
            System.out.println("卡号\t\t姓名\t\t性别\t\t电话号码\t\t余额\t\t银行卡\t\t健康码");
            for (int i = 0; i < user.size(); i++) {
                System.out.println(user.get(i).getCardId()+"\t\t"+user.get(i).getName()+"\t\t"+
                        user.get(i).getSex()+"\t\t"+user.get(i).getPhone()+"\t\t"+user.get(i).getBalance()+"\t\t"
                         +user.get(i).getBank()+"\t\t"+user.get(i).getCode()+"\t\t");
            }
        }
        else{
            System.out.println("当前无用户");
        }
    }

    public void shopping(String id){  //消费
        int ret = isInUser(id);
        if(ret != -1 && ret != -2){
            Scanner s = new Scanner(System.in);
            System.out.print("请输入金额:");
            Double fee = s.nextDouble();
            double balance = user.get(ret).getBalance()- fee;
            if( balance > 0){
                user.get(ret).setBalance(balance);
                FileSearch.storeUser(user.get(ret),FileSearch.rootPath + "/" + id + "/"+id+".txt");
                System.out.println("刷卡成功,当前余额为:"+user.get(ret).getBalance());
            }
            else{
                System.out.println("余额不足,请充值");
            }
        }
        else{
            System.out.println("该用户不存在,请重试");
        }
    }

    public void setBank(String id){  //绑定银行卡号
        int ret = isInUser(id);
            Scanner s = new Scanner(System.in);
            System.out.print("请输入银行卡号:");
            user.get(ret).setBank(s.next());
            FileSearch.storeUser(user.get(ret),FileSearch.rootPath + "/" + id + "/"+id+".txt");
            System.out.println("绑定银行卡成功!");
    }

    public void setCode(String id){  //设置健康码
        int ret = isInUser(id);
        if(ret != -1 && ret != -2){
            while(true) {
                Menu.chooseCode();
                System.out.print("请选择:");
                Scanner s = new Scanner(System.in);
                int option = s.nextInt();
                switch (option) {
                    case 1:
                        user.get(ret).setCode("绿码");
                        FileSearch.storeUser(user.get(ret),FileSearch.rootPath + "/" + id + "/"+id+".txt");
                        System.out.println("成功设置健康码为:绿码");
                        return;
                    case 2:
                        user.get(ret).setCode("黄码");
                        FileSearch.storeUser(user.get(ret),FileSearch.rootPath + "/" + id + "/"+id+".txt");
                        System.out.println("成功设置健康码为:黄码");
                        return;
                    case 3:
                        user.get(ret).setCode("红码");
                        FileSearch.storeUser(user.get(ret),FileSearch.rootPath + "/" + id + "/"+id+".txt");
                        System.out.println("成功设置健康码为:红码");
                        return;
                    default:
                        System.out.println("输入有误,请重新输入");
                }
            }
        }
    }


    public boolean checkCode(String id){  //检查健康码
        int ret = isInUser(id);
        return user.get(ret).getCode().equals("绿码");
    }

    public int isInUser(String id){  //判断用户是否存在
        if(user.size() != 0) {
            for (int i = 0; i < user.size(); i++) {
                if (user.get(i).getCardId().equals(id)) {
                    return i;
                }
            }
        }
        else{
            return -2;
        }
        return -1;
    }
}
