import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);                                      // Создаем объект класса сканер со ссылкой s (можно использовать любую не заданную переменную за место in)
        System.out.print("Введи операцию: ");
        String stroka = s.nextLine();                                                   //считываем введенную строку с клавиатуры (переменная а считываеться как строка)
        Calcyliator Calcyliator = new Calcyliator();
        Calcyliator.calc(stroka);                                                      //Выполняем метод calc и передаем ссылку stroka
    }
}
class Calcyliator {                                                              //создаем клас Калькулятор
    public static void calc(String stroka) {                                                  //Создаем Метод/Функцию calc и принемаем ссылку с параметром stroka
        //создаем массив римских цифр от I до С (10*10=100  Х*Х=С)
        String[] rimskii = {"В римском исчислении нет 0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
                "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII",
                "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV",
                "XXXVI", "XXXVII", "XXXVIII", "XXXVIX", "XL", "XLI", "XLII", "XLIII", "XLVI", "XLV", "XLVI", "XLVII",
                "XLVIII", "XLVIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LVIX", "LX", "LXI", "LXII",
                "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI",
                "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String[] cifra = {"1", "2", "3", "4", "5"};                              //создаем массив для проверки арефмитического оператора по соотношению индекса  +,-,*,/
        int DlinaStroki = stroka.length();                                       //узнаем длину строки
        char[] o = stroka.toCharArray();                                         //Создаем массив '1'...'10', '+'...'/', 'I'...'X' в порядке веденной строки
        char simvol_1 = o[0];                                                    //узнаем 1 символ
        int simvol_end=DlinaStroki-1;
        if (!(simvol_1 == 'V' || simvol_1 == 'X' || simvol_1 == 'I'||simvol_1 == '1'| simvol_1 == '2'| simvol_1 == '3'|simvol_1 == '4'|simvol_1 == '5'|simvol_1 == '6'|simvol_1 == '7'|simvol_1 == '8'|simvol_1 == '9')) {              //исключение на числа от I до X
            try {
                throw new IOException();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (simvol_1 == '-') {                                                   // создаем условие на длину строки от 3 до 9 символов I+I до VIII+VIII
            try {
                throw new IOException();
            } catch (IOException e) {
                throw new RuntimeException(e);                                   //исключение отрицательных чисел
            }
        }
        if (simvol_1 == '1'| simvol_1 == '2'| simvol_1 == '3'|simvol_1 == '4'|simvol_1 == '5'|simvol_1 == '6'|simvol_1 == '7'|simvol_1 == '8'|simvol_1 == '9') {
            if (!(DlinaStroki >= 3 && DlinaStroki <= 5)) {                       // создаем условие на длину строки от 3 до 5 символов 1+1 до 10+10
                try {
                    throw new IOException();
                } catch (IOException e) {
                    throw new RuntimeException(e);                               //исключение длины чтобы небыло 1 и т.д.
                }
            }
            if (!(simvol_1 == '1' | simvol_1 == '2' | simvol_1 == '3' | simvol_1 == '4' | simvol_1 == '5' | simvol_1 == 6 | simvol_1 == '7' | simvol_1 == '8' | simvol_1 == '9')) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            String znak_1 = stroka.replace("1", "");             //избовились от всех цифр (оставлся массив с символами операции  +,-,*,/)
            String znak_2 = znak_1.replace("2", "");
            String znak_3 = znak_2.replace("3", "");
            String znak_4 = znak_3.replace("4", "");
            String znak_5 = znak_4.replace("5", "");
            String znak_6 = znak_5.replace("6", "");
            String znak_7 = znak_6.replace("7", "");
            String znak_8 = znak_7.replace("8", "");
            String znak_9 = znak_8.replace("9", "");
            String znak_10 = znak_9.replace("0", "");
            char[] X = znak_10.toCharArray();                                    //присваиваем переменной Х символ  +,-,*,/)
            char x = X[0];                                                       //берем первый символ операций +,-,*,/
            int Start = stroka.indexOf(x);                                       //узнаем первый индекс по операции +,-,*,/
            int End = stroka.lastIndexOf(x);                                     //узнаем последний индекс по операции +,-,*,/
            String proverka_Start = cifra[Start];                                //присваиваем по первому найденному индексу - симол строки из масива cifra
            String proverka_End = cifra[End];                                    //присваиваем по последниму найденномуу индексу - симол строки из масива cifra
            if (proverka_Start != proverka_End) {                                //сверяем результаты если индекс совпадает то была использована одна операция +,-,*,/
                try {
                    throw new IOException();
                } catch (IOException e) {                                        //исключаем повторность знаков операции +,-,*,/
                    throw new RuntimeException(e);
                }
            }
            String znak1 = stroka.replace("+", " ");
            String znak2 = znak1.replace("-", " ");
            String znak3 = znak2.replace("/", " ");
            String znak = znak3.replace("*", " ");
            //находим число1 и число2
            String stroka1 = znak.split(" ")[0];                           //разбиваем числа по индексу
            String stroka2 = znak.split(" ")[1];
            int num1 = 0;
            int num2 = 0;
            num1 = Integer.parseInt(stroka1);                                   //находим 1 число
            num2 = Integer.parseInt(stroka2);                                   //находим 2 число;
            if (!(num1 >= 1 && num1 <= 10 && num2 >= 1 && num2 <= 10)) {        //задаем условия для первого числа от 1 до 10 и для второго числа от 1 до 10
                try {
                    throw new IOException();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (x == '+') {
                int result = num1 + num2;                                      //выполняем операцию +
                System.out.print(result);
            } else if (x == '-') {
                int result = num1 - num2;                                     //выполняем операцию -
                System.out.print(result);
            } else if (x == '*') {
                int result = num1 * num2;                                     //выполняем операцию *
                System.out.print(result);
            } else if (x == '/') {
                int result = num1 / num2;                                     //выполняем операцию /
                System.out.print(result);
            }
            if (simvol_1 == 'V' || simvol_1 == 'X' || simvol_1 == 'I') {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        //Римский калькулятор

        else if (simvol_1 == 'I' | simvol_1 == 'X' | simvol_1 == 'V') {
            if (!(DlinaStroki >= 3 && DlinaStroki <= 9)) {                     // создаем условие на длину строки от 3 до 9 символов I+I до VIII+VIII
                try {throw new IOException();}
                catch (IOException e) {throw new RuntimeException(e);}}
            String str1 = stroka.replace("1", "");            //Убераем арабские символы
            String str2 = str1.replace("2", "");
            String str3 = str2.replace("3", "");
            String str4 = str3.replace("4", "");
            String str5 = str4.replace("5", "");
            String str6 = str5.replace("6", "");
            String str7 = str6.replace("7", "");
            String str8 = str7.replace("8", "");
            String str9 = str8.replace("9", "");
            String stroka_11 = str9.replace("0", "");          // Произвели замену римских цифр на арабские I на 1 и т.д.
            String str11 = stroka_11.replace("IX", "9");
            String str22 = str11.replace("X", "10");
            String str33 = str22.replace("VIII", "8");
            String str44 = str33.replace("VII", "7");
            String str55 = str44.replace("VI", "6");
            String str66 = str55.replace("IV", "4");
            String str77 = str66.replace("V", "5");
            String str88 = str77.replace("III", "3");
            String str99 = str88.replace("II", "2");
            String str10 = str99.replace("I", "1");
            String znak__1 = stroka_11.replace("I", "");             //вытаскиваем арефмитический символ +,-,*,/
            String znak__2 = znak__1.replace("V", "");
            String znak__10 = znak__2.replace("X", "");
            char[] XX = znak__10.toCharArray();                                     //переводим операцию  +,-,*,/ в масив
            char xx = XX[0];                                                        //переводим масив в символ для последующего сравнения в if
            int Start1 = stroka.indexOf(xx);                                       //узнаем первый индекс по операции +,-,*,/
            int End1 = stroka.lastIndexOf(xx);                                     //узнаем последний индекс по операции +,-,*,/
            String proverka_Start1 = cifra[Start1];                                //присваиваем по первому найденному индексу - симол строки из масива cifra
            String proverka_End1 = cifra[End1];                                    //присваиваем по последниму найденномуу индексу - симол строки из масива cifra
            if (proverka_Start1 != proverka_End1) {                                //сверяем результаты если индекс совпадает то была использована одна операция +,-,*,/
                try {throw new IOException();}
                catch (IOException e) {throw new RuntimeException(e);}}                                           //исключаем повтор символов операции +,-,*,/
            String znak11 = str10.replace("+", " ");
            String znak22 = znak11.replace("-", " ");
            String znak33 = znak22.replace("/", " ");
            String znak00 = znak33.replace("*", " ");               //заменили операцию +,-,*,/ на пробелы
            try {
                String stroka_1 = znak00.split(" ")[0];
                String stroka_2 = znak00.split(" ")[1];                            //разобрали числа по индексу
                int num_1 = Integer.parseInt(stroka_1);                                  //находим 1 число
                int num_2 = Integer.parseInt(stroka_2);                                  //находим 2 число
                if (num_1 > 0 && num_1 <= 10 && num_2 <= 10 && num_2 > 0) {
                    if (xx == '+') {
                        int result = num_1 + num_2;
                        String rimskii_slojenie = rimskii[result];                       //задаем переменную объекта массива rimskii по индексу
                        System.out.println(rimskii_slojenie);                            // вывыодим результат
                    } else if (xx == '-') {
                        try {
                            throw new IOException();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (xx == '*') {
                        int result = num_1 * num_2;
                        String rimskii_ymnojit = rimskii[result];                        //задаем переменную объекта массива rimskii по индексу
                        System.out.println(rimskii_ymnojit);                             // вывыодим результат
                    } else if (xx == '/') {
                        int result = num_1 / num_2;
                        String rimskii_delit = rimskii[result];                          //задаем переменную объекта массива rimskii по индексу
                        System.out.println(rimskii_delit);                               // вывыодим результат
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e){  throw  new RuntimeException(e);}     //исключаем I+1 и т.д. (убераем ошибку пустоты (null) т.к. 1-10 перевели в '')
        }
    }
}
