/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
/*
9.7 Account 類別
設計一個名為 `Account` 的類別，該類別包含：
- 一個名為 `id` 的私有 `int` 型資料欄位，表示帳戶的 ID（預設為 0）。
- 一個名為 `balance` 的私有 `double` 型資料欄位，表示帳戶的餘額（預設為 0）。
- 一個名為 `annualInterestRate` 的私有 `double` 型資料欄位，表示當前的年利率（預設為 0）。假設所有帳戶的利率相同。
- 一個名為 `dateCreated` 的私有 `Date` 型資料欄位，表示帳戶創建的日期。
- 一個無參數的建構子，建立一個預設帳戶。
- 一個帶有指定 `id` 和初始餘額的建構子，建立一個帳戶。
- 包含 `id`、`balance` 和 `annualInterestRate` 的存取器（getter）和修改器（setter）方法。
- 包含 `dateCreated` 的存取器方法。
- 一個名為 `getMonthlyInterestRate()` 的方法，返回月利率。
- 一個名為 `getMonthlyInterest()` 的方法，返回每月利息。
- 一個名為 `withdraw()` 的方法，從帳戶中提取指定金額。
- 一個名為 `deposit()` 的方法，向帳戶存入指定金額。
繪製此類別的 UML 圖，然後實現該類別。
（提示：`getMonthlyInterest()` 方法應返回每月利息，而不是利率。每月利息是 `balance * monthlyInterestRate`，
其中 `monthlyInterestRate` 是 `annualInterestRate / 12`。
注意，`annualInterestRate` 是百分比，例如 4.5%，需要除以 100。）
編寫一個測試程式，該程式創建一個帳戶對象，帳戶 ID 為 1122，餘額為 20,000 美元，年利率為 4.5%。
使用 `withdraw()` 方法提取 2,500 美元，使用 `deposit()` 方法存入 3,000 美元，並打印餘額、每月利息以及該帳戶的創建日期。

11.3 Account 的子類別
在程式設計練習 9.7 中，`Account` 類別被定義用來模擬一個銀行帳戶。
帳戶具有帳戶號碼、餘額、年利率和創建日期等屬性，並且有存款和提款的方法。
為 `Account` 創建兩個子類別，分別為支票帳戶（CheckingAccount）和儲蓄帳戶（SavingsAccount）。
支票帳戶有透支限額，而儲蓄帳戶不能透支。
編寫一個測試程式，該程式創建 `Account`、`SavingsAccount` 和 `CheckingAccount` 的對象，並調用它們的 `toString()` 方法。
*/

/*
----------------------------
Account
----------------------------
- id: int
- balance: double
- annualInterestRate: double
- dateCreated: Date
----------------------------
+ Account()
+ Account(id: int, balance: double)
+ getId(): int
+ setId(id: int): void
+ getBalance(): double
+ setBalance(balance: double): void
+ getAnnualInterestRate(): double
+ setAnnualInterestRate(annualInterestRate: double): void
+ getDateCreated(): Date
+ getMonthlyInterestRate(): double
+ getMonthlyInterest(): double
+ withdraw(amount: double): void
+ deposit(amount: double): void
----------------------------
Account 類別的 UML 圖解釋：
- 類別名稱：`Account`，這是一個表示銀行帳戶的類別。
1. 屬性：
  - `id: int`：帳戶的唯一識別碼，預設為 0。
  - `balance: double`：帳戶的餘額，預設為 0。
  - `annualInterestRate: double`：年利率，預設為 0，表示所有帳戶都有相同的年利率。
  - `dateCreated: Date`：帳戶創建的日期，通常使用 Java 的 `Date` 類別表示。
2. 建構子：
  - `Account()`：無參數的建構子，創建一個默認的帳戶。
  - `Account(id: int, balance: double)`：帶參數的建構子，創建一個具有指定 ID 和餘額的帳戶。
3. 方法：
  - `getId()`: 返回帳戶 ID。
  - `setId(id: int)`: 設定帳戶 ID。
  - `getBalance()`: 返回帳戶餘額。
  - `setBalance(balance: double)`: 設定帳戶餘額。
  - `getAnnualInterestRate()`: 返回年利率。
  - `setAnnualInterestRate(annualInterestRate: double)`: 設定年利率。
  - `getDateCreated()`: 返回創建日期。
  - `getMonthlyInterestRate()`: 計算並返回月利率（年利率除以 12）。
  - `getMonthlyInterest()`: 計算並返回每月的利息（餘額乘以月利率）。
  - `withdraw(amount: double)`: 從帳戶中提款指定金額。
  - `deposit(amount: double)`: 向帳戶中存入指定金額。

----------------------------
SavingsAccount
----------------------------
- accountType: String
----------------------------
+ SavingsAccount(id: int, balance: double)
+ toString(): String
----------------------------
SavingsAccount 類別的 UML 圖解釋：
- 類別名稱：`SavingsAccount`，這是一個表示儲蓄帳戶的類別，繼承自 `Account` 類別。
1. 屬性：
  - `accountType: String`：帳戶類型，這裡可以用來標識為「儲蓄帳戶」。
2. 建構子：
  - `SavingsAccount(id: int, balance: double)`：帶參數的建構子，用來創建具有指定 ID 和餘額的儲蓄帳戶，並調用父類別 `Account` 的建構子。
3. 方法：
  - `toString()`: 覆寫的 `toString()` 方法，返回儲蓄帳戶的詳細資訊，以字符串的形式表示。

----------------------------
CheckingAccount
----------------------------
- overdraftLimit: double
----------------------------
+ CheckingAccount(id: int, balance: double, overdraftLimit: double)
+ withdraw(amount: double): void
+ toString(): String
----------------------------
CheckingAccount 類別的 UML 圖解釋：
- 類別名稱：`CheckingAccount`，這是一個表示支票帳戶的類別，繼承自 `Account` 類別。
1. 屬性：
  - `overdraftLimit: double`：透支限額，表示帳戶可允許的最大透支金額。
2. 建構子：
  - `CheckingAccount(id: int, balance: double, overdraftLimit: double)`：帶參數的建構子，用來創建具有指定 ID、餘額和透支限額的支票帳戶，並調用父類別 `Account` 的建構子。
3. 方法：
  - `withdraw(amount: double)`: 覆寫的 `withdraw` 方法，允許從帳戶中提款，如果提款金額超過餘額則允許使用透支限額。
  - `toString()`: 覆寫的 `toString()` 方法，返回支票帳戶的詳細資訊，以字符串的形式表示。
這些 UML 圖的設計清楚地顯示了每個類別的屬性和方法，並強調了類別之間的繼承關係。
*/
import java.util.Date;

public class BankAccount {

    // 主帳戶類別
    public static class Account {
        private int id; // 帳戶 ID
        private double balance; // 帳戶餘額
        private double annualInterestRate; // 年利率
        private Date dateCreated; // 創建日期

        // 無參數建構子
        public Account() {
            this.id = 0;
            this.balance = 0;
            this.annualInterestRate = 0;
            this.dateCreated = new Date(); // 當前日期
        }

        // 帶參數的建構子
        public Account(int id, double balance) {
            this.id = id;
            this.balance = balance;
            this.annualInterestRate = 0;
            this.dateCreated = new Date(); // 當前日期
        }

        // 取得帳戶 ID
        public int getId() {
            return id;
        }

        // 設定帳戶 ID
        public void setId(int id) {
            this.id = id;
        }

        // 取得帳戶餘額
        public double getBalance() {
            return balance;
        }

        // 設定帳戶餘額
        public void setBalance(double balance) {
            this.balance = balance;
        }

        // 取得年利率
        public double getAnnualInterestRate() {
            return annualInterestRate;
        }

        // 設定年利率
        public void setAnnualInterestRate(double annualInterestRate) {
            this.annualInterestRate = annualInterestRate;
        }

        // 取得創建日期
        public Date getDateCreated() {
            return dateCreated;
        }

        // 計算月利率
        public double getMonthlyInterestRate() {
            return annualInterestRate / 12 / 100; // 將年利率轉換為月利率
        }

        // 計算每月利息
        public double getMonthlyInterest() {
            return balance * getMonthlyInterestRate(); // 每月利息
        }

        // 提款方法
        public void withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount; // 減少餘額
            } else {
                System.out.println("餘額不足，無法提款。");
            }
        }

        // 存款方法
        public void deposit(double amount) {
            balance += amount; // 增加餘額
        }
    }

    // 儲蓄帳戶類別
    public static class SavingsAccount extends Account {
        // 儲蓄帳戶建構子
        public SavingsAccount(int id, double balance) {
            super(id, balance); // 呼叫父類別的建構子
        }

        // 轉換為字串
        @Override
        public String toString() {
            return "儲蓄帳戶: ID = " + getId() + ", 餘額 = " + getBalance() +
                   ", 年利率 = " + getAnnualInterestRate() + "%, 創建日期 = " + getDateCreated();
        }
    }

    // 支票帳戶類別
    public static class CheckingAccount extends Account {
        private double overdraftLimit; // 透支限額

        // 支票帳戶建構子
        public CheckingAccount(int id, double balance, double overdraftLimit) {
            super(id, balance); // 呼叫父類別的建構子
            this.overdraftLimit = overdraftLimit; // 設定透支限額
        }

        // 覆寫提款方法
        @Override
        public void withdraw(double amount) {
            if (amount <= (getBalance() + overdraftLimit)) {
                setBalance(getBalance() - amount); // 更新餘額
            } else {
                System.out.println("超過透支限額，無法提款。");
            }
        }

        // 轉換為字串
        @Override
        public String toString() {
            return "支票帳戶: ID = " + getId() + ", 餘額 = " + getBalance() +
                   ", 透支限額 = " + overdraftLimit + ", 年利率 = " + getAnnualInterestRate() + "%, 創建日期 = " + getDateCreated();
        }
    }

    // 主程式
    public static void main(String[] args) {
        // 創建一個帳戶對象
        Account account = new Account(1122, 20000);
        account.setAnnualInterestRate(4.5); // 設定年利率

        // 提款和存款操作
        account.withdraw(2500);
        account.deposit(3000);

        // 輸出帳戶的資訊
        System.out.println("帳戶餘額: " + account.getBalance());
        System.out.println("每月利息: " + account.getMonthlyInterest());
        System.out.println("創建日期: " + account.getDateCreated());

        // 創建一個儲蓄帳戶和支票帳戶
        SavingsAccount savingsAccount = new SavingsAccount(1123, 15000);
        savingsAccount.setAnnualInterestRate(3.5);
        System.out.println(savingsAccount.toString());

        CheckingAccount checkingAccount = new CheckingAccount(1124, 5000, 1000);
        checkingAccount.setAnnualInterestRate(2.5);
        checkingAccount.withdraw(6000); // 測試透支
        System.out.println(checkingAccount.toString());
    }
}

