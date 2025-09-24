# Brute Force Approach
def total_occurrences_brute(nums, target):
    count = 0
    for num in nums:
        if num == target:
            count += 1
    return count

# Efficient Approach (Binary Search, for sorted array)
def total_occurrences_efficient(nums, target):
    def find_first(nums, target):
        left, right = 0, len(nums) - 1
        first = -1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                first = mid
                right = mid - 1
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return first

    def find_last(nums, target):
        left, right = 0, len(nums) - 1
        last = -1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                last = mid
                left = mid + 1
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return last

    first = find_first(nums, target)
    last = find_last(nums, target)
    if first == -1 or last == -1:
        return 0
    return last - first + 1

# Example usage:
nums = [1, 2, 2, 2, 3, 4, 5]
target = 2
print("Brute Force:", total_occurrences_brute(nums, target))
print("Efficient:", total_occurrences_efficient(nums, target))