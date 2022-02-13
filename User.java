package top.fishsen;

import java.io.Serializable;

public class User implements Serializable {
    private String cardId;  //卡号
    private Double balance;  //余额
    private String name;    //姓名
    private String sex;       //性别
    private String phone;   //手机号
    private String bank;    //银行信息
    private String Code;    //健康码信息

    public User() {

    }

    public User(String cardId, String name, String sex, String phone) {
        this.cardId = cardId;
        this.balance = 0.0;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.bank = "未绑定";
        this.Code = "未绑定";
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
}
