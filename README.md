# Bowling Game Kata
#### What is it
The Bowling Game Kata is a famous code kata from [butunclebob.com](http://www.butunclebob.com/ArticleS.UncleBob.TheBowlingGameKata)
The powerpoint of his approach can be found in the first word of his page ["Here"](http://www.butunclebob.com/files/downloads/Bowling%20Game%20Kata.ppt)

## My experience
*Two days ago, I had barely heard at most 3 times about code kata. I had always been imaginated it as a nerd thing.*

*But passing a few hours at one of my colleagues, he showed me this challenge.*

*After trying to help him to improve the solution he had already started during a few hours, where we were much learning how bowling is played, I finally saw the relevance of TDD.*

*So,I am happy to share the first TDD and first code kata I have ever done.*

## The version of Bowling Game Kata solved here.
There are many versions of this Kata out there. 

The Kata we are trying to solve is largely inspired from [https://codingdojo.org/kata/Bowling/](https://codingdojo.org/kata/Bowling/).
The difference is that :
  - we check for valid rolls
  - we check for valid frames


### The approach
The game receive all the list of roll in String format "x x x x x x x x x x x x".

- Only one roll is treated at a time. If the roll is valid, it is temporary stored in a frame.
- The frame is validated in a whole.
- Once the frame is complete, we keep only its score and the list of bonus to process one or two steps ahead, then we reset the frame.

In other words, at a moment, we store: 
- only the rolls of the current frame,
- the current score,
- the information on bonuses to count one or two steps later.


#### Complexity
I estimate :
- the time complexity to O(n). 
- the space complexity to O(5).

#### Test-Driven Development
The TDD journey I traversed can be examinated in [commits](https://github.com/gerwaismomo/BowlingGame/commits/main).
I tried to commit each TDD step (Red, Green, Refactor). But I had to cheat around 5-10 times. 

### Code quality
We have tried to provide a clean code for this first TDD and Kata experience.
