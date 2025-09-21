# Brute Force Approach
def search_brute_force(nums, target):
    for i, num in enumerate(nums):
        if num == target:
            return i
    return -1

# Efficient Approach (Binary Search)
def search_efficient(nums, target):
    left, right = 0, len(nums) - 1
    while left <= right:
        mid = (left + right) // 2
        if nums[mid] == target:
            return mid
        # Left half is sorted
        if nums[left] <= nums[mid]:
            if nums[left] <= target < nums[mid]:
                right = mid - 1
            else:
                left = mid + 1
        # Right half is sorted
        else:
            if nums[mid] < target <= nums[right]:
                left = mid + 1
            else:
                right = mid - 1
    return -1

if __name__ == "__main__":
    nums = [4,5,6,7,0,1,2]
    target = 0
    print("Brute Force:", search_brute_force(nums, target))  # Output: 4
    print("Efficient:", search_efficient(nums, target))      # Output: 4