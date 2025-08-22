 private void loadAccountsFromCSV() {
        File file = new File("accounts.csv");
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String accNo = parts[0];
                    String name = parts[1];
                    double balance = Double.parseDouble(parts[2]);

                    bank.createAccount(accNo, name, balance);

                    if (parts.length == 4 && !parts[3].isEmpty()) {
                        for (String service : parts[3].split(";")) {
                            bank.getAccount(accNo).addService(service);
                        }
                    }
                }
            }
            outputArea.append("📂 Accounts loaded from accounts.csv\n");
        } catch (IOException e) {
            outputArea.append("❌ Error loading accounts: " + e.getMessage() + "\n");
        }
    }
}
