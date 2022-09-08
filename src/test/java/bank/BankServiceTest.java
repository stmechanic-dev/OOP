package bank;

import org.junit.Assert;
import org.junit.Test;

public class BankServiceTest {

    @Test
    public void whenAddNewUserAndFindByPassport() {
        BankService bankService = new BankService();
        User user = new User("Ilya", "12345");
        bankService.addUser(user.getName(), user.getPassport());
        User user2 = new User("Nikita", "98745");
        bankService.addUser(user2.getName(), user2.getPassport());
        User user3 = new User("Julia", "94564");
        bankService.addUser(user3.getName(), user3.getPassport());

        Assert.assertEquals(user, bankService.findByPassport(user.getPassport()));
    }

    @Test
    public void whenAddAccountAndFindByRequisite() {
        BankService bankService = new BankService();
        User user1 = new User("Ilya", "12345");
        Account account1 = new Account("5678", 100000);
        bankService.addUser(user1.getName(), user1.getPassport());
        bankService.addAccount(user1, account1.getRequisite(), account1.getBalance());
        User user2 = new User("Nikita", "98745");
        Account account2 = new Account("0954", 200000);
        bankService.addUser(user2.getName(), user2.getPassport());
        bankService.addAccount(user2, account2.getRequisite(), account2.getBalance());
        User user3 = new User("Julia", "94564");
        Account account3 = new Account("9054", 300000);
        bankService.addUser(user3.getName(), user3.getPassport());
        bankService.addAccount(user3, account3.getRequisite(), account3.getBalance());

        Assert.assertEquals(account3, bankService.findByRequisite(user3.getPassport(), "9054"));
    }

    @Test
    public void whenDeleteAccountByRequisite() {
        BankService bankService = new BankService();
        User user1 = new User("Ilya", "12345");
        Account account1 = new Account("5678", 100000);
        Account account1_1 = new Account("9253", 10000);
        bankService.addUser(user1.getName(), user1.getPassport());
        bankService.addAccount(user1, account1.getRequisite(), account1.getBalance());
        bankService.addAccount(user1, account1_1.getRequisite(), account1_1.getBalance());
        User user2 = new User("Nikita", "98745");
        Account account2 = new Account("0954", 200000);
        bankService.addUser(user2.getName(), user2.getPassport());
        bankService.addAccount(user2, account2.getRequisite(), account2.getBalance());
        User user3 = new User("Julia", "94564");
        Account account3 = new Account("9054", 0);
        bankService.addUser(user3.getName(), user3.getPassport());
        bankService.addAccount(user3, account3.getRequisite(), account3.getBalance());

        bankService.deleteAccountByRequisite(user1.getPassport(), account1.getRequisite());

        Assert.assertEquals(110000, bankService.findByRequisite(user1.getPassport(),
                account1_1.getRequisite()).getBalance(), 0.01);
        Assert.assertFalse(bankService.deleteAccountByRequisite(user2.getPassport(),
                account2.getRequisite()));
        Assert.assertTrue(bankService.deleteAccountByRequisite(user3.getPassport(), account3.getRequisite()));
    }

    @Test
    public void whenTransferMoney() {
        BankService bankService = new BankService();
        User user1 = new User("Ilya", "12345");
        Account account1 = new Account("5678", 100000);
        bankService.addUser(user1.getName(), user1.getPassport());
        bankService.addAccount(user1, account1.getRequisite(), account1.getBalance());
        User user2 = new User("Nikita", "98745");
        Account account2 = new Account("0954", 200000);
        bankService.addUser(user2.getName(), user2.getPassport());
        bankService.addAccount(user2, account2.getRequisite(), account2.getBalance());
        User user3 = new User("Julia", "94564");
        Account account3 = new Account("9054", 300000);
        bankService.addUser(user3.getName(), user3.getPassport());
        bankService.addAccount(user3, account3.getRequisite(), account3.getBalance());

        bankService.transferMoney(user3.getPassport(), account3.getRequisite(),
                                    user1.getPassport(), account1.getRequisite(), 50000);

        Assert.assertEquals(150000, bankService.findByRequisite(user1.getPassport(),
                account1.getRequisite()).getBalance(), 0.01);
    }

    @Test
    public void whenWithdrawMoney() {
        BankService bankService = new BankService();
        User user1 = new User("Ilya", "12345");
        Account account1 = new Account("5678", 100000);
        bankService.addUser(user1.getName(), user1.getPassport());
        bankService.addAccount(user1, account1.getRequisite(), account1.getBalance());
        User user2 = new User("Nikita", "98745");
        Account account2 = new Account("0954", 200000);
        bankService.addUser(user2.getName(), user2.getPassport());
        bankService.addAccount(user2, account2.getRequisite(), account2.getBalance());
        User user3 = new User("Julia", "94564");
        Account account3 = new Account("9054", 300000);
        bankService.addUser(user3.getName(), user3.getPassport());
        bankService.addAccount(user3, account3.getRequisite(), account3.getBalance());

        bankService.withDrawBalanceFromAccount(user1.getPassport(), account1.getRequisite(), 20000);

        Assert.assertEquals(80000,
                                    bankService.findByRequisite(user1.getPassport(),
                                            account1.getRequisite()).getBalance(), 0.01);
    }

    @Test
    public void whenAddBallanceToAccaunt() {
        BankService bankService = new BankService();
        User user1 = new User("Ilya", "12345");
        Account account1 = new Account("5678", 100000);
        bankService.addUser(user1.getName(), user1.getPassport());
        bankService.addAccount(user1, account1.getRequisite(), account1.getBalance());
        User user2 = new User("Nikita", "98745");
        Account account2 = new Account("0954", 200000);
        bankService.addUser(user2.getName(), user2.getPassport());
        bankService.addAccount(user2, account2.getRequisite(), account2.getBalance());
        User user3 = new User("Julia", "94564");
        Account account3 = new Account("9054", 300000);
        bankService.addUser(user3.getName(), user3.getPassport());
        bankService.addAccount(user3, account3.getRequisite(), account3.getBalance());

        bankService.addBalanceToAccount(user1.getPassport(), account1.getRequisite(), 50000);

        Assert.assertEquals(150000, bankService.findByRequisite(user1.getPassport(),
                account1.getRequisite()).getBalance(), 0.01);
    }
}