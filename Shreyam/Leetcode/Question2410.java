// Question: Maximum Matching of Players With Trainers

// You are given a 0-indexed integer array players, where players[i] represents the ability of the ith player. You are also given a 0-indexed integer array trainers, where trainers[j] represents the training capacity of the jth trainer.
// The ith player can match with the jth trainer if the player's ability is less than or equal to the trainer's training capacity. Additionally, the ith player can be matched with at most one trainer, and the jth trainer can be matched with at most one player.
// Return the maximum number of matchings between players and trainers that satisfy these conditions.

// Example 1:
// Input: players = [4,7,9], trainers = [8,2,5,8]
// Output: 2

package shreyam.leetCode;

import java.util.Arrays;

public class Question2410 {
    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int ans = 0;

    Arrays.sort(players);
    Arrays.sort(trainers);

    for (int i = 0; i < trainers.length; ++i)
      if (players[ans] <= trainers[i] && ++ans == players.length)
        return ans;

    return ans;
    }
    public static void main(String[] args) {
       int[] players = {4,7,9}, trainers = {8,2,5,8};
       System.out.println(matchPlayersAndTrainers(players, trainers));
    }
}
