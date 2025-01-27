// Question: LRU Cache... 
// Design a data structure that works like a LRU Cache. Here cap denotes the capacity of the cache and Q denotes the number of queries. Query can be of two types:
// PUT x y: sets the value of the key x with value y
// GET x: gets the key of x if present else returns -1.
// The LRUCache class has two methods get() and put() which are defined as follows.
// get(key): returns the value of the key if it already exists in the cache otherwise returns -1.
// put(key, value): if the key is already present, update its value. If not present, add the key-value pair to the cache. If the cache reaches its capacity it should remove the least recently used item before inserting the new item.
// In the constructor of the class the capacity of the cache should be initialized.
// Examples:

// Input: cap = 2, Q = 2, Queries = [["PUT", 1, 2], ["GET", 1]]
// Output: [2]
// Explanation: Cache Size = 2
// ["PUT", 1, 2] will insert the key-value pair (1, 2) in the cache,
// ["GET", 1] will print the value corresponding to Key 1, ie 2.

package Shreyam.GFG;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    static Map<Integer,Integer>cache;
    static int capacity;

    LRUCache(int cap){
        cache = new LinkedHashMap<>();
        capacity = cap;
    }

    public static int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
        return val;
    }

    public static void put(int key,int value){
        if(cache.containsKey(key)){
            cache.remove(key);
            cache.put(key, value);
            return;
        }
        if(cache.size() == capacity){
            int rem = -1;
            for(int i: cache.keySet()){
                rem =i;
                break;
            }
            cache.remove(rem);
        }cache.put(key, value);
    }
    public static void main(String[] args) {
        // <!-- >
    }
}
