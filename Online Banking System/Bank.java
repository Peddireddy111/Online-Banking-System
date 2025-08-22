class Bank {
    private Map<String, Account> accounts = new HashMap<>();

    public void createAccount(String accountNumber, String holderName, double initialBalance) {
        accounts.put(accountNumber, new Account(accountNumber, holderName, initialBalance));
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public Collection<Account> getAllAccounts() {
        return accounts.values();
    }
}
