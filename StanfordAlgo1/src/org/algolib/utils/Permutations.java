package org.algolib.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	
	public static List<List<String>>  permute(List<String> items){
		List<List<String>> permutations = new ArrayList<List<String>>();
		if (items == null)
			return permutations;
		
		for(String item: items){
			addItemToPermutations(item,permutations);
		}
		return permutations;
	}

	private static void addItemToPermutations(String item, List<List<String>> permutations) {
		List<List<String>> newPerms = new ArrayList<List<String>>();
		if(permutations.size()==0){
			permutations.add(Arrays.asList(item));
			return;
		}
		
		for(List<String> oldPerm : permutations){
			int gaps = oldPerm.size()+1;
			for(int i=0;i<gaps;i++){
				ArrayList<String> newPerm = new ArrayList<String>(oldPerm);
				if(i==gaps-1){
					newPerm.add(item);
				}else{
					newPerm.add(i,item);
				}
				newPerms.add(newPerm);
			}
		}
		permutations.clear();
		permutations.addAll(newPerms);
	}
	
	
	
}
