package model;

import java.util.Scanner;

public class CardAcceptor implements PaymentAcceptor {

    private int amount;

    public CardAcceptor(int amount) {
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
        System.out.print("Введите номер карты: ");
        String cardNumber = new Scanner(System.in).nextLine().strip();
        System.out.print("Введите одноразовый пароль: ");
        String otp = new Scanner(System.in).nextLine().strip();

        int sum;
        boolean isIllegalValue = true;

        while (isIllegalValue) {
            try {
                System.out.print("Введите сумму для пополнения: ");
                String input = new Scanner(System.in).nextLine().strip();
                sum = Integer.parseInt(input);
                if (sum <= 0) {
                    throw new IllegalArgumentException("Сумма пополнения должна быть положительным числом.");
                }

                setAmount(amount + sum);
                isIllegalValue = false;

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите числовое значение для суммы.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Пополнение успешно завершено с картой " + cardNumber);
    }


    @Override
    public void getInfo(){
        System.out.println("Вы выбрали оплату картой");
        System.out.println("Ваш баланс составляет " + getAmount());
    }
}

