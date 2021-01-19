# Solow-Swan Projection #

# Executive Summary #
- Use the Solow-Swan economic growth model to forecast the state of the U.S. economy given parameters like savings rate, depreciation, population growth, and labor efficiency growth. 
- Take a look at default values provided that reflect the current U.S. economy or adjust the parameters to create your own forecast! 
- Golden rule savings rate optimization option included.
- Java Swing GUI included.

# Requirements #
Java Swing (javax.swing)

# Quickstart Guide (No Build Necessary) #
1. Clone repository
2. Navigate to src file locally
3. Compile: javac \*.java
4. Run: java MainFrame

Tested on Java 1.8 (1.8.0_231), Java 11 (11.0.1), Java 13 (13.0.1).

# What is Solow-Swan? #
In 1956, economists Robert Solow and Trevor Swan came up with a framework to model the long-run economic growth of a system (such as a country). In addition to typical economic factors like capital, labor, savings, and investment, Solow and Swan theorized that technological growth is the key to long-run growth in a system's steady-state equilibrium. 

# Notes #
- Output Elasticity of Capital (α): All else equal, a 1% increase in capital available for production will lead to an α% increase in output production. Constant returns to scale are assumed as per the Solow-Swan model.
- Cobb-Douglas is by far the most commonly used projection function for the Solow-Swan model
- The Golden Rule tunes the savings rate of a system to maximize the level of long-term permanent consumption. Of course, such an optimal policy seldom occurs in practice, but perhaps it offers a useful guideline!
