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

## Chosen Functions
These are the functions each group member has chosen to work with.
* Mathieu : `Line::_intersectLineLine` and `SegmentIntersecot::intersect`
* My : `PolygonUtils::testPointsOnPolyLine2D_` and `Envelope2D::clipLine`
* Julian : `SweepComparator::compareSegments` and `Clipper::checkSegmentIntersection_`
* Axel : `WktParser::attributes_` and `RelationalOperations::polygonTouchesPolygonImpl_`
* Henrik : 

Please write here if you used any other functions for the part about increasing coverage/writing tests. 
* Mathieu : 
* My :
* Julian : 
* Axel : `Boundary::hasNonEmptyBoundary`
* Henrik : 

## Complexity

1. What are your results for ten complex functions?
   * Did all tools/methods get the same result?
       * Mathieu : I have the same result computing the CC by hand or with `lizard`
       * My : I can not get the same results computing the CC by hand as I get using `lizard` for one function (clipLine, I get 15 but lizard says 22) but for the other function it is the same.
       * Axel : I get the same results (16) both with `lizard` and by hand.
       * Julian : Yes I get exactly the same results by hand and with lizard.
   * Are the results clear?
       * Yes, it is very straightforward.
       * All the conditions in an `if`, a `for` or a `while` add 1 to the cyclomatic complexity. So if there are 10 conditions on arguments this will add ten to the cyclomatic complexity.
       * The `assert` are not taken into account.
       * The ternary logic operator are taken into account
       * At the end add 1 to have the cyclomatic complexity metric
2. Are the functions just complex, or also long?
    * Mathieu : The functions are complex and long. The one with CC 30 has 84 LOC and the function with CC 37 has 110 LOC
    * My : The functions I choose is both complex and long. The one with CC 22 has 106 LOC and the one with CC 16 has 43 LOC which is a lot less. The latter function contains a lot more loops (containing conditions) than the first one, which increases the cyclic complexity even though there are much fewer lines of code.
    * Julian : `SweepComparator::compareSegments` has CC 16 and LOC of 63. `Clipper::checkSegmentIntersection_` has CC 17 and LOC of 42. So one of them is cleary on the shorter end but has slightly higher complexity. 
    * Axel : `attributes_` has 34 LOC and `polygonTouchesPolygonImpl_` has 76 LOC (both have CC 16).
    * Henrik : `construct` has 81 LOC and `insertPath` has 67 LOC
3. What is the purpose of the functions?
    * Axel : 
      * `attributes_` is a function in a class for parsing files in the WKT file format. It is responsible for parsing attributes.
      * `polygonTouchesPolygonImpl_` returns true if two polygons touch/intersect, false otherwise.
    * The goal of `_intersectLineLine` is to see if two lines intersect. If it is the case it returns the points that are in both lines
    * The goal of `intersect` in `SegmentIntersector` is to determine if there is an intersection between a Point and a Segment with a certain `tolerance` where a Segment is a collection of line 
    * The goal of `clipLine` is to implement the Liang-Barsky algorithm for parametric line-clipping. The input parameters is: a start point and a end point. Depending on whether the points are within a given envelope, one of them will be modified and thus extending the line they create.
    * The goal of `testPointsOnPolyline2D_`is to determine if two points are on a "polyline".
    * The problem with those functions is that they are not using some helper functions. All the code is written sequentially.
    * The goal of `construct` is to create a convex hull.
    * The goal of `insertPath` is to insert a vertex into a path.
    * The goal of `SweepComparator::compareSegments` is to compare x values of the edge given by its origin (elm) and the edge in the sweep structure and checks them for intersection at the same time.
    * The goal of `Clipper::checkSegmentIntersection_` is to say whether there is an intersection and if there is not an intersection, it will say whether it is on the inside or outside of the border. 
    
4. Are exceptions taken into account in the given measurements?
    * The `if` branch at the beginning of each function that test parameters and throws exceptions if the parameters are invalid are taken into account. However, almost no arguments is tested at the beginning of the functions so the ratio of exception is very low.
    * The `try...catch` also add 1 to the CC
    * `construct` only has one exception, when the input is empty.
    * `insertPath` has a few exceptions, such as when the index is less than 0 and when the index is larger than the path.
5. Is the documentation clear w.r.t. all the possible outcomes?
    * Mathieu : No, there is no documentation at all.
    * My : In one of the functions yes, in the other there is no documentation.
    * Julian : One of the function had a short comment but not too helpful. It did however help to understand the return values (0,1,-1) and their meaning. The other had no documentation or comments. 
    * Axel : No, there is close to no documentation at all. There are just two short comments, in one of the functions. The fact that variable names are cryptic doesn't help either.
    * Henrik : There are very few comments that explain what the functions does, which makes it hard to fully understand them.

## Coverage

### Tools

Document your experience in using a "new"/different coverage tool.

How well was the tool documented? Was it possible/easy/difficult to
integrate it with your build environment?
* First we wanted to use `OpenCover` for `IntelliJ` but `OpenCover` is not supported anymore by `IntelliJ`. However, doing that, we found that there was a tool coverage integrated in ÌntelliJ. This is what we used.  

### DYI
Axel implemented the class `CoverageTool`, which provides functionality for manual coverage instrumentation.

Link to branch with our coverage tool: [Link](https://github.com/hmellin97/geometry-api-java/blob/manual-coverage/src/main/java/big/brain/CoverageTool.java)

To see the DIY-coverage tool implemented in the functions you can use the following command:

git diff master..{name}-DIY (where name is Mathieu, Henrik, Julian or My)

git diff master..axel-manual-coverage

Our tool supports conditions for: `if`, `for` and `while`.
The tool outputs how many of the set branches are being visited in the functions that we have chosen. It is dependent on the developer implementing it correctly.

Example output:
```
COVERAGE RESULTS
 * RelationalOperations::polygonTouchesPolygonImpl_ has 70.58823529411765% coverage, reached 12/17 branches.
    * The Branch ID that are not reached are [3, 8, 11, 13, 14]
 * WktParser:attributes_ has 76.92307692307693% coverage, reached 10/13 branches.
    * The Branch ID that are not reached are [2, 4, 6]
```
### Evaluation

1. How detailed is your coverage measurement?
    * We can see the percentage of branches that were reached
    * We can see which `branchId`s were not reached 
    * We can handle `try...catch` and see if the `catch` part is reached

2. What are the limitations of your own tool? 
    * It doesn't take into account ternary operators directly. However, we can easily rewrite a ternary operator `a ? b() : c()` as 
    ```java
    if (a) {
        cf.setReachedBranch(#);
        b();
    } else {
        cf.setReachedBranch(#+1);
        c();
    }
    ```
    
    How would the instrumentation change if you modify the program?
    * You might need to add or remove some calls to `cf.setReachedBranch();`, and if you do; modify the `numberOfBranches` parameter set at the top of the function, when initializing the coverage tool for the function.
    

3. Are the results of your tool consistent with existing coverage tools?
    * Mathieu : For me it gives the same results
    * My : It gives the same results
    * Julian : Yes, they are. 
    * Axel : Yes, see the image below
    ![Coverage comparison for WktParser](https://i.imgur.com/oq26u3a.png)
    * Henrik : 


### Coverage improvement
What is the coverage like overall for your project?
The IntelliJ coverage tool reports 91% class coverage, 71% method coverage and 72% line coverage.

TODO: branch coverage %?

Show the comments that describe the requirements for the coverage.

Report of old coverage:
* Mathieu : 
* My : `Envelope2D`: methods coverage 59%, line coverage 48%, function coverage 0% (not tests at all). `PolygonUtils`: method coverage 56%, line coverage 41%, function coverage 66.6%. Output from our coverage tool:
```
* PolygonUtils::testPointsonPolyLine2D_ has 66.66666666666666% coverage, reached 8/12 branches.
    * The Branch ID that are not reached are [0, 2, 3, 11]
```
* Julian : 
* Axel : 
  * `polygonTouchesPolygonImpl_`: The containing class has 97% method coverage and 85% line coverage. The function has 70.6% branch coverage;
  ```
  * RelationalOperations::polygonTouchesPolygonImpl_ has 70.58823529411765% coverage, reached 12/17 branches.
    * The Branch ID that are not reached are [3, 8, 11, 13, 14]
  ```
  * `hasNonEmptyBoundary` : The containing class has 87% method coverage and 65% line coverage. The function has 23% branch coverage;
  ```
  * Boundary::hasNonEmptyBoundary has 23.076923076923077% coverage, reached 3/13 branches.
      * The Branch ID that are not reached are [1, 3, 4, 5, 7, 8, 9, 10, 11, 12]
  ```
* Henrik : 

Report of new coverage:
* Mathieu : 
* My : `Envelope2D`: methods coverage 60%, line coverage 50%, function coverage 28.6%. `PolygonUtils`: method coverage 56%, line coverage 45%, function coverage 83.3%. Output from our coverage tool: 
```
 * Envelope2D::clipLine has 28.57142857142857% coverage, reached 2/7 branches.
    * The Branch ID that are not reached are [2, 3, 4, 5, 6]
 * PolygonUtils::testPointsonPolyLine2D_ has 83.33333333333334% coverage, reached 10/12 branches.
    * The Branch ID that are not reached are [3, 11]
```
* Julian : 
* Axel : 
  * `RelationalOperations`: IntelliJ reports the same coverage percentages, because I just added one test which covers one new branch (it's just a return statement) and the source file has 2565 lines of code. My DIY branch coverage instrumentation shows that the previously unreached branch (8) was now reached:
  ```
  * RelationalOperations::polygonTouchesPolygonImpl_ has 76.47058823529412% coverage, reached 13/17 branches.
      * The Branch ID that are not reached are [3, 11, 13, 14]
  ```
  So the branch coverage for the specific function was increased from 70.6% to 76.5%.
  * `hasNonEmptyBoundary` : The line coverage for the containing class increased from 65% to 77%. My DIY branch coverage instrumentation shows that branch coverage was increased from 23% to 69%:
  ```
  * Boundary::hasNonEmptyBoundary has 69.23076923076923% coverage, reached 9/13 branches.
    * The Branch ID that are not reached are [8, 9, 10, 12]
  ```

* Henrik : 

Test cases added:
* Mathieu : 
* My : The branch [My-test](https://github.com/hmellin97/geometry-api-java/tree/My-test) contains the added tests. To easily display them use the command `git diff My-DIY..My-test`.
* Julian : 
* Axel : The branch [Axel-test](https://github.com/hmellin97/geometry-api-java/tree/Axel-test) contains the added tests. To easily display them use the command `git diff axel-manual-coverage..Axel-test`.
* Henrik : 

Can the functions you test be called directly or did you need to make them public?
* Mathieu : 
* My : The functions are called directly.
* Julian : 
* Axel : I had to make `polygonTouchesPolygonImpl_` public, but `hasNonEmptyBoundary` can be called directly.
* Henrik : 


## Refactoring
Is the complexity of the functions really necessary?
* Mathieu : 
* My :
* Julian : For `Clipper::checkSegmentIntersection_` the complexity is necessary. It has a higher complexity since it needs to be able to handle the three different cases. In each case it needs to be able to identify whether to return 0, 1, -1. It can however be broken down into smaller functions and still achieve its purpose. `SweepComparator::compareSegments` is similarly also dependant on having high complexity. This is because a large part of the function aims to just understand what type of objects that are being compared. Depending on this, different types comparisons are being called. 
* Axel : As mentioned before, I don't understand `WktParser::attributes_` in detail, though I get on a higher level what it is supposed to do. I can understand that most of this complexity is needed because there are a lot of different cases for how the attributes to be parsed can be formatted. There are however some improvements that can be made to decrease complexity.
* Henrik : 

Plan for refactoring complex code:
* Mathieu : 
* My :
* Julian : 
  *`Clipper::checkSegmentIntersection_` works with different `cases`. The plan would be to break each section of code in each `case` into their own functions. This would how a great impact since a lot of the CC lies in the fact that the function has to be able to return 3 different values depending on the outcome for all cases. These new functions can be broken down into 1 new function that can handle all three cases but in order to lower the complexity of the new functions it would be best to have a new function for each case. The same applies for `SweepComparator::compareSegments`. Many parts of the function can be broken down into smaller functions. For example, there is a part of the function that checks the left edge and one part that checks the right edge. These parts are big contributors to the high CC. They can be broken down into their individual function. At the end of the code we have a group of `if`-statements that each call on other functions depending on what kind of check that needs to be done. So it is clear here that some work has previously been done in order to simplify the function.
* Axel :
  * Simplify character-comparisons. In two of the `if`-statements in the `attributes_`-function the condition checks whether a character is equal to another character, like so:
  ```java
  if (m_wkt_string.charAt(m_end_token) == 'z'
				|| m_wkt_string.charAt(m_end_token) == 'Z') { ... }
  ```
  Which can be simplified to:
  ```java
  if (m_wkt_string.toLowerCase().charAt(m_end_token) == 'z') { ... }
  ```
  * The last part of the function sets the current token type depending on what was parsed. This could be its own subroutine called from the function:
  ```java
  private void setCurrentTokenType(boolean m_b_has_zs, boolean m_b_has_ms) {
      if (m_b_has_zs || m_b_has_ms) {
        cf.setReachedBranch(8);
        if (m_b_has_zs && !m_b_has_ms) { 
          cf.setReachedBranch(9);
          m_current_token_type = WktToken.attribute_z;
        }
        else if (m_b_has_ms && !m_b_has_zs) {
          cf.setReachedBranch(10);
          m_current_token_type = WktToken.attribute_m;
        }
        else {
          cf.setReachedBranch(11);
          m_current_token_type = WktToken.attribute_zm;
        }
      } else {
        cf.setReachedBranch(12);
        nextToken();
      }
    }
  ```
* Henrik : 

Estimated impact of refactoring (lower CC, but other drawbacks?).
* Mathieu : 
* My :
* Julian : `Clipper::checkSegmentIntersection_` will experience CC will drop to around 1/3 of what it had before. So a lower CC is applicable. Other drawbacks may be that it will be harder to understand the code. Since the documentation is not so extensive and there are no comments at the moment. It will be even more difficult for a new member to learn and understand how the function is executed. `SweepComparator::compareSegments` can also expect a large drop in CC due to the division into smaller functions. Compared to the `Clipper::checkSegmentIntersection_`, this function will be easier to follow since the name of the functions are much more straight forward.
* Axel :
  * Simplifying character-comparisons reduces CC from 16 to 14.
  * Breaking code into subroutine: reduces CC from 14 to 8.
  * In total my suggestions would reduce CC by half (16 to 8) and make the code more readable.
* Henrik : 

Carried out refactoring (optional)
* Mathieu : 
* My :
* Julian : None.
* Axel : None.
* Henrik : 

git diff ...

## Overall experience

What are your main take-aways from this project? What did you learn?
* Axel : I haven't really worked that much with coverage before so it was interesting and a good experience. I particularly enjoyed implementing the manual coverage implementation, and seeing how the branch coverage went up when I added tests. A slightly unrelated take-away is that using the built-in editor in GitHub to collaborate on a report (without pull requests) is not a good idea, because sometimes your changes get lost in the void.
* Julian : This was completely new for me so it was interesting to see how large programs are dealt with when collaborating with others. Coverage is also something that I now have opened my eyes for since I had not thought about testing in this manner. 

Is there something special you want to mention here?
