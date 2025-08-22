private void buyInsurance() {
        String accNo = JOptionPane.showInputDialog(this, "Enter Account Number:");
        Account acc = bank.getAccount(accNo);
        if (acc != null) {
            String type = JOptionPane.showInputDialog(this, "Enter Insurance Type (Life/Health/Vehicle):");
            acc.addService("Insurance(" + type + ")");
            outputArea.append("✅ Insurance Purchased: " + type + " for " + acc.getHolderName() + "\n");
        } else {
            outputArea.append("❌ Account not found.\n");
        }
    }
