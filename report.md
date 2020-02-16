# Report for assignment 3

## Project
**Name:** Esri Geometry API

**Description:** A library used to enable spatial data processing in 3rd-party data-processing solutions.

**Group Members:**
* Mathieu Desponds
* My Helmisaari
* Julian Jaramillo
* Axel Kennedal
* Henrik Mellin

**URL to our fork:** https://github.com/hmellin97/geometry-api-java

## Onboarding experience
We found the project in the list provided by the lab instructions.

The project has a decent README. Cloning, building and running the tests using the Maven command line tool was very easy and pain-free. All dependencies are installed automatically by the build script.  The project had 486 tests which all passed. One thing that wasn't clear from the instructions in the repo though was that it requires a Java SDK version lower than SDK 11. Java 8 works, so that's what we went with. We wanted to use IntelliJ for working on this lab. The repo didn't contain any instructions for how to do this, and we had some issues with getting it to work. Eventually we got it working for everyone though and we are going to stick with this project.

Before we went with this project we looked at the Apache Commons library (Java) because we had used it ourselves, but it turned out that the coverage was too high for us to want to continue with it.

## Complexity

1. What are your results for ten complex functions?
   * Did all tools/methods get the same result?
       * Mathieu : I have the same result copmuting the CC by hand or with `lizard` 
   * Are the results clear?
       * All the conditions in an `if`, a `for` or a `while` add 1 to the cyclomatic complexity. So if there are 10 conditions on arguments this will add ten to the cyclomatic complexity.
       * The `assert` are not taken into account.
       * The ternary logic operator are taken into account
       * At the end add 1 to have the cyclomatic complexity metric
2. Are the functions just complex, or also long?
    * *ToDo* : Make a summary of what everyone said 
    * Mathieu : The fonctions are complex and long. The one with CC 30 has 84 LOC and the function with CC 37 has 110 LOC
    * My : 
    * Julian : 
    * Axel :
    * Henrik :
3. What is the purpose of the functions?
    * The goal of `_intersectLineLine` is to see if two lines intersect. If it is the case it returns the points that are in both lines
    * The goal of `intersect` in `SegmentIntersector` is to determine if there is an intersection between a Point and a Segment with a certain `tolerance` where a Segment is a collection of line 
    * 
    * The problem with those functions is that they are not using some helper functions. All the code is written sequentially.
4. Are exceptions taken into account in the given measurements?
    * The `if` branch at the beginning of each function that test parameters and throws exceptions if the parameters are invalid are taken into account. However, almost no arguments is tested at the beginning of the functions so the ratio of exception is very low.
    * The `try...catch` also add 1 to the CC
5. Is the documentation clear w.r.t. all the possible outcomes?
    * *ToDo* : Make a summary of what everyone said 
    * Mathieu : No, there is no documentation at all.
    * My : 
    * Julian : 
    * Axel :
    * Henrik :

## Coverage

### Tools

Document your experience in using a "new"/different coverage tool.

How well was the tool documented? Was it possible/easy/difficult to
integrate it with your build environment?
* First we wanted to use `OpenCover` for `IntelliJ` but `OpenCover` is not supported anymore by `IntelliJ`. However, doing that, we found that there was a tool coverage integrated in ÌntelliJ. This is what we used.  

### DYI

Show a patch (or link to a branch) that shows the instrumented code to
gather coverage measurements.

The patch is probably too long to be copied here, so please add
the git command that is used to obtain the patch instead:

git diff ...

What kinds of constructs does your tool support, and how accurate is
its output?

### Evaluation

1. How detailed is your coverage measurement?
    * We can see the pourcentage of branch that were reached
    * We can see which `branchId` was not reached 
    * We can handle `try...catch` and see if the `catch` part is reached

2. What are the limitations of your own tool? 
    * It doesn't take into account ternary operators directly. However, we can easily rewrite a ternary operator `a?b:c` into 
    ```java
    if(a){
        coverageTool.addReached(#);
        b;
    }else{
        coverageTool.addReached(#+1);
        c;
    }
    ```

3. Are the results of your tool consistent with existing coverage tools?
    * Mathieu : For me it gives the same results

### Coverage improvement

Show the comments that describe the requirements for the coverage.

Report of old coverage: [link]

Report of new coverage: [link]

Test cases added:

git diff ...

## Refactoring

Plan for refactoring complex code:

Estimated impact of refactoring (lower CC, but other drawbacks?).

Carried out refactoring (optional)

git diff ...

## Overall experience

What are your main take-aways from this project? What did you learn?

Is there something special you want to mention here?
