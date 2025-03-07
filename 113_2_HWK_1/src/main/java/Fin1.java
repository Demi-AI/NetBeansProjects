/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Fin1 {
    static int[] num = new int[3]; // 分子陣列
    static int denom; // 分母
    static int[] result = new int[2]; // 結果陣列 (刻意設成 2 來產生例外)

    public static void inputData() throws ArrayIndexOutOfBoundsException, ArithmeticException, InputMismatchException {
        Scanner input = new Scanner(System.in);

        // 取得使用者輸入的三個整數
        System.out.println("Pls enter three integers:");
        for (int i = 0; i < 3; i++) {
            num[i] = input.nextInt(); // 可能拋出 InputMismatchException
        }

        // 取得分母
        System.out.println("Pls enter denom:");
        denom = input.nextInt(); // 可能拋出 InputMismatchException
        
        // 計算 num 中每個元素除以 denom 的結果，存入 result 陣列
        for (int i = 0; i < 3; i++) {
            result[i] = num[i] / denom; // 可能拋出 ArithmeticException 和 ArrayIndexOutOfBoundsException
        }

        input.close();
    }

    public static void main(String[] args) {
        try {
            inputData();
        } catch (ArithmeticException e) {
            System.out.println("main:ArithmeticException");
        } catch (InputMismatchException e) {
            System.out.println("main:InputMismatchException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("main:ArrayIndexOutOfBoundsException");
        } finally {
            System.out.println("main_finally");
        }
    }
}
