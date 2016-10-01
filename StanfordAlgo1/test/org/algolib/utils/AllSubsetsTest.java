package org.algolib.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class AllSubsetsTest {

	
	private long after;
	private long before;

	@Rule 
	public TestName name = new TestName();
	
	@Before
	public void before(){
		System.out.println();
		System.out.println(name.getMethodName());
		this.before = System.currentTimeMillis();
	}	
	
	@After
	public void after(){
		this.after = System.currentTimeMillis();
		System.out.println("Time Taken in seconds = "+ (this.after - this.before) / 1000D);
	}

	public <T> void printAllSubSets(List<Set<T>> subsetList){
		if(subsetList== null ) return;
		System.out.println("Total number of susbets = "+subsetList.size());
		Collections.sort(subsetList, new Comparator<Set<T>>() {

			@Override
			public int compare(Set<T> o1, Set<T> o2) {
				if(o1==null && o2==null)
					return 0;
				
				if(o1==null )
					return -1;
				
				if(o2==null)
					return 1;
				
				
				return o1.size() - o2.size();
			}
		});
		
		for(Set<T> subset : subsetList){
			System.out.println(subset);
		}
	}
	
	@Test
	public void testNullSetForSubSets(){
		Set<String> nullSet = null; 
		List<Set<String>> allSubSets = AllSubsets.getAllSubSets(nullSet);
		printAllSubSets(allSubSets);
	}
	
	
	@Test
	public void testEmptySetForSubSets(){
		Set<String> emptySet = new HashSet<String>(); 
		List<Set<String>> allSubSets = AllSubsets.getAllSubSets(emptySet);
		printAllSubSets(allSubSets);
	}
	
	@Test
	public void test1ElementSetForSubSets(){
		Set<String> testSet = new HashSet<String>();
		testSet.add("A");
		List<Set<String>> allSubSets = AllSubsets.getAllSubSets(testSet);
		printAllSubSets(allSubSets);
	}
	
	@Test
	public void test2ElementSetForSubSets(){
		Set<String> testSet = new HashSet<String>();
		testSet.add("A");
		testSet.add("B");
		List<Set<String>> allSubSets = AllSubsets.getAllSubSets(testSet);
		printAllSubSets(allSubSets);
	}
	
	@Test
	public void test3ElementSetForSubSets(){
		Set<String> testSet = new HashSet<String>();
		testSet.add("A");
		testSet.add("B");
		testSet.add("C");
		List<Set<String>> allSubSets = AllSubsets.getAllSubSets(testSet);
		printAllSubSets(allSubSets);
	}
	
	@Test
	public void test4ElementSetForSubSets(){
		Set<String> testSet = new HashSet<String>();
		testSet.add("A");
		testSet.add("B");
		testSet.add("C");
		testSet.add("D");
		List<Set<String>> allSubSets = AllSubsets.getAllSubSets(testSet);
		printAllSubSets(allSubSets);
	}
	
	@Test
	public void test5ElementSetForSubSets(){
		Set<String> testSet = new HashSet<String>();
		testSet.add("A");
		testSet.add("B");
		testSet.add("C");
		testSet.add("D");
		testSet.add("E");
		List<Set<String>> allSubSets = AllSubsets.getAllSubSets(testSet);
		printAllSubSets(allSubSets);
	}
}
