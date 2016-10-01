package algo.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GreedyWeigtedCompletion1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("p2/jobs.txt"));
		//Scanner sc = new Scanner(new File("p2/jobst2.txt"));
		//Scanner sc = new Scanner(new File("p2/jobstest.txt"));
		List<Job> jobList = new ArrayList<Job>();
		int count=0;
		int jobCount = sc.nextInt();
		while(sc.hasNext()){
			int weight = sc.nextInt();
			int  length = sc.nextInt();
			
			count++;
			jobList.add(new Job(count,weight,length));
			
		}
		List<Job> jList = new ArrayList<Job>(jobList);
		//Collections.copy(jList, jobList);
		
		//Collections.sort(jobList);
		//Collections.reverse(jobList);
		//System.out.println(jobList);
		
		System.out.println("Calling heap sort...");
		System.out.println();
		jList = heapSort(jList, jobCount);
		Collections.reverse(jList);
		//System.out.println(jList);
		System.out.println("Sum Of weighted Completion time by difference="+sumOfWeightedCompletionTimes(jList));
		System.out.println("Total job count "+count);
		
		Comparator<Job> comparator = new Comparator<GreedyWeigtedCompletion1.Job>() {
			
			@Override
			public int compare(Job o1, Job o2) {
				if(o1.wByl<o2.wByl)
					return -1;
				else if(o1.wByl>o2.wByl)
					return 1;
				else return 0;
			}
		};
		
		Collections.sort(jobList,comparator);
		Collections.reverse(jobList);
		//System.out.println("Job list sorted by ratio="+jobList);
		System.out.println("Sum Of weighted Completion time by ratio="+sumOfWeightedCompletionTimes(jobList));
		sc.close();
		
		
 	}
	
	static class Job implements Comparable<Job>{

		int id;
		int weight;
		int length;
		int wDiffl;
		double wByl;
		
		public Job(int count, int weight, int length) {
			this.id = count;
			this.length = length;
			this.weight = weight;
			this.wDiffl = this.weight - this.length;
			this.wByl = (double)this.weight / this.length;
		}

		@Override
		public int compareTo(Job job) {
			
			if(this==job)
				return 0;
			if(this.weight==job.weight && this.length==job.length)
				return 0;
			if(this.wDiffl==job.wDiffl)
				return this.weight-job.weight;
			else
				return this.wDiffl-job.wDiffl;
		}
		
		
		/*@Override
		public int compareTo(Job job) {
			return this.weight-job.weight;
		}*/

		@Override
		public String toString() {
			return "Job [wByl="+wByl+"]";
		}
		
		/*@Override
		public String toString() {
			return "Job [weight=" + weight + "]";
		}*/

	}
	
	
	static class Heap{
		List<Job> jobList;
		int size;
		Heap(List<Job> jobList, int size){
			this.jobList = new ArrayList<GreedyWeigtedCompletion1.Job>(jobList);
			this.size=size;
		}
	}
	
	public static void bottomUp(Heap h,int size){
		for (int i = (size - 2) / 2; i >= 0; i--) {
			createHeapAtPosition(h,size,i);
		}
	}

	public static long sumOfWeightedCompletionTimes(List<Job> jList){
		long completionTime=0;
		long wct=0;
		for(Job j : jList){
			completionTime+=j.length;
			wct += j.weight*completionTime;
		}
		return wct;
	}
	
	private static void createHeapAtPosition(Heap h, int size, int i) {
		int lc = 2*i+1;
		int rc = 2*i+2;
		int max = i;
		List<Job> a = h.jobList;
		if (lc < size && a.get(max).compareTo(a.get(lc)) < 0) {
			max = lc;
		}
		if (rc < size && a.get(max).compareTo(a.get(rc)) < 0) {
			max = rc;
		}
		if(max!=i){
			swap(a,max,i);
			createHeapAtPosition(h, size, max);
		}
		
		
	}

	private static void swap(List<Job> a, int max, int i) {
		Job temp = a.get(i);
		a.set(i, a.get(max));
		a.set(max, temp);
	}
	
	private static List<Job> heapSort(List<Job> jList, int size){
		Heap h = new Heap(jList, size);
		
		List<Job> a= h.jobList;
		bottomUp(h, size);

		for (int i = size - 1; i > 0; i--) {
			swap(a, 0, i);
			createHeapAtPosition(h, i, 0);
		}
		return h.jobList;
	}
	
	
}
