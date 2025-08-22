class OnlineBankingAppGUI extends JFrame {
    private Bank bank = new Bank();
    private JTextArea outputArea;

    public OnlineBankingAppGUI() {
        setTitle("🏦 Peoples Bank - Online Banking");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        
        JLabel header = new JLabel("Welcome to Peoples Bank Online Services", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 22));
        header.setOpaque(true);
        header.setBackground(new Color(0, 51, 102));
        header.setForeground(Color.WHITE);
        add(header, BorderLayout.NORTH);

       
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

       
        JPanel panel = new JPanel(new GridLayout(2, 5, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(230, 240, 255));

        String[] buttonLabels = {"Create Account", "Deposit", "Withdraw", "Balance",
                                 "List Accounts", "Loan", "Insurance", "Save Accounts", "Exit"};
        for (String label : buttonLabels) {
            JButton btn = new JButton(label);
            btn.setFont(new Font("Arial", Font.BOLD, 13));
            btn.setBackground(new Color(0, 102, 204));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            panel.add(btn);


            switch (label) {
                case "Create Account" -> btn.addActionListener(e -> createAccount());
                case "Deposit" -> btn.addActionListener(e -> deposit());
                case "Withdraw" -> btn.addActionListener(e -> withdraw());
                case "Balance" -> btn.addActionListener(e -> checkBalance());
                case "List Accounts" -> btn.addActionListener(e -> listAccounts());
                case "Loan" -> btn.addActionListener(e -> applyLoan());
                case "Insurance" -> btn.addActionListener(e -> buyInsurance());
                case "Save Accounts" -> btn.addActionListener(e -> saveAccountsToCSV());
                case "Exit" -> btn.addActionListener(e -> System.exit(0));
            }
        }

        add(panel, BorderLayout.SOUTH);

        // Load accounts from CSV at startup
        loadAccountsFromCSV();
    }
