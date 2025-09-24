# Brute Force Approach (using a marker value)
def setZeroes_brute_force(matrix):
    rows, cols = len(matrix), len(matrix[0])
    marker = -1000000  # Assumes matrix values are not this

    # First pass: mark zeros
    for i in range(rows):
        for j in range(cols):
            if matrix[i][j] == 0:
                # Mark row
                for k in range(cols):
                    if matrix[i][k] != 0:
                        matrix[i][k] = marker
                # Mark column
                for k in range(rows):
                    if matrix[k][j] != 0:
                        matrix[k][j] = marker

    # Second pass: set marked cells to zero
    for i in range(rows):
        for j in range(cols):
            if matrix[i][j] == marker:
                matrix[i][j] = 0

# Efficient Approach (using O(1) space)
def setZeroes_efficient(matrix):
    rows, cols = len(matrix), len(matrix[0])
    first_row_zero = any(matrix[0][j] == 0 for j in range(cols))
    first_col_zero = any(matrix[i][0] == 0 for i in range(rows))

    # Use first row and column as markers
    for i in range(1, rows):
        for j in range(1, cols):
            if matrix[i][j] == 0:
                matrix[i][0] = 0
                matrix[0][j] = 0

    # Set zeroes based on markers
    for i in range(1, rows):
        for j in range(1, cols):
            if matrix[i][0] == 0 or matrix[0][j] == 0:
                matrix[i][j] = 0

    # Set first row and column if needed
    if first_row_zero:
        for j in range(cols):
            matrix[0][j] = 0
    if first_col_zero:
        for i in range(rows):
            matrix[i][0] = 0

# Example usage:
if __name__ == "__main__":
    mat1 = [
        [1, 1, 1],
        [1, 0, 1],
        [1, 1, 1]
    ]
    setZeroes_brute_force(mat1)
    print("Brute Force:", mat1)

    mat2 = [
        [1, 1, 1],
        [1, 0, 1],
        [1, 1, 1]
    ]
    setZeroes_efficient(mat2)
    print("Efficient:", mat2)