# Count Palindromic Strings with Constraints

**[View Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/number-of-palindromic-strings2706/)**

---

## Problem

Given two integers n and k, consider an alphabet consisting of the first k lowercase English letters. Find the number of palindromic strings whose length is less than or equal to n, such that:

Note: Since the answer can be very large, return it modulo 10^9+7.

## Examples
### Example 1

**Input:**

```
n = 3, k = 2
```

**Output:**

```
6
```

**Explanation:**

The possible strings are: "a", "b", "aa", "bb", "aba", "bab".

### Example 2

**Input:**

```
n = 4, k = 3
```

**Output:**

```
18
```

**Explanation:**

The possible strings are:"a", "b", "c", "aa", "bb", "cc", "aba", "aca", "bab", "bcb", "cac", "cbc", "abba", "acca", "baab", "bccb", "caac", "cbbc".

## Input Format
- n = — INTEGER
- k = — INTEGER

## Expected Complexity
- Time: O(k^2)
- Auxiliary Space: O(k^2)

## Topic Tags
- Strings
- Dynamic Programming
- Mathematics
- Combinatorial

## Submission
- Language: java
- Status: Accepted
- Runtime: 0.16
- Test Cases: 1115/1115
