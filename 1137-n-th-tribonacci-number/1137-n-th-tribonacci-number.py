class Solution:
    def tribonacci(self, n: int) -> int:
        dp = [-1] * (n + 1)
        def tri(n, dp):
            if n == 0:
                return 0
            if n == 1 or n == 2:
                return 1
            if dp[n] != -1:
                return dp[n]
            
            dp[n] = tri(n-1, dp) + tri(n-2, dp) + tri(n-3, dp)
            return dp[n]

        return tri(n, dp)
        