# Brute Force Approach
def findPeakElementBruteForce(nums):
    n = len(nums)
    for i in range(n):
        left = nums[i-1] if i > 0 else float('-inf')
        right = nums[i+1] if i < n-1 else float('-inf')
        if nums[i] > left and nums[i] > right:
            return i
    return -1  # No peak found

# Efficient Approach (Binary Search)
def findPeakElementEfficient(nums):
    left, right = 0, len(nums) - 1
    while left < right:
        mid = (left + right) // 2
        if nums[mid] < nums[mid + 1]:
            left = mid + 1
        else:
            right = mid
    return left

# Example usage:
if __name__ == "__main__":
    arr = [1, 2, 1, 3, 5, 6, 4]
    print("Brute Force Peak Index:", findPeakElementBruteForce(arr))
    print("Efficient Peak Index:", findPeakElementEfficient(arr))