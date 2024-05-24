package com.member.controller;

	public abstract class ManageMember {
		abstract 
		boolean login(String name, String pwd);
		abstract boolean createMember(String name, int phone);
		abstract boolean readMember(int num);
		abstract boolean updateMember(int num, String name, int phone);
		abstract boolean deleteMember(int num);
		abstract boolean fileMember();
		abstract boolean listMember();
		
	}


