# CS2430-Group1
There are many different sorting algorithms in common use. Some are fast on average, some are stable, some use more memory, some behave poorly on already-sorted data, and some are mainly of academic interest. In this project your team will:

Generate all possible permutations of small integer arrays.
Run multiple sorting algorithms on each permutation.
Count the number of comparisons each algorithm makes.
Identify the best 10, worst 10, and average performances.
Use the collected data to make and defend Big-O / Big-Ω / Big-Θ style estimates based on your measurements.
For this project you will specifically compare mergesort, quicksort, shaker sort (a bidirectional bubble sort), and heapsort. You may use textbook or online versions of these algorithms as long as you (a) understand them, (b) clearly comment them, and (c) document your source.

Required output/testability constraints
Comparison-count definition: Count only element-to-element comparisons that determine ordering (e.g., a[i] < a[j]). Do not count loop bounds checks or index comparisons.
Consistent metric: Use the same comparison-count approach across all four algorithms.
Reproducibility: Your README must describe exactly how to run the experiment and produce the tables used in the report.
Required n values: Run n = 4, 6, 8 for all algorithms and collect the required summary outputs.
Output structure: Your program must be able to generate a clearly labeled summary for each algorithm and n, including best/worst/average comparisons.
Part 1 – Array Generator
Write code to generate all possible permutations of the integers 0 through n − 1 for a given small n. For example, if n = 3, your generator must produce:

{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}
Implement a standard lexicographic permutation algorithm (recommended) or any correct algorithm that enumerates all permutations without duplicates.

Part 2 – Implement Sorting Algorithms
Implement (or adapt and comment) the following four sorting algorithms:

Mergesort
Quicksort
Shaker sort (bidirectional bubble)
Heapsort
Each algorithm must:

Accept an unsorted array of integers as input.
Return or make available the sorted array.
Count and report the number of comparisons performed.
Part 3 – Test Driver and Performance Metrics
Write a driver program that calls your functions from Part 2 and the generator from Part 1. Then runs all four algorithms on each permutation, and records:

Algorithm name
The unsorted array used
Number of comparisons
Part 4 – Experimental Runs and Data Collection
Run your system for n = 4, 6, 8 and record for each algorithm:

Best 10 cases (fewest comparisons) and the input arrays that produced them
Worst 10 cases (most comparisons) and the input arrays that produced them
Average comparisons across all permutations
