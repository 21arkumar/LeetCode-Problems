class Bank {
    long[] bal;
    public Bank(long[] balance) {
        int n = balance.length;
        bal = new long[n];
        for(int i = 0; i < n; i++){
            bal[i] = balance[i];
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1 > bal.length || account2 > bal.length || bal[account1-1] < money){
            return false;
        }
        bal[account1-1] -= money;
        bal[account2-1] += money;

        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account > bal.length){
            return false;
        }
        bal[account-1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account > bal.length || bal[account-1] < money){
            return false;
        }
        bal[account-1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */