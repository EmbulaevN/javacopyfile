package ru.neoflex;

import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {

        // Выполнение побайтового копирования файла
        // Необходимо указать путь, откуда копировать файл srcFile и куда копировать desFile

        File srcFile = new File("D:\\neoflex\\javacopyfiles\\src\\files\\from\\1.exe");
        File desFile = new File("D:\\neoflex\\javacopyfiles\\src\\files\\to\\1_1.exe");

        long start = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(srcFile);
             FileOutputStream fos = new FileOutputStream(desFile)) {
            int read;
            while ((read = fis.read()) != -1) {
                fos.write(read);
            }
        }

        System.out.println("Время побайтового копирования файла, в милисекундах  = " + (System.nanoTime() - start) / 1000000);


        // Выполнение буферизированного копирования файла

        start = System.nanoTime();
        try (FileInputStream fis2 = new FileInputStream(srcFile);
             FileOutputStream fos2 = new FileOutputStream(desFile);
             BufferedInputStream bis = new BufferedInputStream(fis2);
             BufferedOutputStream bos = new BufferedOutputStream(fos2)) {

            byte[] bs = new byte[1024];
            int len = 0;
            while ((len = bis.read(bs, 0, 1024)) != -1) {
                bos.write(bs, 0, len);

            }
        }
        System.out.println("Время буферизированного копирования файла, в милисекундах = " + (System.nanoTime() - start) / 1000000);
    }
}
