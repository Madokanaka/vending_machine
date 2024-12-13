package model;

public interface PaymentAcceptor {
    void acceptPayment();
    int getAmount();
    void setAmount(int amount);
    void getInfo();
}

