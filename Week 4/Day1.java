// Sort characters by frequency
// Time Complexity - O(nlogk), where k is the distinct characters. 
// Create a hashmap for frequency of each character.
// put these characters in a Max heap and then remove each character from the heap until it's empty.

class Solution {    
    public String frequencySort(String s) {                        
        Map<Character, Integer> map = new HashMap<>();                
        for(char c : s.toCharArray()) {                        
            map.put(c, map.getOrDefault(c,0) + 1);
        }        
                
        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> (map.get(b) - map.get(a)));
	    heap.addAll(map.keySet());
	    
	    StringBuilder sb = new StringBuilder();
	    while (!heap.isEmpty()) {
            char c = heap.poll();
            for (int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }    
        return sb.toString();
    }
}
