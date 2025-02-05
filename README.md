# Computes the 'best' cog combination for a [bike cassette](https://www.sheldonbrown.com/k7.html)

[![Scala CI](https://github.com/benoitpas/k7-calculator/actions/workflows/scala.yml/badge.svg)](https://github.com/benoitpas/k7-calculator/actions/workflows/scala.yml)

Knowing the number of teeths of the smallest and largest cogs as well as the number of cogs, this program finds the best combination so that the 'jump' between cogs is as constant as possible.

The evaluate if the percentage jump between cogs is as constant as possible, we compute the [Root mean square deviation](https://en.wikipedia.org/wiki/Root_mean_square) of the difference with the average jump.

The following 2 tables show the computation for 5 cogs with 14 teeths as smallest and 28 as largest:

* This configuration is fairly common but is not optimum as the 'jump' from 16 to 20 is very large (25% vs 14% for the jump from 14 to 16):

|               | Cogs | Difference | % increase | Squared difference to average |
|---------------|------|------------|------------|-------------------------------|
|               |   14 |            |            |                               |
|               |   16 |          2 |     14.29% |                          0.22 |
|               |   20 |          4 |     25.00% |                          0.37 |
|               |   24 |          4 |     20.00% |                          0.01 |
|               |   28 |          4 |     16.67% |                          0.05 |
| Average       |      |            |     18.99% |                               |
| RMS deviation |      |            |            |                          0.08 |

* This is the optimum configuration, there is not other combination with a smaller RMS deviation

|                  | Cogs | Difference | % increase | Squared difference to average |
|------------------|------|------------|------------|-------------------------------|
|                  |   14 |            |            |                               |
|                  |   17 |          3 |     21.43% |                          0.06 |
|                  |   20 |          3 |     17.65% |                          0.02 |
|                  |   24 |          4 |     20.00% |                          0.01 |
|                  |   28 |          4 |     16.67% |                          0.05 |
| Average          |      |            |     18.94% |                               |
| RMS deviation    |      |            |            |                          0.04 |



## sbt project compiled with Scala 3

### Usage

This is a normal sbt project, you can compile code with `sbt compile` and run it
with `sbt run`, `sbt console` will start a Scala REPL.
