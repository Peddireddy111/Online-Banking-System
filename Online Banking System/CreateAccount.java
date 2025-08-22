 private void createAccount() {
        String accNo = JOptionPane.showInputDialog(this, "Enter Account Number:");
        String name = JOptionPane.showInputDialog(this, "Enter Holder Name:");
        String balStr = JOptionPane.showInputDialog(this, "Enter Initial Balance:");
        if (accNo != null && name != null && balStr != null) {
            double bal = Double.parseDouble(balStr);
            bank.createAccount(accNo, name, bal);
            outputArea.append("✅ Account created: " + accNo + "\n");
        }
    }

    private void deposit() {
        String accNo = JOptionPane.showInputDialog(this, "Enter Account Number:");
        String amtStr = JOptionPane.showInputDialog(this, "Enter Deposit Amount:");
        Account acc = bank.getAccount(accNo);
        if (acc != null) {
            acc.deposit(Double.parseDouble(amtStr));
            outputArea.append("✅ Deposit successful. New balance: ₹" + acc.getBalance() + "\n");
        } else {
            outputArea.append("❌ Account not found.\n");
        }
    }

    private void withdraw() {
        String accNo = JOptionPane.showInputDialog(this, "Enter Account Number:");
        String amtStr = JOptionPane.showInputDialog(this, "Enter Withdrawal Amount:");
        Account acc = bank.getAccount(accNo);
        if (acc != null) {
            if (acc.withdraw(Double.parseDouble(amtStr))) {
                outputArea.append("✅ Withdrawal successful. New balance: ₹" + acc.getBalance() + "\n");
            } else {
                outputArea.append("❌ Insufficient funds.\n");
            }
        } else {
            outputArea.append("❌ Account not found.\n");
        }
    }

    private void checkBalance() {
        String accNo = JOptionPane.showInputDialog(this, "Enter Account Number:");
        Account acc = bank.getAccount(accNo);
        if (acc != null) {
            outputArea.append("Balance of " + accNo + ": ₹" + acc.getBalance() + "\n");
        } else {
            outputArea.append("❌ Account not found.\n");
        }
    }

    private void listAccounts() {
        outputArea.append("---- All Accounts ----\n");
        for (Account acc : bank.getAllAccounts()) {
            outputArea.append(acc + "\n");
        }
    }
