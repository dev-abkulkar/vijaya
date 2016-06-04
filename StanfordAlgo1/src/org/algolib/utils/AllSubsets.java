package org.algolib.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllSubsets{

	
	public  static <T> List<Set<T>> getAllSubSets(Set<T> a){
		List<Set<T>> allSubsets = null;
		allSubsets = new ArrayList<Set<T>>();
		if(a ==null ){
			//do nothing. return the allSubSets as null
		}else {
			if(a.size() > 0){
				for(T e:a){
					addElementToSubsets(e,allSubsets);
				}
			}
		}
		allSubsets.add(new HashSet<T>());//empty set
		
		return allSubsets;
	}
	
	private static <T> void addElementToSubsets(T element, List<Set<T>> allSubSets){
		if(element == null) 
			return ;
		List<Set<T>> newSubsetList = new ArrayList<Set<T>>();
		
		for(Set<T> oldSet: allSubSets){
			Set<T> cloneSet = new HashSet<T>(oldSet);
			cloneSet.add(element);
			newSubsetList.add(cloneSet);
		}
		Set<T> elementSet = new HashSet<T>();
		elementSet.add(element);
		newSubsetList.add(elementSet);
		
		allSubSets.addAll(newSubsetList);
	}
}
	
