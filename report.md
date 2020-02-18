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
* Henrik : `MultiPathImpl::insertPath` and `ConvexHull::construct`

Please write here if you used any other functions for the part about increasing coverage/writing tests. 
* Mathieu : 
* My :
* Julian : 
* Axel : `Boundary::hasNonEmptyBoundary`
* Henrik : `Envelope3D::intersect` and `Envelope2D::_snapToBoundary`

## Complexity

1. What are your results for ten complex functions?
   * Did all tools/methods get the same result?
       * Mathieu : I have the same result computing the CC by hand or with `lizard`
       * My : Yes, they are the same!
       * Axel : I get the same results (16) both with `lizard` and by hand.
       * Julian : Yes I get exactly the same results by hand and with lizard.
       * Henrik: Yes I got 17 on both.
   * Are the results clear?
       * Yes, it is very straightforward.
       * All the conditions in an `if`, a `for` or a `while` add 1 to the cyclomatic complexity. So if there are 10 conditions on arguments this will add ten to the cyclomatic complexity.
       * The `assert` are not taken into account.
       * The ternary logic operator are taken into account
       * At the end add 1 to have the cyclomatic complexity metric
2. Are the functions just complex, or also long?
    * Mathieu : The functions are complex and long. `SegmentIntersecot::intersect` that has CC 30 has 84 LOC and `Line::_intersectLineLine` that has CC 37 has 110 LOC
    * My : The functions I chose are both complex and long. The one with CC 15 has 50 LOC and the one with CC 16 has 43 LOC.
    * Julian : `SweepComparator::compareSegments` has CC 16 and LOC of 63. `Clipper::checkSegmentIntersection_` has CC 17 and LOC of 42. So one of them is cleary on the shorter end but has slightly higher complexity. 
    * Axel : `attributes_` has 34 LOC and `polygonTouchesPolygonImpl_` has 76 LOC (both have CC 16).
    * Henrik : `construct` has 81 LOC and `insertPath` has 67 LOC
    * *Summary* : There is no direct relation between the CC and the LOC. This is normal because a function that has plenty of `if`s with one statement will be smaller then a function with only few `if`s but long statement in it. However, the CC will be much larger.
3. What is the purpose of the functions?
    * Axel : 
      * `WktParser::attributes_` is a function in a class for parsing files in the WKT file format. It is responsible for parsing attributes.
      * `RelationalOperations::polygonTouchesPolygonImpl_` returns true if two polygons touch/intersect, false otherwise.
    * Mathieu :
      * The goal of `Line::_intersectLineLine` is to see if two lines intersect. If it is the case it returns the points that are in both lines
      * The goal of `SegmentIntersecot::intersect` is to determine if there is an intersection between a Point and a Segment with a certain `tolerance` where a Segment is a collection of line 
    * My : 
      * The goal of `Envelope2D::clipLine` is to implement the Liang-Barsky algorithm for parametric line-clipping. The input parameters is: a start point and a end point. Depending on whether the points are within a given envelope, one of them will be modified and thus extending the line they create.
      * The goal of `PolygonUtils::testPointsOnPolyLine2D_` is to determine if two points are on a "polyline".
    * Henrik :
      * The goal of `construct` is to create a convex hull.
      * The goal of `insertPath` is to insert a vertex into a path.
    * Julian : 
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
    * *Summary* : Most of the functions are not documented which is really strange for a big project like that. 
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
    * Henrik : Yes, it's consistant.
    * *Summary* : Our tool give the same result as the coverage tool of IntelliJ. The only difference that can happend is when there are ternary operator that we haven't change into `if...else` statement.


### Coverage improvement
What is the coverage like overall for your project?
The IntelliJ coverage tool reports 91% class coverage, 71% method coverage and 72% line coverage.

TODO: branch coverage %?

Show the comments that describe the requirements for the coverage.

#### Old and new Coverage
* Mathieu : 
    * old : Before the tests
	```
	* SegmentIntersector::intersect has 77.27272727272727% coverage, reached 34/44 branches.
    		* The Branch ID that are not reached are [0, 4, 16, 17, 18, 19, 20, 21, 41, 42]
	* Line::_intersectLineLine has 88.46153846153845% coverage, reached 46/52 branches.
    		* The Branch ID that are not reached are [5, 13, 22, 32, 39, 40]
	```
    * new : After the test for `SegmentIntersector::intersect` and `Line::_intersectLineLine`
	```
	* SegmentIntersector::intersect has 79.54545454545455% coverage, reached 35/44 branches.
   		* The Branch ID that are not reached are [4, 16, 17, 18, 19, 20, 21, 41, 42]
 	* Line::_intersectLineLine has 98.07692307692307% coverage, reached 51/52 branches.
    		* The Branch ID that are not reached are [39]
	```

* My :
    * old : `Envelope2D`: methods coverage 59%, line coverage 48%, function coverage 0% (no tests at all). `PolygonUtils`: method coverage 56%, line coverage 41%, function coverage 66.6%. Output from our coverage tool:
	```
	* PolygonUtils::testPointsonPolyLine2D_ has 66.66666666666666% coverage, reached 8/12 branches.
    		* The Branch ID that are not reached are [0, 2, 3, 11]
	```
    * new : `Envelope2D`: methods coverage 60%, line coverage 50%, function coverage 28.6%. `PolygonUtils`: method coverage 56%, line coverage 45%, function coverage 83.3%. Output from our coverage tool: 
	```
 	* Envelope2D::clipLine has 28.57142857142857% coverage, reached 2/7 branches.
    		* The Branch ID that are not reached are [2, 3, 4, 5, 6]
 	* PolygonUtils::testPointsonPolyLine2D_ has 83.33333333333334% coverage, reached 10/12 branches.
    		* The Branch ID that are not reached are [3, 11]
	```
* Julian : 
* Axel : 
   * old : `polygonTouchesPolygonImpl_`: The containing class has 97% method coverage and 85% line coverage. The function has 70.6% branch coverage and `hasNonEmptyBoundary` : The containing class has 87% method coverage and 65% line coverage. The function has 23% branch coverage
   	```
   	* RelationalOperations::polygonTouchesPolygonImpl_ has 70.58823529411765% coverage, reached 12/17 branches.
    		* The Branch ID that are not reached are [3, 8, 11, 13, 14]
  	* Boundary::hasNonEmptyBoundary has 23.076923076923077% coverage, reached 3/13 branches.
     		 * The Branch ID that are not reached are [1, 3, 4, 5, 7, 8, 9, 10, 11, 12]
  	```
   * new:  `RelationalOperations`: IntelliJ reports the same coverage percentages, because I just added one test which covers one new branch (it's just a return statement) and the source file has 2565 lines of code. My DIY branch coverage instrumentation shows that the previously unreached branch (8) was now reached. So the branch coverage for the specific function was increased from 70.6% to 76.5%. 
   For `hasNonEmptyBoundary` : The line coverage for the containing class increased from 65% to 77%. My DIY branch coverage instrumentation shows that branch coverage was increased from 23% to 69%:
  	```
  	* RelationalOperations::polygonTouchesPolygonImpl_ has 76.47058823529412% coverage, reached 13/17 branches.
      		* The Branch ID that are not reached are [3, 11, 13, 14]
  	* Boundary::hasNonEmptyBoundary has 69.23076923076923% coverage, reached 9/13 branches.
    		* The Branch ID that are not reached are [8, 9, 10, 12]
  	```

* Henrik : I chose two new functions to create tests for, `Envelope3D::intersect` and `Envelope2D::_snapToBoundary`. Neither of them had any tests to begin with, so our coverage tool showed nothing before I added tests. However after adding a few tests to the two methods I got the following results:

	* Envelope3D::intersect has 83.33333333333334% coverage, reached 10/12 branches.
    		* The Branch ID that are not reached are [1, 6]

 	* Envelope2D::_snapToBoundary has 64.28571428571429% coverage, reached 9/14 branches.
  	        * The Branch ID that are not reached are [1, 10, 11, 12, 13]

#### Test cases added:
* My : The branch [My-test](https://github.com/hmellin97/geometry-api-java/tree/My-test) contains the added tests. To easily display them use the command `git diff My-DIY..My-test`.
* Mathieu : The branch [mathieu-test](https://github.com/hmellin97/geometry-api-java/tree/mathieu-test) contains the added tests in the `TestLine` and `TestSegmentIntersector`class. To easily display them use the command `git diff mathieu-diy..mathieu-test`.
* Julian : 
* Axel : The branch [Axel-test](https://github.com/hmellin97/geometry-api-java/tree/Axel-test) contains the added tests. To easily display them use the command `git diff axel-manual-coverage..Axel-test`.
* Henrik : The branch [henrik-test](https://github.com/hmellin97/geometry-api-java/tree/henrik-test) contains the added tests. To easily display them use the command `git diff henrik-DIY..henrik-test`.

Can the functions you test be called directly or did you need to make them public?
* Mathieu : The function are called directly because they are static
* My : The functions are called directly.
* Julian : 
* Axel : I had to make `polygonTouchesPolygonImpl_` public, but `hasNonEmptyBoundary` can be called directly.
* Henrik : They were public so that was not a problem.


## Refactoring
Is the complexity of the functions really necessary?
* Mathieu : No. The function can be easily splitted in many smaller function.
* My : The complexity of `Envelope2D::clipLine` is, in my opinion necessary. There are many if-statements, but what is actually executed beneath them is very short and at most 3-4 LOC. However, there is one part of this function that is questionable. The following code is executed:
```
tOld[0] = segParams[0];
tOld[1] = segParams[1];
```
And shortly after this, without changing any of these variables, there is if statements containing: `segParams[1] < tOld[1]` and `segParams[0] > tOld[0]` which will never be true due to the code above. So, this part adds unnecessary complexity to the function. There might be some thought behind it, but there are no comments to explain why it is done in that way. 

The complexity of `PolygonUtils:: testPointsOnPolyLine2D_` is not necessary in my opinion. It could easily be broken down to smaller functions.

* Julian : For `Clipper::checkSegmentIntersection_` the complexity is necessary. It has a higher complexity since it needs to be able to handle the three different cases. In each case it needs to be able to identify whether to return 0, 1, -1. It can however be broken down into smaller functions and still achieve its purpose. `SweepComparator::compareSegments` is similarly also dependant on having high complexity. This is because a large part of the function aims to just understand what type of objects that are being compared. Depending on this, different types comparisons are being called. 

* Axel : As mentioned before, I don't understand `WktParser::attributes_` in detail, though I get on a higher level what it is supposed to do. I can understand that most of this complexity is needed because there are a lot of different cases for how the attributes to be parsed can be formatted. There are however some improvements that can be made to decrease complexity.

* Henrik : The start of `construct` has some special cases when the number of points is low. These special cases could be split up into a separate function. The same thing goes with `insertPath` it has a few if-statements that throw exceptions in the beginning of the function. You could also split them up into a seperate function.

Plan for refactoring complex code:
* Mathieu : in `SegmentIntersector` l.291 they test whichi rank is bigger and then do exactly the same thing but with different line. The code could easily be rewritten using an helper function `private boolean notEqualRank(Line l1, Line l2)` that should be used to set the boolean `bigmove`.
```java
if (rank1 > rank2) {                               
	bigmove = notEqualRank(line_1, line_2);
} else {
	bigmove = notEqualRank(line_2, line_1);
}
```
Moreover l.318 the first line is splitted and the the second one. We could easily implement a `private void splitLine(Line l, int count, double [] m_param)` that could be used for both `line1` and `line2`. 
* My : in `clipLine`, the only thing I would change is to take away the code that can’t be reached. This would make it impossible for the function to have some of its possible outcomes (thus, they are already impossible because they can’t be reached). 
To refactor `testPointsOnPolyLine2D_`, I would break the code down into smaller functions. If you take a look at the function it is clearly divided into 4 blocks, where each block could be put into a separate function. The variables that are used would be passed on as input-parameters in the new help-functions. And the new help-functions would return new values of updated variables that are used. 

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
* Henrik : Move 
```java
	if (src == this) {
			throw new IllegalArgumentException();
		}

		if (srcPathIndex >= src.getPathCount()) 
			throw new IllegalArgumentException();
		}

		int oldPathCount = getPathCount();
		if (pathIndex > oldPathCount) {
			throw new IllegalArgumentException();

		}
		
	} 
	
``` 
Into a function called `checkForExceptions`. The same idea goes for the if-statements in `construct`.

Estimated impact of refactoring (lower CC, but other drawbacks?).
* Mathieu : The first proposition will reduce the CC by 2 and the second will reduce it by 8. But most of all, it will increase the readability of the function. A function that is more than 100 LOC with `if`s depth of 6 without documentation it is really hard to follow. For those two proposition I cannot find a drawback.
* My : For the refactoring of `clipLine` 4/7 branches would disappear, but the drawback would be that some outcomes are not possible. Perhaps there is some change that could be done so that the function works properly instead.
Dividing `testPointsOnPolyLine2D_` into 4 functions would decrease the CC to 25% of the original assuming each function would have ~4 CC each.
* Julian : `Clipper::checkSegmentIntersection_` will experience CC will drop to around 1/3 of what it had before. So a lower CC is applicable. Other drawbacks may be that it will be harder to understand the code. Since the documentation is not so extensive and there are no comments at the moment. It will be even more difficult for a new member to learn and understand how the function is executed. `SweepComparator::compareSegments` can also expect a large drop in CC due to the division into smaller functions. Compared to the `Clipper::checkSegmentIntersection_`, this function will be easier to follow since the name of the functions are much more straight forward.
* Axel :
  * Simplifying character-comparisons reduces CC from 16 to 14.
  * Breaking code into subroutine: reduces CC from 14 to 8.
  * In total my suggestions would reduce CC by half (16 to 8) and make the code more readable.
* Henrik : I can't think of any drawbacks with this refactoring. It would reduce the CC and make the functions less bloated.

Carried out refactoring (optional)
* Mathieu : None.
* My : None.
* Julian : None.
* Axel : None.
* Henrik : None.

git diff ...

## Overall experience

What are your main take-aways from this project? What did you learn?
* Axel : I haven't really worked that much with coverage before so it was interesting and a good experience. I particularly enjoyed implementing the manual coverage implementation, and seeing how the branch coverage went up when I added tests. A slightly unrelated take-away is that using the built-in editor in GitHub to collaborate on a report (without pull requests) is not a good idea, because sometimes your changes get lost in the void.
* Julian : This was completely new for me so it was interesting to see how large programs are dealt with when collaborating with others. Coverage is also something that I now have opened my eyes for since I had not thought about testing in this manner. 
* Mathieu : It was my first experience with OpenSource and I was surprise by the fact that almost none of the functions were documented, that the function were really long without reason and without using other methods. Except that it was interesting to see how coverage work and to see where we can improve our code easily.
* It was good to learn about coverage and cyclic complexity. I was surprised to see that lizard worked so well at quickly analyzing your code like that. I also learned that open-source projects can be a hazzle to work with.

Is there something special you want to mention here?
