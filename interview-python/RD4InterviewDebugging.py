def productExceptSelf(numbers):
    leftProducts = [1] * len(numbers)
    rightProducts = [1] * len(numbers)
    result = [1] * len(numbers)

    # Recursively compute "left product" for each index (starting at the left-hand side)
    leftProducts[0] = 1
    for i in range(1, len(numbers)):
        leftProducts[i] = leftProducts[i - 1] * numbers[i]

    # Recursively compute "right product" for each index (starting at the right-hand side)
    rightProducts[len(numbers) - 1] = 1
    for i in range(len(numbers) - 1, -1, -1):
        rightProducts[i] = rightProducts[i + 1] * numbers[i]
        
    for i in range(len(numbers)):
        result[i] = leftProducts[i] * rightProducts[i]
        
    return result

def main():
    input1 = [1, 2, 3, 4]
    print(str(productExceptSelf(input1)))
    # Expected: [24, 12, 8, 6]

"""
-------------------------------------------------------------------------------------------
This is for the review of the interviewer to help to guide the candidate!
Areas to fix:
    - line 9 should be numbers[i - 1]
    - line 12 should be len - 2, not len - 1
    - line 14 should be numbers[i + 1]
-------------------------------------------------------------------------------------------
"""
main()