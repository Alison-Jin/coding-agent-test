# Binary Search

A simple Java implementation of the binary search algorithm.

## Overview

This project provides a command-line program that searches for a target value within a sorted integer array using binary search.

## Usage

Compile and run the program by passing the sorted array elements followed by the target value as command-line arguments.

```bash
javac src/Main.java -d out
java -cp out Main <array elements> <target value>
```

### Example

```bash
java -cp out Main 1 2 3 4 5 3
```

The last argument is always the **target value**. This searches for `3` in the array `[1, 2, 3, 4, 5]` and prints the index where it was found, or `-1` if not found.

## Output

```
Result index: 2
```

## Project Structure

```
src/
  Main.java   # Binary search implementation and entry point
```
