 private void saveAccountsToCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("accounts.csv", false))) {
            writer.println("AccountNumber,HolderName,Balance,Services"); // header
            for (Account acc : bank.getAllAccounts()) {
                writer.println(acc.getAccountNumber() + "," +
                               acc.getHolderName() + "," +
                               acc.getBalance() + "," +
                               String.join(";", acc.getServices()));
            }
            outputArea.append("💾 Accounts saved to accounts.csv\n");
        } catch (IOException e) {
            outputArea.append("❌ Error saving accounts: " + e.getMessage() + "\n");
        }
    }
