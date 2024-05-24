package com.member.main;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        LoginSystem loginSystem = new LoginSystem();
        loginSystem.run();
        MemberRegistrationSystem memberRegisterationSystem = new MemberRegistrationSystem();
        memberRegisterationSystem.run();
    }
}
