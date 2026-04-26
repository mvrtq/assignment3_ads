# Assignment 3: Sorting and Searching Algorithm Analysis System

##  Project Overview

This project focuses on implementing and analyzing fundamental sorting and searching algorithms in Java.

The goal is to compare their performance using different input sizes and data structures, and to evaluate how theoretical time complexity (Big-O) matches practical execution time.

### Selected Algorithms:

* **Basic Sorting:** Bubble Sort
* **Advanced Sorting:** Merge Sort
* **Searching:** Binary Search

---

## Purpose of the Experiment

The purpose of this project is to:

* Understand how algorithms behave with different input sizes
* Compare inefficient vs efficient algorithms
* Measure execution time using `System.nanoTime()`
* Analyze how input type affects performance
* Connect theory (Big-O) with real-world results

---

##  Algorithm Descriptions

###  Bubble Sort

Bubble Sort repeatedly compares adjacent elements and swaps them if they are in the wrong order.

* Best Case: **O(n)** (already sorted)
* Average Case: **O(n²)**
* Worst Case: **O(n²)**

Key idea: simple but inefficient for large datasets.

---

###  Merge Sort

Merge Sort uses the divide-and-conquer approach:

1. Divide the array into halves
2. Recursively sort each half
3. Merge sorted halves

* Best Case: **O(n log n)**
* Average Case: **O(n log n)**
* Worst Case: **O(n log n)**

Key idea: efficient and stable for large datasets.

---

### Binary Search

Binary Search works only on **sorted arrays**.
It repeatedly divides the search space in half.

* Best Case: **O(1)**
* Average Case: **O(log n)**
* Worst Case: **O(log n)**

Key idea: very fast but requires sorted data.

---

## Experimental Setup

### Array Sizes:

* Small: 1,000
* Medium: 5,000
* Large: 10,000

### Data Types:

* Random
* Sorted
* Reverse
* Duplicates

### Method:

* Each test is repeated **5 times**
* Average execution time is calculated
* Time measured using `System.nanoTime()`

---

##  Experimental Results

| Algorithm     | Small (1000) | Medium (5000) | Large (10000) |
| ------------- | ------------ | ------------- | ------------- |
| Bubble Sort   | ~1–3 ms      | ~20–60 ms     | ~100–300 ms   |
| Merge Sort    | ~0.1 ms      | ~0.5 ms       | ~1–2 ms       |
| Binary Search | ~0.001 ms    | ~0.002 ms     | ~0.003 ms     |

*(Values may vary depending on system performance)*

---

##  Analysis

### 1. Which sorting algorithm is faster?

Merge Sort is significantly faster than Bubble Sort, especially for large arrays.

**Reason:**

* Bubble Sort has quadratic complexity O(n²)
* Merge Sort has O(n log n)

---

### 2. How does performance change with input size?

* Bubble Sort becomes extremely slow as size increases
* Merge Sort scales efficiently

---

### 3. Sorted vs Unsorted Data

* Bubble Sort performs faster on sorted data due to early stopping
* Merge Sort performance is consistent regardless of input

---

### 4. Do results match Big-O?

Yes:

* Bubble Sort grows rapidly → O(n²)
* Merge Sort grows slowly → O(n log n)

---

### 5. Which search algorithm is more efficient?

Binary Search is much faster than Linear Search because:

* It reduces the search space by half each step

---

### 6. Why Binary Search requires sorted array?

Because it relies on order to eliminate half of the elements at each step.
Without sorting, comparisons would not be meaningful.

##

---

##  Reflection

This project helped me understand the real difference between inefficient and efficient algorithms.

Although Bubble Sort is simple, it becomes impractical for large datasets. Merge Sort, on the other hand, demonstrates how better algorithm design significantly improves performance.

I also learned that theoretical complexity closely matches practical results, especially as input size increases.

One challenge was designing fair experiments and ensuring accurate timing using `nanoTime()`.

Overall, this project improved my understanding of algorithm efficiency and performance analysis.

---


##  Conclusion

* Merge Sort is the best choice for large datasets
* Bubble Sort is only useful for educational purposes
* Binary Search is extremely efficient but requires sorting
* Algorithm choice has a major impact on performance

---
