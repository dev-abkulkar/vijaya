package org.algolib.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Test;

public class PermutationsTest {

	
	@After
	public void after(){
		System.out.println();
	}
	
	@Test
	public void testPermutations3Elements() {
		List<String> items = Arrays.asList("a","b","c");
		List<List<String>> perms = Permutations.permute(items);
		System.out.println("Total Permutations = "+perms.size());
		for(List<String> perm : perms){
			System.out.println(Arrays.toString(perm.toArray()));
		}
	}
	
	@Test
	public void testPermutations1Element() {
		List<String> items = Arrays.asList("a");
		List<List<String>> perms = Permutations.permute(items);
		System.out.println("Total Permutations = "+perms.size());
		for(List<String> perm : perms){
			System.out.println(Arrays.toString(perm.toArray()));
		}
	}
	
	@Test
	public void testPermutations2Elements() {
		List<String> items = Arrays.asList("a","b");
		List<List<String>> perms = Permutations.permute(items);
		System.out.println("Total Permutations = "+perms.size());
		for(List<String> perm : perms){
			System.out.println(Arrays.toString(perm.toArray()));
		}
	}
	
	@Test
	public void testPermutations4Elements() {
		List<String> items = Arrays.asList("a","b","c","d");
		List<List<String>> perms = Permutations.permute(items);
		System.out.println("Total Permutations = "+perms.size());
		for(List<String> perm : perms){
			System.out.println(Arrays.toString(perm.toArray()));
		}
	}
	
	@Test
	public void testPermutations5Elements() {
		List<String> items = Arrays.asList("a","b","c","d","e");
		List<List<String>> perms = Permutations.permute(items);
		System.out.println("Total Permutations = "+perms.size());
		for(List<String> perm : perms){
			System.out.println(Arrays.toString(perm.toArray()));
		}
	}
}
