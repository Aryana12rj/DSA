# Brute Force Approach
def generateSpiralMatrixBruteForce(n):
    matrix = [[0]*n for _ in range(n)]
    num = 1
    for layer in range((n+1)//2):
        # Top row
        for i in range(layer, n-layer):
            matrix[layer][i] = num
            num += 1
        # Right column
        for i in range(layer+1, n-layer):
            matrix[i][n-layer-1] = num
            num += 1
        # Bottom row
        for i in range(n-layer-2, layer-1, -1):
            matrix[n-layer-1][i] = num
            num += 1
        # Left column
        for i in range(n-layer-2, layer, -1):
            matrix[i][layer] = num
            num += 1
    return matrix

# Efficient Approach
def generateSpiralMatrixEfficient(n):
    matrix = [[0]*n for _ in range(n)]
    left, right, top, bottom = 0, n-1, 0, n-1
    num = 1
    while left <= right and top <= bottom:
        for i in range(left, right+1):
            matrix[top][i] = num
            num += 1
        top += 1
        for i in range(top, bottom+1):
            matrix[i][right] = num
            num += 1
        right -= 1
        if top <= bottom:
            for i in range(right, left-1, -1):
                matrix[bottom][i] = num
                num += 1
            bottom -= 1
        if left <= right:
            for i in range(bottom, top-1, -1):
                matrix[i][left] = num
                num += 1
            left += 1
    return matrix

# Example usage:
if __name__ == "__main__":
    n = 3
    print("Brute Force Spiral Matrix:")
    for row in generateSpiralMatrixBruteForce(n):
        print(row)
    print("\nEfficient Spiral Matrix:")
    for row in generateSpiralMatrixEfficient(n):
        print(row)