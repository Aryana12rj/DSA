# Brute Force Approach
def findKthPositive_brute(arr, k):
    missing = []
    num = 1
    i = 0
    while len(missing) < k:
        if i < len(arr) and arr[i] == num:
            i += 1
        else:
            missing.append(num)
        num += 1
    return missing[-1]

# Efficient Approach (Binary Search)
def findKthPositive_efficient(arr, k):
    left, right = 0, len(arr)
    while left < right:
        mid = (left + right) // 2
        missing = arr[mid] - (mid + 1)
        if missing < k:
            left = mid + 1
        else:
            right = mid
    return left + k

# Example usage:
arr = [2, 3, 4, 7, 11]
k = 5
print("Brute Force:", findKthPositive_brute(arr, k))      # Output: 9
print("Efficient:", findKthPositive_efficient(arr, k))    # Output: 9