package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two words (start and end), and a dictionary, find all shortest
 * transformation sequence(s) from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * Return [ ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ]
 * Note: All words have the same length. All words contain only lowercase
 * alphabetic characters.
 * 
 * @author shuchun.yang
 * 
 */
public class WordLadderIII {
	public static void main(String[] args) {
		WordLadderIII w = new WordLadderIII();
		/*
		 * String start = "hit"; String end = "cog"; HashSet<String> dict = new
		 * HashSet<String>(); dict.add("hot"); dict.add("dot"); dict.add("dog");
		 * dict.add("lot"); dict.add("log");
		 */

		String start = "nape";
		String end = "mild";
		List<String> list = Arrays.asList("dose", "ends", "dine", "jars",
				"prow", "soap", "guns", "hops", "cray", "hove", "ella", "hour",
				"lens", "jive", "wiry", "earl", "mara", "part", "flue", "putt",
				"rory", "bull", "york", "ruts", "lily", "vamp", "bask", "peer",
				"boat", "dens", "lyre", "jets", "wide", "rile", "boos", "down",
				"path", "onyx", "mows", "toke", "soto", "dork", "nape", "mans",
				"loin", "jots", "male", "sits", "minn", "sale", "pets", "hugo",
				"woke", "suds", "rugs", "vole", "warp", "mite", "pews", "lips",
				"pals", "nigh", "sulk", "vice", "clod", "iowa", "gibe", "shad",
				"carl", "huns", "coot", "sera", "mils", "rose", "orly", "ford",
				"void", "time", "eloy", "risk", "veep", "reps", "dolt", "hens",
				"tray", "melt", "rung", "rich", "saga", "lust", "yews", "rode",
				"many", "cods", "rape", "last", "tile", "nosy", "take", "nope",
				"toni", "bank", "jock", "jody", "diss", "nips", "bake", "lima",
				"wore", "kins", "cult", "hart", "wuss", "tale", "sing", "lake",
				"bogy", "wigs", "kari", "magi", "bass", "pent", "tost", "fops",
				"bags", "duns", "will", "tart", "drug", "gale", "mold", "disk",
				"spay", "hows", "naps", "puss", "gina", "kara", "zorn", "boll",
				"cams", "boas", "rave", "sets", "lego", "hays", "judy", "chap",
				"live", "bahs", "ohio", "nibs", "cuts", "pups", "data", "kate",
				"rump", "hews", "mary", "stow", "fang", "bolt", "rues", "mesh",
				"mice", "rise", "rant", "dune", "jell", "laws", "jove", "bode",
				"sung", "nils", "vila", "mode", "hued", "cell", "fies", "swat",
				"wags", "nate", "wist", "honk", "goth", "told", "oise", "wail",
				"tels", "sore", "hunk", "mate", "luke", "tore", "bond", "bast",
				"vows", "ripe", "fond", "benz", "firs", "zeds", "wary", "baas",
				"wins", "pair", "tags", "cost", "woes", "buns", "lend", "bops",
				"code", "eddy", "siva", "oops", "toed", "bale", "hutu", "jolt",
				"rife", "darn", "tape", "bold", "cope", "cake", "wisp", "vats",
				"wave", "hems", "bill", "cord", "pert", "type", "kroc", "ucla",
				"albs", "yoko", "silt", "pock", "drub", "puny", "fads", "mull",
				"pray", "mole", "talc", "east", "slay", "jamb", "mill", "dung",
				"jack", "lynx", "nome", "leos", "lade", "sana", "tike", "cali",
				"toge", "pled", "mile", "mass", "leon", "sloe", "lube", "kans",
				"cory", "burs", "race", "toss", "mild", "tops", "maze", "city",
				"sadr", "bays", "poet", "volt", "laze", "gold", "zuni", "shea",
				"gags", "fist", "ping", "pope", "cora", "yaks", "cosy", "foci",
				"plan", "colo", "hume", "yowl", "craw", "pied", "toga", "lobs",
				"love", "lode", "duds", "bled", "juts", "gabs", "fink", "rock",
				"pant", "wipe", "pele", "suez", "nina", "ring", "okra", "warm",
				"lyle", "gape", "bead", "lead", "jane", "oink", "ware", "zibo",
				"inns", "mope", "hang", "made", "fobs", "gamy", "fort", "peak",
				"gill", "dino", "dina", "tier");
		HashSet<String> dict = new HashSet<String>(list);
		long startT = System.currentTimeMillis();
		for (ArrayList<String> ladder : w.findLadders(start, end, dict)) {
			System.out.println(Arrays.toString(ladder.toArray()));
		}
		long endT = System.currentTimeMillis();
		System.out.println(endT - startT);
	}

	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {

		// Start typing your Java solution below
		// DO NOT write main() function

		HashMap<String, HashSet<String>> neighbours = new HashMap<String, HashSet<String>>();

		dict.add(start);
		dict.add(end);

		// init adjacent graph
		for (String str : dict) {
			calcNeighbours(neighbours, str, dict);
		}

		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		// BFS search queue
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(new Node(null, start, 1));

		// BFS level
		int previousLevel = 0;

		// mark which nodes have been visited, to break infinite loop
		HashMap<String, Integer> visited = new HashMap<String, Integer>();
		while (!queue.isEmpty()) {
			Node n = queue.pollFirst();
			if (end.equals(n.str)) {
				// fine one path, check its length, if longer than previous path
				// it's valid
				// otherwise all possible short path have been found, should
				// stop
				if (previousLevel == 0 || n.level == previousLevel) {
					previousLevel = n.level;
					findPath(n, result);
				} else {
					// all path with length *previousLevel* have been found
					break;
				}
			} else {
				HashSet<String> set = neighbours.get(n.str);

				if (set == null || set.isEmpty())
					continue;
				// note: I'm not using simple for(String s: set) here. This is
				// to avoid hashset's
				// current modification exception.
				ArrayList<String> toRemove = new ArrayList<String>();
				for (String s : set) {

					// if s has been visited before at a smaller level, there is
					// already a shorter
					// path from start to s thus we should ignore s so as to
					// break infinite loop; if
					// on the same level, we still need to put it into queue.
					if (visited.containsKey(s)) {
						Integer occurLevel = visited.get(s);
						if (n.level + 1 > occurLevel) {
							neighbours.get(s).remove(n.str);
							toRemove.add(s);
							continue;
						}
					}
					visited.put(s, n.level + 1);
					queue.add(new Node(n, s, n.level + 1));
					if (neighbours.containsKey(s))
						neighbours.get(s).remove(n.str);
				}
				for (String s : toRemove) {
					set.remove(s);
				}
			}
		}

		return result;
	}

	public void findPath(Node n, ArrayList<ArrayList<String>> result) {
		ArrayList<String> path = new ArrayList<String>();
		Node p = n;
		while (p != null) {
			path.add(0, p.str);
			p = p.parent;
		}
		result.add(path);
	}

	/*
	 * complexity: O(26*str.length*dict.size)=O(L*N)
	 */
	void calcNeighbours(HashMap<String, HashSet<String>> neighbours,
			String str, HashSet<String> dict) {
		int length = str.length();
		char[] chars = str.toCharArray();
		for (int i = 0; i < length; i++) {

			char old = chars[i];
			for (char c = 'a'; c <= 'z'; c++) {

				if (c == old)
					continue;
				chars[i] = c;
				String newstr = new String(chars);

				if (dict.contains(newstr)) {
					HashSet<String> set = neighbours.get(str);
					if (set != null) {
						set.add(newstr);
					} else {
						HashSet<String> newset = new HashSet<String>();
						newset.add(newstr);
						neighbours.put(str, newset);
					}
				}
			}
			chars[i] = old;
		}
	}

	private class Node {
		public Node parent;
		public String str;
		public int level;

		public Node(Node p, String s, int l) {
			parent = p;
			str = s;
			level = l;
		}

	}
}
