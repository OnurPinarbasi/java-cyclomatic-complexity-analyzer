# Java Cyclomatic Complexity Analyzer
A lightweight static code analysis tool that calculates the Cyclomatic Complexity of Java source files.
## Overview

Cyclomatic Complexity is a software metric used to measure the complexity of a program.
It counts the number of independent paths through the source code.
 
This tool analyzes Java source files and calculates their Cyclomatic Complexity based on
common decision points such as:
- if / else if
- loops (for, while)
- switch / case
- catch blocks
## Features
- Analyze Java source files
- Detect decision structures
- Calculate Cyclomatic Complexity
- Provide a simple risk level classification
- Generate a command-line analysis report

## Usage

Compile the project and run the analyzer with a Java source file. You need to write exact file name into configurations input arguments. (Later version it will change to select file type)

## Roadmap

### v1.0
Initial MVP release with CLI support.

### v1.1
Improved parsing and logical operator detection.

### v2.0
GUI interface with visualization and complexity heatmaps.

## Future
Project-wide analysis and advanced metrics.


#### License

This project is licensed under the MIT License.
