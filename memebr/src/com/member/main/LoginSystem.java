package com.member.main;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import com.member.controller.CreateAdmin;

	class LoginSystem {
	    private boolean a = true;
	    private int passwordAttempts = 0;
	    private final int MAX_ATTEMPTS = 3;
	    private Scanner scanner = new Scanner(System.in);
	    private CreateAdmin members = new CreateAdmin();

	    public void run() {
	        while (a) {
	            System.out.println("************************************");
	            System.out.println("\t\t로그인");
	            System.out.println("************************************");
	            System.out.println("아이디를 입력하세요 : ");
	            String name = scanner.nextLine();

	            if (!name.equals("admin")) {
	                System.out.println("아이디가 일치하지 않습니다.");
	            } else {
	                System.out.println("비밀번호를 입력하세요 : ");
	                String pwd = scanner.nextLine();

	                if (pwd.equals("admin")) {
	                    System.out.println("로그인 성공!");
	                    a = false; // 로그인 성공 시 루프 종료
	                } else {
	                    System.out.println("로그인 실패: 비밀번호가 일치하지 않습니다.");
	                    passwordAttempts++; // 비밀번호 입력 실패 횟수 증가

	                    if (passwordAttempts >= MAX_ATTEMPTS) {
	                        System.out.println("비밀번호 입력 실패 횟수가 " + MAX_ATTEMPTS + "회를 초과하여 프로그램을 종료합니다.");
	                        System.exit(0); // 프로그램 종료
	                    }
	                }
	            }
	        }
	     }
	   }