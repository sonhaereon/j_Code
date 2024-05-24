package com.member.main;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import com.member.controller.CreateAdmin;
import com.member.controller.Member;
import java.io.FileReader;

public class MemberRegistrationSystem {
    private static final int MAX_MEMBERS = 100;
    private Member[] members;
    private int memberCount;

    public MemberRegistrationSystem() {
        members = new Member[MAX_MEMBERS];
        memberCount = 0;
    }

	public void run() {
		Scanner s = new Scanner(System.in); 
		boolean quitProgram = false;
        
		while (!quitProgram) {
		System.out.println("************************************");
        System.out.println("\t 회원 관리 프로그램");
        System.out.println("************************************");
        System.out.print("1.고객 정보 등록하기");
        System.out.println("  2.고객 정보 조회하기");
        System.out.print("3.고객 정보 수정하기");
        System.out.println("  4.고객 정보 삭제하기");
        System.out.print("5.고객 정보 목록보기");
        System.out.println("  6.고객 정보 파일출력");
        System.out.println("7.종료");
        System.out.println("************************************");
    	
    	System.out.println("메뉴 번호를 선택해주세요: ");
       	String menu = s.nextLine();
		
        switch (menu) {
        case "1":
            registerMember();
            break;
        case "2":
        	Memberfound();
            break;
        case "3":
            // 수정 기능 실행
            break;
        case "4":
            // 삭제 기능 실행
            break;
        case "5":
            // 목록 보기 기능 실행
            break;
        case "6":
            // 파일 출력 기능 실행
            break;
        case "7":
            quitProgram = true;
            break;
        default:
            System.out.println("잘못된 메뉴 번호입니다. 다시 입력해주세요.");
        }
	  }
   }
	private void registerMember() {
		try {
   			File file = new File("member.txt");
   			if(!file.exists())
			file.createNewFile();
		
   			FileWriter fw = new FileWriter(file);
   			Scanner input = new Scanner(System.in);
		
   			boolean quit = false;
   			while(!quit) {
			
			System.out.println("등록하실 회원의 이름을 입력하세요: ");
			String name = input.next();
			fw.write("아이디 :" + name );
		
			
			System.out.print("등록하실 회원의 연락처를 입력하세요: ");
			String phone = input.next();
			fw.write("연락처 : " + phone);
			
			System.out.print("등록하실 회원의 주소를 입력하세요: ");
			String addr = input.next();
			fw.write("주소 : " + addr );
			
			System.out.print("등록하실 회원의 비밀번호를 입력하세요: ");
			String pwd = input.next();
			fw.write("비밀번호 : " + pwd );
			quit = true;
			System.out.println("등록 완료되었습니다.");
		}
		fw.close();
		
	} catch(Exception e) {
		e.getMessage();
	 }
	}
	private void Memberfound() {
	    try {
	        Scanner input = new Scanner(System.in);
	        System.out.println("조회할 회원 이름을 입력해주세요: ");
	        String name = input.next();
	        System.out.println(name + "님의 고객 정보:\n");

	        File file = new File("member.txt");
	        if (!file.exists()) {
	            System.out.println("등록된 회원 정보가 없습니다.");
	            return;
	        }

	        Scanner fileScanner = new Scanner(file);
	        boolean found = false;

	        while (fileScanner.hasNextLine()) {
	            String line = fileScanner.nextLine();
	           
	            if (line.contains("아이디 :" + name)) {
	                System.out.println(line);
	                found = true;
	                break;
	            }
	        }

	        if (!found) {
	            System.out.println("해당하는 회원 정보가 없습니다.");
	        }

	        fileScanner.close();
	    } catch (Exception e) {
	        System.out.println("오류 발생: " + e.getMessage());
	    }
	}
	
}
