
# Codeforces 50/A - Domino piling
# Problem: Given a n x m board, find the maximum number of 2 x 1 dominoes that can be placed on the board without overlapping.
n, m = map(int, input().split())
# Each domino covers 2 squares, so the maximum number of dominoes is the total number of squares divided by 2
max_dominoes = (n * m) // 2
print(max_dominoes)