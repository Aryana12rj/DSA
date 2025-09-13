import random

# Brute Force Approach: Sort the array and pick the kth largest
def find_kth_largest_brute(nums, k):
    nums_sorted = sorted(nums, reverse=True)
    return nums_sorted[k - 1]

# Efficient Approach: Quickselect Algorithm (Average O(n) time)

def partition(nums, left, right, pivot_index):
    pivot_value = nums[pivot_index]
    # Move pivot to end
    nums[pivot_index], nums[right] = nums[right], nums[pivot_index]
    store_index = left
    for i in range(left, right):
        if nums[i] > pivot_value:  # For kth largest
            nums[store_index], nums[i] = nums[i], nums[store_index]
            store_index += 1
    # Move pivot to its final place
    nums[right], nums[store_index] = nums[store_index], nums[right]
    return store_index

def quickselect(nums, k):
    left, right = 0, len(nums) - 1
    k_index = k - 1  # kth largest
    while left <= right:
        pivot_index = random.randint(left, right)
        pos = partition(nums, left, right, pivot_index)
        if pos == k_index:
            return nums[pos]
        elif pos < k_index:
            left = pos + 1
        else:
            right = pos - 1
    return -1  # Should not reach here

# Example usage:
if __name__ == "__main__":
    arr = [3, 2, 1, 5, 6, 4]
    k = 2
    print("Brute Force:", find_kth_largest_brute(arr, k))
    print("Efficient (Quickselect):", quickselect(arr[:], k))