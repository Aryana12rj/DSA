# Brute Force Approach: Using extra space
def rotate_matrix_brute_force(matrix):
    n = len(matrix)
    result = [[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            result[j][n-1-i] = matrix[i][j]
    # Copy result back to matrix
    for i in range(n):
        for j in range(n):
            matrix[i][j] = result[i][j]

# Efficient Approach: In-place rotation
def rotate_matrix_efficient(matrix):
    n = len(matrix)
    # Transpose the matrix
    for i in range(n):
        for j in range(i, n):
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
    # Reverse each row
    for i in range(n):
        matrix[i].reverse()

# Example usage:
if __name__ == "__main__":
    mat1 = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    mat2 = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    rotate_matrix_brute_force(mat1)
    print("Brute Force Rotated Matrix:")
    for row in mat1:
        print(row)
    rotate_matrix_efficient(mat2)
    print("Efficient Rotated Matrix:")
    for row in mat2:
        print(row)