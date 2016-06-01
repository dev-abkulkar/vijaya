package algo.part2.w4apsp;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import algo.common.AlgoUtils;


public class FloydWarshall<T extends Comparable<T>> {
	private T[][] graph;
	private int nodes;
	private T INFINITY;
	private Class<?> clazz;
	
	public FloydWarshall(T[][] graph,T infinity, Class<?> clazz) {
		this.graph = graph;
		this.nodes = this.graph[0].length;
		this.clazz=clazz;
		this.INFINITY = infinity;
	}
	
	public T[][] calculateAPSP() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException  {
		@SuppressWarnings("unchecked")
		//	T[][] distances = (T[][])new Object[nodes][nodes];
		
		T[][] distances = (T[][])Array.newInstance(this.clazz, nodes, nodes);
		for(int i=0;i<nodes;i++){
			for(int j=0;j<nodes;j++){
				distances[i][j] = graph[i][j];
			}
		}
		
		for(int k=0;k<this.nodes;k++)
			for(int i=0;i<this.nodes;i++)
				for(int j=0;j<this.nodes;j++){
					T pathThruK = INFINITY;
					
					T ik = distances[i][k];
					T kj = distances[k][j];
					T ij = distances[i][j];
					boolean isIKinf = (ik).compareTo(INFINITY)==0;
					boolean isJKinf = (kj).compareTo(INFINITY)==0;
					
					if (!isIKinf  && !isJKinf){
						BigDecimal sumThruK  = new BigDecimal(ik.toString()).add(new BigDecimal(kj.toString()));
						pathThruK =  makeNumberFromString(sumThruK.toString(), this.clazz);
					}
					
					boolean isLesser = ((Comparable<T>)pathThruK).compareTo(ij) < 0;
					if (isLesser){
						distances[i][j] =  pathThruK;
						if(i==j && distances[i][j].compareTo(makeNumberFromString("0",this.clazz)) <0){
							System.out.println("Negative cycle found for "+i+"with distance "+distances[i][j]);
							return null;
						}
					}
				}
		return distances;
	}
	
	public T makeNumberFromString(String number , Class<?> clazz) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Constructor<?> constructor = clazz.getConstructor(String.class);
		Object newInstance = constructor.newInstance(number);
		return (T) newInstance;
	}
}
