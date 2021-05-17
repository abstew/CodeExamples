# This program will calculate the Body Mass Index (BMI) for six user inputs.
# This program will call for the names, then height and weight.
# The program will output the BMI and determine whether the individual is normal, over, or underweight.

# Programmer's introduction
def myName():
    print("Anna Stewart")
    print("CMIS 102-6381")
    print("March 9, 2021")

# Program introduction
def introduction():
    print("Welcome to the Body Mass Index (BMI) Calculator")
    print("This program will calculate the BMI of 6 inputs given height and weight")

# Collect user input for names
# Function will return an array with 6 individual names
# For formatting, user input names will be capitalized
def userNames():
    inputNames = []
    count = 0
    while count < 6:
        unformattedName = input("What is the individual's name?\n")
        count = count + 1
        person = unformattedName.capitalize()
        inputNames.append(person)
    return(inputNames)

# Collect user input for height and weight
# Program will verify that both height and weight are valid inputs (above 0)
# Program will return two arrays; 6 heights, and 6 weights.
def heightandweight(inputNames):
    heights = []
    weights = []
    for inputName in inputNames:
        print("For:",inputName)
        userHeight = eval(input("Input height measurement (in inches)\n"))
        userWeight = eval(input("Input weight measurement (in pounds)\n"))
        if (userHeight > 0 and userWeight > 0):
            heights.append(userHeight)
            weights.append(userWeight)
        else:
            print("ERROR! Height and Weight values must be positive")
            userHeight = eval(input("Input positive height measurement\n"))
            userWeight = eval(input("Input positive weight measurement\n"))
            heights.append(userHeight)
            weights.append(userWeight)
    return(heights, weights)


# Perform calculations to get BMI
# Parameters are height and weight arrays, which will loop through each array, treating height/weight as a pair.
# Return BMI calculations in parallel bodyMassIndex array.
def bmiCalculations(heights,weights):
    bodyMassIndex = []
    for height, weight in zip(heights, weights):
        bmi = (weight * 703) / (height*height)
        bodyMassIndex.append(bmi)
    return(bodyMassIndex)

# Calculate BMI classifications
# Categories are underweight, normal weight, and overweight.
# Counts are set at 0 and increase with each count of BMI classification.
def bmiClassify(bodyMassIndex):
    underweightCount = 0
    normalWeightCount = 0
    overweightCount = 0
    for bodyMassIndex in bodyMassIndex:
        if bodyMassIndex < 18.5:
            underweightCount = underweightCount + 1
        elif bodyMassIndex > 18.5 and bodyMassIndex < 25:
            normalWeightCount = normalWeightCount + 1
        elif bodyMassIndex > 25:
            overweightCount = overweightCount + 1
    return(underweightCount, normalWeightCount, overweightCount)

# Display BMI classifications
def displayOutput(bodyMassIndex,underweightCount, normalWeightCount, overweightCount):
    print("The Body Mass Indexes of your 6 provided individuals are as follows:")
    print(bodyMassIndex)
    print("Out of your individuals,",underweightCount,"are classified as underweight")
    print(normalWeightCount,"individuals have a normal BMI")
    print("And",overweightCount,"individuals are considered overweight")

        

def main():
    # Introduce programmer
    myName()
    
    # Introduce Program
    introduction()
    
    # Collect names
    inputNames = userNames()
    
    # Collect height/weight 
    heights, weights = heightandweight(inputNames)
    
    # Calculate BMI
    bodyMassIndex = bmiCalculations(heights, weights)
    
    # Classify BMI's by weight category
    underweightCount, normalWeightCount, overweightCount = bmiClassify(bodyMassIndex)
    
    # Display classification results
    displayOutput(bodyMassIndex,underweightCount, normalWeightCount, overweightCount)
main()
