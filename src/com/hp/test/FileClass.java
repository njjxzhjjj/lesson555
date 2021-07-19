package com.hp.test;

import java.io.File;
import java.util.Scanner;

public class FileClass {
    private  Scanner scanner;
    //用户输入路径
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入路径:");
        File file = new File(scanner.nextLine());
        delete(file);
    }
    //判断是否存在此文件
    public static void delete(File file) {
        //判断是否是文件夹
        if (file.exists()) {
            if (file.isDirectory()) {
                //判断文件夹里是否有文件
                File[] files = file.listFiles();
                //遍历文件夹里所有子文件
                if (files.length >= 1) {
                    //是文件，直接删除
                    for (File file1 : files) {
                        if (file1.isFile()) {
                            file1.delete();
                            System.out.println("成功删除：" + file1.getAbsolutePath());
                        } else {
                            //是文件夹，递归
                            delete(file1);
                        }
                    }
                    //file此时已经是空文件夹
                    file.delete();
                    System.out.println("成功删除：" + file.getAbsolutePath());
                } else {
                    //是空文件夹，直接删除
                    file.delete();
                    System.out.println("成功删除：" + file.getAbsolutePath());
                }
            } else {
                //是文件，直接删除
                file.delete();
                System.out.println("成功删除：" + file.getAbsolutePath());
            }
        } else System.out.println("文件不存在");
    }
}
