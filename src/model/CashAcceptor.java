package model;

import java.util.Scanner;

public class CashAcceptor implements PaymentAcceptor {

    private int amount;
    private final int[] allowedNotes = {20, 50, 100, 200, 500, 1000};

    public CashAcceptor(int amount) {
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
        boolean isIllegalValue = true;

        while (isIllegalValue) {
            try {
                System.out.print("Введите сумму наличными для пополнения (доступны купюры: 20, 50, 100, 200, 500, 1000): ");
                String input = new Scanner(System.in).nextLine().strip();
                int sum = Integer.parseInt(input);

                if (!isValidNote(sum)) {
                    throw new IllegalArgumentException("Ошибка: Вы ввели недопустимую купюру. Доступны только 20, 50, 100, 200, 500 и 1000.");
                }

                setAmount(amount + sum);
                isIllegalValue = false;
                System.out.println("Пополнение наличными успешно завершено. Баланс увеличен на " + sum + " единиц.");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите числовое значение для суммы.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean isValidNote(int note) {
        for (int allowedNote : allowedNotes) {
            if (allowedNote == note) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void getInfo() {
        System.out.println("Вы выбрали оплату наличными");
        System.out.println("Ваш баланс составляет " + getAmount());
    }
}

