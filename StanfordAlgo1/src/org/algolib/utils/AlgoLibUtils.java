package org.algolib.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.algolib.beans.Node;

public class AlgoLibUtils {

	public List<Node<Integer>> getListGraphFromEdges(String fileName)
			throws FileNotFoundException {
				return new ArrayList<Node<Integer>>(getMapGraphFromEdges(fileName).values());
	}
	
	
	public HashMap<Integer,Node<Integer>> getMapGraphFromEdges(String fileName)
			throws FileNotFoundException {
		HashMap<Integer, Node<Integer>> intToNodeMap = new HashMap<Integer, Node<Integer>>();

		Scanner sc = new Scanner(new File(fileName));
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] nodes = line.split("[\\s\\t]");
			Integer from = Integer.parseInt(nodes[0]);
			Integer to = Integer.parseInt(nodes[1]);

			Node<Integer> fromNode;
			Node<Integer> toNode;

			if (intToNodeMap.containsKey(from)) {
				fromNode = intToNodeMap.get(from);
			} else {
				fromNode = new Node<Integer>(from);
				intToNodeMap.put(from, fromNode);
			}

			if (intToNodeMap.containsKey(to)) {
				toNode = intToNodeMap.get(to);
			} else {
				toNode = new Node<Integer>(to);
				intToNodeMap.put(to, toNode);
			}

			fromNode.getForwardNodes().add(toNode);

		}
		return intToNodeMap;
	}

}
