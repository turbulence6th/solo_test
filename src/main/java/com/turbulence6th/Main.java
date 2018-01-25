package com.turbulence6th;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Character[][] map = { 
				{ 'X', 'X', 'I', 'I', 'I', 'X', 'X' },
				{ 'X', 'X', 'I', 'I', 'I', 'X', 'X' },
				{ 'I', 'I', 'I', 'I', 'I', 'I', 'I' },
				{ 'I', 'I', 'I', '.', 'I', 'I', 'I' },
				{ 'I', 'I', 'I', 'I', 'I', 'I', 'I' },
				{ 'X', 'X', 'I', 'I', 'I', 'X', 'X' },
				{ 'X', 'X', 'I', 'I', 'I', 'X', 'X' }
		};
		
		solve(map, 32);
	}
	
	private static boolean solve(Character[][] map, int count) {
		
		if(count == 1 && map[3][3] == 'I') {
			return true;
		}
		
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				if(j + 2 < 7 && map[i][j] == 'I' && map[i][j + 1] == 'I' && map[i][j + 2] == '.') {
					Character[][] cloned = Arrays.stream(map).map(e -> e.clone())
							.toArray(Character[][]::new);
					cloned[i][j] = '.';
					cloned[i][j + 1] = '.';
					cloned[i][j + 2] = 'I';
					
					if(solve(cloned, count - 1)) {
						Arrays.stream(cloned).forEach(e -> {
							Arrays.stream(e).forEach(System.out::print);
							System.out.println();
						});
						
						System.out.println();
						
						return true;
					}
				}
				
				if(j - 2 >= 0 && map[i][j] == 'I' && map[i][j - 1] == 'I' && map[i][j - 2] == '.') {
					Character[][] cloned = Arrays.stream(map).map(e -> e.clone())
							.toArray(Character[][]::new);
					cloned[i][j] = '.';
					cloned[i][j - 1] = '.';
					cloned[i][j - 2] = 'I';
					
					if(solve(cloned, count - 1)) {
						Arrays.stream(cloned).forEach(e -> {
							Arrays.stream(e).forEach(System.out::print);
							System.out.println();
						});
						
						System.out.println();
						
						return true;
					}
				}
				
				if(i + 2 < 7 && map[i][j] == 'I' && map[i + 1][j] == 'I' && map[i + 2][j] == '.') {
					Character[][] cloned = Arrays.stream(map).map(e -> e.clone())
							.toArray(Character[][]::new);
					cloned[i][j] = '.';
					cloned[i + 1][j] = '.';
					cloned[i + 2][j] = 'I';
					
					if(solve(cloned, count - 1)) {
						Arrays.stream(cloned).forEach(e -> {
							Arrays.stream(e).forEach(System.out::print);
							System.out.println();
						});
						
						System.out.println();
						
						return true;
					}
				}
				
				if(i - 2 >= 0 && map[i][j] == 'I' && map[i - 1][j] == 'I' && map[i - 2][j] == '.') {
					Character[][] cloned = Arrays.stream(map).map(e -> e.clone())
							.toArray(Character[][]::new);
					cloned[i][j] = '.';
					cloned[i - 1][j] = '.';
					cloned[i - 2][j] = 'I';
					
					if(solve(cloned, count - 1)) {
						Arrays.stream(cloned).forEach(e -> {
							Arrays.stream(e).forEach(System.out::print);
							System.out.println();
						});
						
						System.out.println();
						
						return true;
					}
				}
				
			}
		}
		
		return false;
		
	}

}


