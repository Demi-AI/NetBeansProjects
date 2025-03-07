/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
/*
以下是關於修改 Course 類別的設計描述，翻譯成中文：
請按照如下方式修改 Course 類別：
1. 修改 `getStudents()` 方法，使其返回一個長度與課程中的學生數量相同的數組。（提示：創建一個新數組並將學生複製到該數組中。）
2. 在 Listing 10.6 中，數組大小是固定的。請修改 `addStudent()` 方法，使其在沒有足夠空間添加更多學生時，自動增加數組大小。這可以通過創建一個更大的數組並將當前數組的內容複製到新數組中來實現。
3. 實現 `dropStudent()` 方法，允許從課程中移除一個學生。
4. 添加一個名為 `clear()` 的新方法，用於移除課程中的所有學生。
這些修改將提升 Course 類別的功能，使其更靈活地處理學生數據。
*/
/*
+----------------------------+
|           Course            |
+----------------------------+
| - courseName: String        |
| - students: String[]        |
| - numberOfStudents: int     |
+----------------------------+
| + Course(courseName: String)|
| + getCourseName(): String   |
| + addStudent(student: String): void |
| + getStudents(): String[]   |
| + getNumberOfStudents(): int|
| + dropStudent(student: String): void |
| + clear(): void             |
+----------------------------+

UML 圖解釋：
- 類別名稱: Course
- 屬性:
  - `courseName`: 課程名稱
  - `students`: 學生名單（以數組形式存儲學生的名稱）
  - `numberOfStudents`: 學生人數
- 方法:
  - `Course(courseName)`: 帶參數的構造函數，創建課程並指定名稱
  - `getCourseName()`: 返回課程名稱
  - `addStudent(student)`: 添加學生到課程
  - `getStudents()`: 返回學生列表（長度與實際學生數量一致）
  - `getNumberOfStudents()`: 返回課程中的學生數量
  - `dropStudent(student)`: 從課程中移除學生
  - `clear()`: 清除所有學生
這個 UML 圖展示了 Course 類別的基本結構和行為，便於了解課程與學生的管理。
*/

public class Course {
    private String courseName; // 課程名稱
    private String[] students; // 學生名單
    private int numberOfStudents; // 學生人數
    private static final int INITIAL_CAPACITY = 10; // 初始陣列容量

    // 建構子，根據指定的課程名稱來建立課程
    public Course(String courseName) {
        this.courseName = courseName;
        students = new String[INITIAL_CAPACITY]; // 初始化學生陣列
        numberOfStudents = 0; // 初始化學生數量
    }

    // 返回課程名稱
    public String getCourseName() {
        return courseName;
    }

    // 將學生加入課程
    public void addStudent(String student) {
        if (numberOfStudents >= students.length) {
            // 如果學生數超過陣列容量，擴展陣列大小
            String[] newStudents = new String[students.length * 2]; // 陣列大小加倍
            System.arraycopy(students, 0, newStudents, 0, students.length); // 複製現有學生至新陣列
            students = newStudents; // 替換為新陣列
        }
        students[numberOfStudents] = student; // 將學生加入陣列
        numberOfStudents++; // 增加學生數量
    }

    // 返回課程中的學生名單
    public String[] getStudents() {
        String[] actualStudents = new String[numberOfStudents]; // 創建新陣列來存放實際學生
        System.arraycopy(students, 0, actualStudents, 0, numberOfStudents); // 複製學生資料
        return actualStudents; // 返回實際學生的陣列
    }

    // 返回課程中的學生數量
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    // 從課程中移除學生
    public void dropStudent(String student) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                // 找到要移除的學生後，將後面的學生向前移動一個位置
                for (int j = i; j < numberOfStudents - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[numberOfStudents - 1] = null; // 將最後一個位置設為空
                numberOfStudents--; // 減少學生數量
                break;
            }
        }
    }

    // 清除所有學生
    public void clear() {
        students = new String[INITIAL_CAPACITY]; // 重置學生陣列
        numberOfStudents = 0; // 重置學生數量
    }

    public static void main(String[] args) {
        Course course = new Course("Java 程式設計"); // 建立課程對象

        // 添加學生
        course.addStudent("Alice");
        course.addStudent("Bob");
        course.addStudent("Charlie");

        // 列出所有學生
        System.out.println("課程名稱: " + course.getCourseName());
        System.out.println("學生名單:");
        for (String student : course.getStudents()) {
            System.out.println(student);
        }

        // 移除學生
        System.out.println("\n移除學生 Bob");
        course.dropStudent("Bob");

        // 列出移除後的學生名單
        System.out.println("學生名單:");
        for (String student : course.getStudents()) {
            System.out.println(student);
        }

        // 清除所有學生
        System.out.println("\n清除所有學生");
        course.clear();

        // 列出清除後的學生名單
        System.out.println("學生名單:");
        for (String student : course.getStudents()) {
            System.out.println(student);
        }
    }
}
