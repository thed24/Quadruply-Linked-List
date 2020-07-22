# Quadruply Linked List

A data structure I created in Java to act as a board for a recreation of Pacman I created in Java.

# Data Structure

A regular doubly linked list would be structured as below:

```
Node A ↔ Node B ↔ Node C
```

This quadruply linked list, however, operates in a lattice or mesh like pattern, as opposed to a line:

```
Node A ↔ Node B ↔ Node C
   ↕       ↕      ↕
Node D ↔ Node E ↔ Node F
   ↕       ↕      ↕
Node G ↔ Node H ↔ Node I
```

## Circular Nature

Furthermore, it operates in a circular manner. For example: Node A has four pointers, *Up, Down, Left and Right*. Node A has no apparent Up or Left connected Nodes, however, similar to a circular doubly linked list, Node As Up pointer connects it to Node G, and its Left pointer connects it to Node C.

## Generics

The data structure is created with generic typings, and as such it can be adapted to any required use case.

## Tests

There are several basic tests that ensure that the data structure is instantiated with all the required pointers and wrapping. 

# Purpose

This data structure with a two fold reasoning in mind: 

Firstly, I was recreating Pac-Man within the terminal using Java and leveraging the consoles Raw Input mode. When developing the game, I wanted to pick the best data structure for the map that Pacman and the ghosts traversed, and found that most data structures required work arounds or added functionality to work, however, had a data structure such as this one existed, it would naturally wrap around and allow for the movement that Pacman and the ghosts utilized. And so, I made this.

Secondly, it seemed like a fun challenge.