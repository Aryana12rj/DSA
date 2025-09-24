# Brute Force Approach (O(n) time)
def findMinBruteForce(nums):
    return min(nums)

# Efficient Approach (Modified Binary Search, O(log n) average, O(n) worst)
def findMin(nums):
    left, right = 0, len(nums) - 1
    while left < right:
        mid = (left + right) // 2
        if nums[mid] < nums[right]:
            right = mid
        elif nums[mid] > nums[right]:
            left = mid + 1
        else:  # nums[mid] == nums[right], can't decide, reduce right
            right -= 1
    return nums[left]

# Example usage:
if __name__ == "__main__":
    arr = [2,2,2,0,1]
    print("Brute Force:", findMinBruteForce(arr))
    print("Efficient:", findMin(arr))