# Brute Force Approach
def move_zeros_brute_force(arr):
    n = len(arr)
    result = []
    zero_count = 0
    for num in arr:
        if num != 0:
            result.append(num)
        else:
            zero_count += 1
    result.extend([0] * zero_count)
    return result

# Efficient Approach (In-place, O(n) time, O(1) space)
def move_zeros_efficient(arr):
    n = len(arr)
    j = 0  # Position to place the next non-zero element
    for i in range(n):
        if arr[i] != 0:
            arr[j] = arr[i]
            j += 1
    # Fill remaining positions with zeros
    for i in range(j, n):
        arr[i] = 0
    return arr

if __name__ == "__main__":
    arr = [0, 1, 0, 3, 12]
    print("Brute Force:", move_zeros_brute_force(arr))
    print("Efficient:", move_zeros_efficient(arr.copy()))