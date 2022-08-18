package com.nikhil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	private static ArrayList<Album> albums = new ArrayList<Album>();

	public static void main(String[] args) {
		
		Album album = new Album("Album1", "ArijitSingh");
		
		album.addSong("Darmiya", 4.5);
		album.addSong("Tu hai kaha", 3.5);
		album.addSong("Bekhayali", 4.5);
		albums.add(album);
		
		
		album = new Album("Album2", "AtifAslam");
		album.addSong("Main rahu", 4.5);
		album.addSong("Khaboke parinde", 3.5);
		album.addSong("khamoshiya", 4.5);
		albums.add(album);
		
		LinkedList<Song> playList_1 = new LinkedList<Song>();
		albums.get(0).addToPlayList("Darmiya", playList_1);
		albums.get(0).addToPlayList("Bekhayali", playList_1);
		albums.get(1).addToPlayList("Mai rahu", playList_1);
		albums.get(1).addToPlayList("Khamoshiya", playList_1);
		

		play(playList_1);
	}
	
	private static void play(LinkedList<Song> playList) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forword = true;
		ListIterator<Song> listIterator = playList.listIterator();
		
		if(playList.size() == 0) {
			System.out.println("This playlist have no somg");
		}else {
			System.out.println("Now playing "+listIterator.next().toString());
			printMenu();
		}
		
		while(!quit) {
			int action = sc.nextInt();
			sc.nextLine();
			
			switch(action) {
			
			case 0:
				System.out.println("playList complete");
				quit= true;
				break;
				
			case 1:
				if(!forword) {
					if(listIterator.hasNext()) {
						listIterator.next();
					}
					forword = true;
				}
				if(listIterator.hasNext()) {
					System.out.println("Now playing"+listIterator.next().toString());
				}else {
					System.out.println("no song avilable, reached to the end of the list");
					forword = false;
				}
				break;
				
			case 2:
				if(forword) {
					if(listIterator.hasPrevious()) {
						listIterator.previous();
					}
					forword = false;
				}
				if(listIterator.hasPrevious()) {
					System.out.println("Now playing "+ listIterator.previous().toString());
				}else {
					System.out.println("we are the first song");
					forword = false;
				}
				break;
				
			case 3:
				if(forword) {
					if(listIterator.hasPrevious()) {
						System.out.println("Now playing"+listIterator.previous().toString());
						forword = false;
					}else {
						System.out.println("we are at the start of the list");
					}
				}else {
					if(listIterator.hasNext()) {
						System.out.println("now playing"+listIterator.next().toString());
						forword = true;
					}else {
						System.out.println("we have reached to the end of list");
					}
				}
				break;
				
			case 4:
				printList(playList);
				break;
				
			case 5:
				printMenu();
				break;
				
			case 6:
				if(playList.size() >0) {
					listIterator.remove();
					if(listIterator.hasNext()) {
						System.out.println("Now playing "+listIterator.next().toString());
						forword = true;
					}
					else {
						if(listIterator.hasPrevious())
							System.out.println("Now playing "+listIterator.previous().toString());
					}
				}
				
			}
		}
	}
	
	private static void printMenu(){
		System.out.println("Available option\n press");
		System.out.println("0- to quit\n"+
						   "1- to play next song\n"+
						   "2- to play the previous song\n"+
						   "3- to replay the current song\n"+
						   "4- list of all songs\n"+
						   "5- print all available option\n"+
						   "6-delete current song");
	}
	
	private static void printList(LinkedList<Song> playList) {
		Iterator<Song> iterator = playList.iterator();
		System.out.println("____________________");
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("____________________");
	}
}
