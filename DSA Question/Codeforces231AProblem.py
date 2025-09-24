# Codeforces 231A - Team
# Problem: Count the number of teams where at least 2 members solved the problem.

# Read the number of teams
n = int(input())

# Initialize count of valid teams
count = 0

# For each team
for _ in range(n):
    # Read the three values (0 or 1 for each member)
    a, b, c = map(int, input().split())
    # Count the number of 1's
    if a + b + c >= 2:
        count += 1

# Output the result
print(count)
