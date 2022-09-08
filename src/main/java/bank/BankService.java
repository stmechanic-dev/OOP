package bank;

import java.util.*;

public class BankService {

    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя, изначательно у пользователя 0 счетов
     */
    public boolean addUser(String name, String passport) {
        users.put(new User(name, passport), new ArrayList<>());
        return true;
    }

    /**
     * Метод добавляет счет пользователю
     */
    public boolean addAccount(User user, String requisite, double balance) {
        Account account = new Account(requisite, balance);
        List<Account> list = users.get(user);
        list.add(account);
        users.put(user, list);
        return true;
    }

    /**
     * Метод добавляет деньги на счет пользователя
     */
    public boolean addBalanceToAccount(String passport, String requisite, double balance) {
        Account account = findByRequisite(passport, requisite);
        account.setBalance(account.getBalance() + balance);

        return true;
    }

    /**
     * Метод должен снять деньги с аккаунта пользователя
     */
    public boolean withDrawBalanceFromAccount(String passport, String requisite, double balance) {
        Account account = findByRequisite(passport, requisite);
        double newBalance = account.getBalance() - balance;
        account.setBalance(newBalance);
        return true;
    }

    /**
     * Перевести деньги с счета на счет
     */
    public boolean transferMoney(String passportFrom, String requisiteFrom,
                                 String passportTo, String requisiteTo, double balance) {
        withDrawBalanceFromAccount(passportFrom, requisiteFrom, balance);
        Account account = findByRequisite(passportTo, requisiteTo);
        account.setBalance(account.getBalance() + balance);
        return true;
    }



    /**
     * Метод удаляет счет пользователя, если на счету лежат деньги, то их нужно перевести на рандомный
     * любой другой счет пользователя, если же такого счета не существует, то отменить операцию.
     * @param passport паспорт пользователя
     * @param requisite реквизиты пользователя
     */
    public boolean deleteAccountByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account account = findByRequisite(passport, requisite);
        if (account.getBalance() == 0) {
            users.remove(user);
            return true;
        } else if (account.getBalance() >= 0
                    && users.get(findByPassport(passport)).size() > 1) {
            for (Account accountOther : users.get(user)) {
                if (!accountOther.getRequisite().equals(requisite)) {
                    transferMoney(passport, requisite, passport,
                                    accountOther.getRequisite(),
                                    findByRequisite(passport, requisite).getBalance());

                    users.remove(accountOther);

                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Метод ищет счет по его реквизитам
     * @param passport паспорт
     * @param requisite реквизиты
     * @return счет пользователя
     */
    public Account findByRequisite(String passport, String requisite) {

        List<Account> accounts = users.get(findByPassport(passport));

        for (Account account : accounts) {
            if (account.getRequisite().equals(requisite)) {
                return account;
            }
        }

        return null;
    }

    /**
     * Возвращает пользователя по его паспорту
     * @param passport паспорт пользователя
     * @return пользователь
     */
    public User findByPassport(String passport) {
        for (Map.Entry<User, List<Account>> map : users.entrySet()) {
            if (map.getKey().getPassport().equals(passport)) {
                return map.getKey();
            }
        }
        return null;
    }
}
