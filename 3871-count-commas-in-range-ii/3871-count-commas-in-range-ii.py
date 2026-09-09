class Solution:
    def countCommas(self, n: int) -> int:
        answer = 0;

        power =1000;
        commas = 1;

        while (power <= n):
            end = min (n,power * 1000 -1)

            count = end -power +1

            answer += count *commas 

            power *= 1000
            commas  += 1

        return answer 
