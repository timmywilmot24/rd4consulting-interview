import random

def main():
    print("Starting the execution of random number methods...")
    nums = []
    for i in range (0, 20):
        nums.append(random.randint(1, 100))
    print("Random numbers: ")
    for num in nums:
        print(str(num))
    
    sum = 0
    for num in nums:
        sum += num
    print("The sum of the numbers is: " + str(sum))
    
    largest = 0
    for num in nums:
        if (num > largest):
            largest = num
    print("The largest number is: " + str(largest))
    
    nums.sort(reverse=True)
    
    print("Sorted list in descending order: " + str(nums))

    unique_nums = []
    for num in nums:
        if num not in unique_nums:
            unique_nums.append(num)
    print("List without duplicates is: " + str(unique_nums))
    
main()