# LaddersInAnArray.py

# Problem: Given an array where each element represents the maximum number of steps that can be jumped forward from that element, find the minimum number of jumps to reach the end of the array (starting from the first element).
# If it's not possible to reach the end, return -1.

# Brute Force Approach (Recursive)
def min_jumps_brute_force(arr, n, idx=0):
    if idx >= n - 1:
        return 0
    if arr[idx] == 0:
        return float('inf')
    min_jumps = float('inf')
    for step in range(1, arr[idx] + 1):
        jumps = min_jumps_brute_force(arr, n, idx + step)
        if jumps != float('inf'):
            min_jumps = min(min_jumps, jumps + 1)
    return min_jumps

# Efficient Approach (Greedy)
def min_jumps_efficient(arr):
    n = len(arr)
    if n <= 1:
        return 0
    if arr[0] == 0:
        return -1
    max_reach = arr[0]
    step = arr[0]
    jumps = 1
    for i in range(1, n):
        if i == n - 1:
            return jumps
        max_reach = max(max_reach, i + arr[i])
        step -= 1
        if step == 0:
            jumps += 1
            if i >= max_reach:
                return -1
            step = max_reach - i
    return -1

# Example usage
if __name__ == "__main__":
    arr = [2, 3, 1, 1, 4]
    n = len(arr)
    # Brute force (may be slow for large arrays)
    result_brute = min_jumps_brute_force(arr, n)
    print("Brute Force:", result_brute if result_brute != float('inf') else -1)
    # Efficient
    result_efficient = min_jumps_efficient(arr)
    print("Efficient:", result_efficient)