/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
/*
以下是關於 Queue 類別的設計與描述：
設計一個名為 Queue 的類別來存儲整數。與棧類似，隊列也包含元素。不同的是，棧中的元素是按照「後進先出」方式檢索的，
而隊列中的元素是按照「先進先出」方式檢索的。該類別包含：
1. 一個 `int[]` 資料欄位名為 `elements`，用於存儲隊列中的整數值。
2. 一個名為 `size` 的資料欄位，用於存儲隊列中的元素數量。
3. 一個構造函數，創建一個具有默認容量 8 的 Queue 物件。
4. `enqueue(int v)` 方法，將 `v` 加入到隊列中。
5. `dequeue()` 方法，移除並返回隊列中的第一個元素。
6. `empty()` 方法，當隊列為空時返回 true。
7. `getSize()` 方法，返回隊列中的元素數量。
繪製該類別的 UML 圖。實現該類別，初始數組大小設置為 8。一旦元素數量超過數組的大小，數組大小應該加倍。當從數組中移除一個元素後，
需將數組中所有元素向左移動一個位置。撰寫一個測試程式，將從 1 到 20 的 20 個數字加入到隊列中，然後移除這些數字並顯示出來。
*/

/*
+-------------------+
|      Queue        |
+-------------------+
| - elements: int[] |
| - size: int       |
+-------------------+
| + Queue()         |
| + enqueue(v: int) |
| + dequeue(): int  |
| + empty(): boolean|
| + getSize(): int  |
+-------------------+

UML 圖解釋：
- 類別名稱: Queue
- 屬性:
  - `elements`：用來存儲整數元素的數組
  - `size`：存儲隊列中元素的數量
- 方法:
  - `Queue()`：構造函數，創建初始容量為 8 的隊列
  - `enqueue(int v)`：將值 `v` 加入隊列
  - `dequeue()`：移除並返回隊列中的第一個元素
  - `empty()`：檢查隊列是否為空
  - `getSize()`：返回隊列中元素的數量
這個 UML 圖表明了 Queue 類別的結構和方法，展示了如何操作隊列的基本功能。
*/

public class Queue {
    private int[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 8;

    // 建構子，建立一個預設容量為8的Queue物件
    public Queue() {
        elements = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    // 將元素加入到隊列中
    public void enqueue(int v) {
        if (size >= elements.length) {
            // 如果陣列已滿，擴展容量為原來的兩倍
            int[] newElements = new int[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size] = v;
        size++;
    }

    // 從隊列中移除並返回最前面的元素，並將後面的元素往左移動
    public int dequeue() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int removedElement = elements[0];
        for (int i = 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = 0; // 清空最後一個位置
        return removedElement;
    }

    // 判斷隊列是否為空
    public boolean empty() {
        return size == 0;
    }

    // 返回隊列中的元素個數
    public int getSize() {
        return size;
    }

    // 測試程式，將1到20的數字加入到隊列並移除顯示
    public static void main(String[] args) {
        Queue queue = new Queue();

        // 將1到20加入隊列
        for (int i = 1; i <= 20; i++) {
            queue.enqueue(i);
        }

        // 移除並顯示所有的元素
        while (!queue.empty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}

