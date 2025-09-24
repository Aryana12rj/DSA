# Brute Force Approach
def count_rotations_brute(arr):
    n = len(arr)
    for i in range(1, n):
        if arr[i] < arr[i-1]:
            return i
    return 0  # Not rotated

# Efficient Approach (Binary Search)
def count_rotations_efficient(arr):
    n = len(arr)
    low, high = 0, n - 1
    while low <= high:
        if arr[low] <= arr[high]:
            return low
        mid = (low + high) // 2
        next_idx = (mid + 1) % n
        prev_idx = (mid - 1 + n) % n
        if arr[mid] <= arr[next_idx] and arr[mid] <= arr[prev_idx]:
            return mid
        elif arr[mid] >= arr[low]:
            low = mid + 1
        else:
            high = mid - 1
    return 0

# Example usage
arr = [15, 18, 2, 3, 6, 12]
print("Brute Force:", count_rotations_brute(arr))
print("Efficient:", count_rotations_efficient(arr))