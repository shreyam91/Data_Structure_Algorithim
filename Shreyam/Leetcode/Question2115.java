// Question: Find All Possible Recipes from Given Supplies... 

// You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients. The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i]. A recipe can also be an ingredient for other recipes, i.e., ingredients[i] may contain a string that is in recipes.
// You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.
// Return a list of all the recipes that you can create. You may return the answer in any order.
// Note that two recipes may contain each other in their ingredients.

// Example 1:
// Input: recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
// Output: ["bread"]

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Question2115 {
    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        Set<String> supply = new HashSet<>(Arrays.asList(supplies));

        for (int i = 0; i < recipes.length; i++) {
            indegree.put(recipes[i], 0);
            for (String ingredient : ingredients.get(i)) {
                if (!supply.contains(ingredient)) {
                    adj.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipes[i]);
                    indegree.put(recipes[i], indegree.getOrDefault(recipes[i], 0) + 1);
                }
            }
        }

        Queue<String> q = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                q.offer(entry.getKey());
            }
        }

        List<String> res = new ArrayList<>();
        while (!q.isEmpty()) {
            String currRecipe = q.poll();
            res.add(currRecipe);

            if (adj.containsKey(currRecipe)) {
                for (String nextRecipe : adj.get(currRecipe)) {
                    indegree.put(nextRecipe, indegree.get(nextRecipe) - 1);
                    if (indegree.get(nextRecipe) == 0) {
                        q.offer(nextRecipe);
                    }
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
       String [] recipes = {"bread"};
       List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("yeast", "flour"));
       String []supplies = {"yeast","flour","corn"};

       List<String> result = findAllRecipes(recipes, ingredients, supplies);
       System.out.println(result);
    }
}
