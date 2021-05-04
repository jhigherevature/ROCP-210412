package model;

public class BankAccount {
    private Integer aid;
    private String type;
    private Float balance;

    public BankAccount(Integer aid, String type, Float balance) {
        this.aid = aid;
        this.type = type;
        this.balance = balance;
    }

    public Integer getAid() {
        return aid;
    }

    public String getType() {
        return type;
    }

    public Float getBalance() {
        return balance;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BankAccount target = (BankAccount) obj;
        if (aid == null) {
            if (target.aid != null)
                return false;
        } else if (aid.equals(target.aid))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %s", aid, type);
    }
}
