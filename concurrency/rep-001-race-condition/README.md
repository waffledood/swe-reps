# Rep 001 - Create and Diagnose a Race Condition

Topic: Concurrency

## Objective

Understand why two threads incrementing the same integer can produce an incorrect final count, then test how synchronizing the increment changes the behavior.

## What I Know

I understand two threads accessing a shared variable (in this case, incrementing it by a count of 1 on each access) concurrently will not produce the same result as a sequential/serialized execution.

## Prediction

Before running the program, predict:

- What final count do I expect?
  A value less than `200,000`.

- Will it be the same every run?
  No it will be different every run.

- Why?
  Because two threads are accessing a variable concurrently & this causes race conditions, where the order & behavior of each thread accessing the variable is not consistent.

## Experiment

This rep uses a shared Java counter. Two threads each increment it 100,000 times.

From this directory:

```sh
javac -d out src/main/java/swereps/concurrency/rep001/*.java
java -cp out swereps.concurrency.rep001.RaceConditionDemo
```

Run it several times.

Then change one variable:

- Make `SharedCounter.increment()` synchronized.
- Recompile.
- Run it several times again.

## Result

Record what happened before and after adding `synchronized`.

## Explanation

Explain in your own words:

- What operation did `count++` really represent?
- Where could the two threads overlap?
- Why did `synchronized` change the outcome?

## Gaps Discovered

List what still feels unclear or suspicious.

## Next Rep Candidates

- Make the race easier or harder to reproduce by changing loop counts.
- Add logging around the read/modify/write steps in a smaller example.
- Compare throughput before and after synchronization.
