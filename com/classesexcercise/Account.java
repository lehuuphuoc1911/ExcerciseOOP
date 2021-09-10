package com.classesexcercise;

import java.util.Arrays;

public class Account {

    private int id;
    public Transaction[] transactions;
    private int lastTransactionIndex;
    public Account(int accId){
        id = accId;
    }
    public void sendMoneyToAccount(Account accountTo, double moneyAmount) {
        if (accountTo == null) {
            return;
        }
        if (moneyAmount <= 0) {
            return;
        }
        Transaction transaction = new Transaction(this, accountTo, moneyAmount,
                StandardAccountOperations.MONEY_TRANSFER_SEND);
        addTransaction(transaction);
        accountTo.receiveMoney(this, moneyAmount);
    }

    private void receiveMoney(Account accountFrom, double moneyAmount) {
        if (accountFrom == null) {
            return;
        }
        if (moneyAmount <= 0) {
            return;
        }
        Transaction transaction = new Transaction(accountFrom, this, moneyAmount,
                StandardAccountOperations.MONEY_TRANSFER_RECEIVE);
        addTransaction(transaction);
    }

    private void addTransaction(Transaction transaction) {
        if (transaction == null) {
            return;
        }
        if(this.transactions == null){
            transactions = new Transaction[1];
            transactions[0]=transaction;
            return;
        }
        Transaction[] tr = new  Transaction[this.transactions.length+1];
        for (int i = 0; i< transactions.length;i++){
            tr[i]=transactions[i];
        }
        tr[transactions.length]= transaction;
        this.transactions = tr;
    }

    public void withdrawMoney(double moneyAmount) {
        Transaction transaction = new Transaction(this, null, moneyAmount,
                StandardAccountOperations.WITHDRAW);
        addTransaction(transaction);
    }

    public Transaction[] getTransactions() {
        int trlen = 0;
        for (int i = 0; i < this.transactions.length; i++) {
            if (this.transactions[i] != null) {
                trlen++;
            }
        }
        Transaction[] result = new  Transaction[trlen];
        int j=0;
        for (int i = 0; i < this.transactions.length; i++) {
            if (this.transactions[i] != null) {
                result[j]= this.transactions[i];
                j++;
            }
        }
        return result;
    }



    public static class Transaction {
        private Account accountFrom;
        private Account accountTo;
        private double amountMoney;
        private StandardAccountOperations operation;
        public  Transaction (Account accountFrom_, Account accountTo_, double amountMoney_, StandardAccountOperations std){
            this.accountFrom = accountFrom_;
            this.accountTo = accountTo_;
            this.amountMoney = amountMoney_;
            this.operation = std;
        }

        public int getAccountFromID() {
            if(accountFrom==null){
                return 0;
            }
            return accountFrom.id;
        }
        public int getAccountToID() {
            if(accountTo==null){
                return 0;
            }
            return accountTo.id;
        }

        @Override
        public String toString() {
            return "[accountFrom=" + this.getAccountFromID() + ", accountTo=" + this.getAccountToID()
                    + ", moneyAmount=" + this.amountMoney + ", operation=" + this.operation + "]";
        }

    }

    @Override
    public String toString() {
        String s = "Account{" +
                "id=" + id +
                ",\n transactions= \n";
        for (int i=0;i<transactions.length ;i++){
            s+= (i+1) + " " + this.transactions[i].toString() +"\n";
        }
        return s;
    }
}

/*
import java.util.Arrays;
        import java.util.Objects;

public class Account {

    private static final int DEFAULT_TRANSACTIONS_AMOUNT = 10;

    private int id;
    private Transaction[] transactions;
    private int lastTransactionIndex;

    {
        transactions = new Transaction[DEFAULT_TRANSACTIONS_AMOUNT];
    }

    public Account(int id) {
        this.id = id;
    }

    public void sendMoneyToAccount(Account accountTo, double moneyAmount) {
        if (accountTo == null) {
            return;
        }
        if (moneyAmount <= 0) {
            return;
        }
        Transaction transaction = new Transaction(this, accountTo, moneyAmount,
                StandardAccountOperations.MONEY_TRANSFER_SEND);
        addTransaction(transaction);
        accountTo.receiveMoney(this, moneyAmount);
    }

    private void receiveMoney(Account accountFrom, double moneyAmount) {
        if (accountFrom == null) {
            return;
        }
        if (moneyAmount <= 0) {
            return;
        }
        Transaction transaction = new Transaction(accountFrom, this, moneyAmount,
                StandardAccountOperations.MONEY_TRANSFER_RECEIVE);
        addTransaction(transaction);
    }

    private void addTransaction(Transaction transaction) {
        if (transaction == null) {
            return;
        }
        if (transactions.length <= lastTransactionIndex) {
            transactions = Arrays.copyOf(transactions, transactions.length << 1);
        }
        transactions[lastTransactionIndex++] = transaction;
    }

    public void withdrawMoney(double moneyAmount) {
        Transaction transaction = new Transaction(this, null, moneyAmount,
                StandardAccountOperations.WITHDRAW);
        addTransaction(transaction);
    }

    @Override
    public String toString() {
        return "Account ID: " + this.id;
    }

    public Transaction[] getTransactions() {
        int nonNullTransactionsAmount = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                nonNullTransactionsAmount++;
            }
        }

        Transaction[] filteredTransactions = new Transaction[nonNullTransactionsAmount];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                filteredTransactions[index++] = transaction;
            }
        }
        return filteredTransactions;

    }

    // ===== STREAM API Solution
//	public Transaction[] getTransactions() {
//		return Arrays.stream(transactions)
//				.filter(Objects::nonNull)
//				.toArray(Transaction[]::new);
//	}

    public static class Transaction {

        private Account accountFrom;
        private Account accountTo;
        private double moneyAmount;
        private StandardAccountOperations operation;

        private Transaction(Account accountFrom, Account accountTo, double moneyAmount,
                            StandardAccountOperations moneyTransferOperation) {
            this.accountFrom = accountFrom;
            this.accountTo = accountTo;
            this.moneyAmount = moneyAmount;
            this.operation = moneyTransferOperation;
        }

        public Account getAccountFrom() {
            return accountFrom;
        }

        public void setAccountFrom(Account accountFrom) {
            this.accountFrom = accountFrom;
        }

        public Account getAccountTo() {
            return accountTo;
        }

        public void setAccountTo(Account accountTo) {
            this.accountTo = accountTo;
        }

        public double getMoneyAmount() {
            return moneyAmount;
        }

        public void setMoneyAmount(double moneyAmount) {
            this.moneyAmount = moneyAmount;
        }

        public StandardAccountOperations getOperation() {
            return operation;
        }

        public void setOperation(StandardAccountOperations operation) {
            this.operation = operation;
        }

        @Override
        public String toString() {
            return "Transaction [accountFrom=" + accountFrom + ", accountTo=" + accountTo
                    + ", moneyAmount=" + moneyAmount + ", operation=" + operation + "]";
        }

    }
}*/
