# Brute force approach to find integer square root
def sqrt_brute_force(x):
    if x < 0:
        return None  # Square root not defined for negative numbers
    i = 0
    while i * i <= x:
        i += 1
    return i - 1

# Efficient approach using binary search
def sqrt_binary_search(x):
    if x < 0:
        return None
    if x == 0 or x == 1:
        return x
    left, right = 0, x
    ans = 0
    while left <= right:
        mid = (left + right) // 2
        if mid * mid == x:
            return mid
        elif mid * mid < x:
            ans = mid
            left = mid + 1
        else:
            right = mid - 1
    return ans

# Example usage:
if __name__ == "__main__":
    num = 17
    print("Brute force sqrt:", sqrt_brute_force(num))
    print("Binary search sqrt:", sqrt_binary_search(num))