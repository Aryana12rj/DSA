# Brute Force Approach
def first_highest_brute_force(arr):
    max_elem = arr[0]
    for i in range(len(arr)):
        for j in range(len(arr)):
            if arr[j] > max_elem:
                max_elem = arr[j]
    return max_elem

# Efficient Approach (Single Pass)
def first_highest_efficient(arr):
    max_elem = arr[0]
    for num in arr:
        if num > max_elem:
            max_elem = num
    return max_elem

# Example usage
arr = [3, 1, 7, 4, 9, 2]
print("Brute Force:", first_highest_brute_force(arr))
print("Efficient:", first_highest_efficient(arr))