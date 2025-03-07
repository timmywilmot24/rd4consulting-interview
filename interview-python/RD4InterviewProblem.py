# Defines the main method to execute tests, which will call handle_caching against an expected result
import sys
def main():
    if sys.version_info < (3, 7):
        print("Python 3.7 or higher is required!")
    else:
        execute_custom_tests()
        # Once you are ready to run the RD4 tests, uncomment the line below and run it!
        # execute_rd4_tests()
"""
-------------------------------------------------------------------------------------------------------------------------
This function handles a set of operations via a 3 item 'least recently used' cache.
Your job is to input a stream of these commands and return the expected outputs.
The commands will be 'put' and 'get' (both commands will push ID to most recently used):
 - 'put' will take an ID and value to save. This will push out the least recently used ID if cache is full.
 - 'get' will check for the ID and return its value.
The output should a a tuple of 2 objects:
 - The first object will be the final cached dictionary
 - The second object will be a list containing all 'get' operations throughout the cycle
 -------------------------------------------------------------------------------------------------------------------------
"""
def handle_caching(operations):
    # Write code below to handle 'get' and 'put' operations
    return ({}, [])

"""
-------------------------------------------------------------------------------------------------------------------------
This is where you can define your test cases.  We have provided 1 test case to demonstrate an example below.
Add onto this sample test with more tests of your own!
-------------------------------------------------------------------------------------------------------------------------
"""
def execute_custom_tests():
    test(handle_caching([
        ('put', 1, 1), 
        ('get', 1), 
        ('put', 2, 2)]), 
    ({1: 1, 2: 2}, [1]))

# Define all RD4 test cases here
def execute_rd4_tests():
    test(handle_caching([('put', 1, 1), ('get', 1), ('put', 2, 2)]), ({1: 1, 2: 2}, [1]))
    test(handle_caching([('put', 1, 1), ('get', 1), ('put', 2, 2), ('put', 2, 3)]), ({1: 1, 2: 3}, [1]))
    test(handle_caching([('put', 1, 1), ('put', 2, 2), ('put', 3, 5), ('put', 4, 9)]), ({2: 2, 3: 5, 4: 9}, []))
    test(handle_caching([('put', 1, 1), ('put', 2, 2), ('put', 3, 5), ('get', 1)]), ({2: 2, 3: 5, 1: 1}, [1]))
    test(handle_caching([('put', 1, 1), ('put', 2, 2), ('put', 3, 5), ('put', 4, 9), ('get', 1), ('get', 3)]), ({2: 2, 4: 9, 3: 5}, [-1, 5]))
    test(handle_caching([('put', 1, 1), ('put', 2, 3), ('put', 3, 6), ('get', 1), ('put', 4, 12), ('get', 4), ('put', 3, 8), ('get', 3)]), ({1: 1, 4: 12, 3: 8}, [1, 12, 8]))
    test(handle_caching([('get', 1), ('get', 2), ('get', 3)]), ({}, [-1, -1, -1]))
    test(handle_caching([]), ({}, []))
"""
-------------------------------------------------------------------------------------------------------------------------
You should not need to go below this line! This is for helper functions to test and RD4's solution (to review at the end)
-------------------------------------------------------------------------------------------------------------------------
"""
testNumber=0
def test(test_values, expected_values):
    global testNumber
    testNumber+=1
    if test_values[0] == expected_values[0] and test_values[1] == expected_values[1]:
        print('Test ' + str(testNumber) + ' passed!')
    else:
        print('Test ' + str(testNumber) + ' failed!')
"""
-------------------------------------------------------------------------------------------------------------------------
This is RD4's solution. This is designed to provoke discussion around different approaches
and should not be used as part of the original solution. The interviewer may feel free to assess
and review this solution to give guidance and/or assistance as needed.
-------------------------------------------------------------------------------------------------------------------------
"""
from collections import OrderedDict
def handle_caching_rd4(operations):
    cache = OrderedDict()  # OrderedDict maintains the order of keys
    getOps = []
    for op, key, *value in operations:
        if op == 'get':
            # Return the value if key is in cache, else -1
            if key in cache:
                cache.move_to_end(key)  # Move the accessed item to the end
                getOps.append(cache[key])
            else:
                getOps.append(-1)
        elif op == 'put':
            # If the key exists, update it and move to the end
            if key in cache:
                cache.move_to_end(key)
            cache[key] = value[0]
            # If cache exceeds capacity, remove the least recently used item
            if len(cache) > 3:
                cache.popitem(last=False)
    return (dict(cache), getOps)  # Return the final state of the cache
    
main()
