# Kotlin Threads Examples
## Manual to run examples from your computer 
 
### Requirements
    - java
    - JDK 

#### - Step 1: You need to download kotlinc compiler from jetbrain's github repository
  - [Download link][JetBrainsRepo]
#### - Step 2: You need to add KOTLIN_HOME into enviroment variables and add it into path
    Check kotlinc from cmd to make sure that everything is OK
#### - Step 3: Open cmd and move into kotlin's file directory
    1. Compile file: kotlinc <filename>.kt -include-runtime <outfilename>.jar
    2. Run jar file: java -jar <outfilename>.jar


[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [JetBrainsRepo]: <https://github.com/JetBrains/kotlin/releases/tag/v1.3.61>
  
## In Programs with outer Classes:
    ~ In this case, we need to compile them together.
    Example: The file of program -> program.kt and a class whichone program uses -> myclass.kt
    1. IN CMD: kotlinc -include-runtime -d <outputfilename>.jar <path>\program.kt <otherpath>\myclass.kt 
    2. Run jar file: java -jar <outfilename>.jar


### Example:
 -  Create a list with random numbers, and then duplicate each number of list.
 
    Files used:
        
        GlobalVariables.kt 
        DuplicateWithThreadsClass.kt
        DuplicateExample.kt
        DuplicateExampleWithOutThreads.kt
        DuplicateExampleWithThreads.kt
        //I'll add comments in each file to explain those
        
     - To execute this example, open a cmd, go to src folder and execute the command below to compile the file:
        
            kotlinc -include-runtime -d program.jar allmodels\examples\DuplicateWithThreadsClass.kt allmodels\examples\GlobalList.kt exampleThreads\DuplicateExampleWithOutThreads.kt exampleThreads\DuplicateExampleWithThreads.kt exampleThreads\DuplicateExample.kt
    
     - Execute the output jar file with:
            
            java -jar program.jar
        
        