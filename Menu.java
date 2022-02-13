package top.fishsen;

public class Menu {

    public static void mainMenu(){  //主菜单
        System.out.println("******************************************");
        System.out.println("***********欢迎使用一卡通模拟系统*********");
        System.out.println("***********     1.行为模拟     ***********");
        System.out.println("***********     2.卡片管理     ***********");
        System.out.println("***********     0.退出系统     ***********");
        System.out.println("******************************************");
    }

    public static void behave(){   //行为模拟菜单
        System.out.println("******************************************");
        System.out.println("************      行为模拟     ************");
        System.out.println("************       1.超市     ************");
        System.out.println("************       2.银行     ************");
        System.out.println("************       3.车站     ************");
        System.out.println("************       4.公交     ************");
        System.out.println("************       5.地铁     ************");
        System.out.println("************       6.医院     ************");
        System.out.println("************     0.返回上级    ************");
        System.out.println("******************************************");
    }

    public static void cardMannger(){ //卡片管理菜单
        System.out.println("******************************************");
        System.out.println("***********      卡片管理      ************");
        System.out.println("***********     1.余额查询     ************");
        System.out.println("***********     2.卡片充值     ************");
        System.out.println("***********     3.卡片创建     ************");
        System.out.println("***********     4.卡片注销     ************");
        System.out.println("***********     5.显示所有     ************");
        System.out.println("***********     6.健康码设置   ************");
        System.out.println("***********     0.返回上级     ************");
        System.out.println("******************************************");

    }

    public static void superMarket(){ //超市模拟菜单
        System.out.println("******************************************");
        System.out.println("***********        超市       ************");
        System.out.println("***********     1.消费模拟    *************");
        System.out.println("***********     0.返回上级    *************");
        System.out.println("******************************************");
    }

    public static void bank(){  //银行模拟菜单
        System.out.println("******************************************");
        System.out.println("***********       银行        ************");
        System.out.println("***********    1.银行卡绑定   *************");
        System.out.println("***********    0.返回上级     *************");
        System.out.println("******************************************");
    }

    public static void station(){  //车站模拟菜单
        System.out.println("******************************************");
        System.out.println("**********        车站        ************");
        System.out.println("**********     1.刷卡进站     *************");
        System.out.println("**********     0.返回上级     *************");
        System.out.println("******************************************");
    }

    public static void bus(){  //公交菜单
        System.out.println("******************************************");
        System.out.println("**********        公交        ************");
        System.out.println("**********      1.刷卡消费    *************");
        System.out.println("**********      0.返回上级    *************");
        System.out.println("******************************************");
    }

    public static void subway(){  //地铁模拟菜单
        System.out.println("******************************************");
        System.out.println("**********        地铁        ************");
        System.out.println("**********      1.刷卡进站    *************");
        System.out.println("**********      2.健康码出示  *************");
        System.out.println("**********      0.返回上级    *************");
        System.out.println("******************************************");
    }

    public static void hospital(){  //医院模拟菜单
        System.out.println("******************************************");
        System.out.println("**********        医院        ************");
        System.out.println("**********      1.????       *************");
        System.out.println("**********      0.返回上级    *************");
        System.out.println("******************************************");
    }

    public static void showCode(){  //出示健康码
        System.out.println("******************************************");
        System.out.println("**********     请出示健康码     ************");
        System.out.println("**********       1.出示        ************");
        System.out.println("******************************************");
    }

    public static void chooseCode(){  //选择健康码类型
        System.out.println("******************************************");
        System.out.println("**********       1.绿码         ***********");
        System.out.println("**********       2.黄码         ***********");
        System.out.println("**********       3.红码         ***********");
        System.out.println("******************************************");
    }
}
