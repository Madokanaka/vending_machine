package model;

public class CoinAcceptor implements PaymentAcceptor{
    private int amount;

    public CoinAcceptor(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void acceptPayment() {
        setAmount(getAmount() + 10);
        System.out.println("Вы пополнили баланс на " + 10 + " монет.");
    }

    @Override
    public void getInfo(){
        System.out.println("Вы выбрали пополнение монетами");
        System.out.println("Ваш баланс составляет " + getAmount());
    }
}
