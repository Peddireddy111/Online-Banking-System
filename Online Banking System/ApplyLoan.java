 private void applyLoan() {
        String accNo = JOptionPane.showInputDialog(this, "Enter Account Number:");
        Account acc = bank.getAccount(accNo);
        if (acc != null) {
            String type = JOptionPane.showInputDialog(this, "Enter Loan Type (Home/Car/Personal):");
            String amtStr = JOptionPane.showInputDialog(this, "Enter Loan Amount:");
            String yearsStr = JOptionPane.showInputDialog(this, "Enter Duration (years):");

            double amount = Double.parseDouble(amtStr);
            int years = Integer.parseInt(yearsStr);
            double interestRate = 10; // 10% simple interest
            double total = amount + (amount * interestRate * years / 100);
            double emi = total / (years * 12);

            acc.addService("Loan(" + type + ")");
            outputArea.append("✅ Loan Approved for " + acc.getHolderName() +
                              "\nType: " + type + " | Amount: ₹" + amount +
                              "\nDuration: " + years + " years | EMI: ₹" + String.format("%.2f", emi) + "\n");
        } else {
            outputArea.append("❌ Account not found.\n");
        }
    }
