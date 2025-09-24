# Brute Force Approach
def maxProductBruteForce(nums):
    n = len(nums)
    max_product = float('-inf')
    for i in range(n):
        product = 1
        for j in range(i, n):
            product *= nums[j]
            max_product = max(max_product, product)
    return max_product

# Efficient Approach (Kadane's Algorithm for Product)
def maxProductEfficient(nums):
    if not nums:
        return 0
    max_so_far = min_so_far = result = nums[0]
    for num in nums[1:]:
        candidates = (num, max_so_far * num, min_so_far * num)
        max_so_far = max(candidates)
        min_so_far = min(candidates)
        result = max(result, max_so_far)
    return result

# Example usage:
if __name__ == "__main__":
    nums = [2, 3, -2, 4]
    print("Brute Force:", maxProductBruteForce(nums))
    print("Efficient:", maxProductEfficient(nums))