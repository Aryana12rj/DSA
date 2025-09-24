# Brute Force Approach
def find_max_min_brute(nums):
    if not nums:
        return None, None
    max_val = nums[0]
    min_val = nums[0]
    for num in nums:
        if num > max_val:
            max_val = num
        if num < min_val:
            min_val = num
    return max_val, min_val

# Efficient Approach (Binary Search)
def find_max_min_efficient(nums):
    if not nums:
        return None, None
    n = len(nums)
    left, right = 0, n - 1

    # Find min (pivot)
    while left < right:
        mid = (left + right) // 2
        if nums[mid] > nums[right]:
            left = mid + 1
        else:
            right = mid
    min_val = nums[left]

    # Find max (element before min, or last element if min is at index 0)
    max_idx = left - 1 if left > 0 else n - 1
    max_val = nums[max_idx]

    return max_val, min_val

# Example usage:
nums = [4,5,6,7,0,1,2]
print("Brute Force:", find_max_min_brute(nums))
print("Efficient:", find_max_min_efficient(nums))