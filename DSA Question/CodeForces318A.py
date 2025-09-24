n, k = map(int, input().split())

# Count of odd numbers in the sequence
odd_count = (n + 1) // 2

if k <= odd_count:
    # k-th odd number
    print(2 * k - 1)
else:
    # (k - odd_count)-th even number
    print(2 * (k - odd_count))
    