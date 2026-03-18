# 🚀 Java 26 Feature Showcase

This repository contains a small, developer-focused Java project that demonstrates practical **Java 26** language, library, and platform improvements with code you can reuse in talks, blog posts, demos, or internal learning sessions.

> **Release note:** JDK 26 reached general availability on **March 17, 2026**. Several features shown here are still **preview** or **incubator** features, so they require extra compiler/runtime flags when you try them locally.

## What is included

The source code focuses on the Java 26 topics backend developers are most likely to explore first:

1. **Structured Concurrency** for cleaner task orchestration.
2. **HTTP/3** support in the standard HTTP client.
3. **Primitive-aware pattern matching for `switch`**.
4. **Lazy constants** for deferred initialization.
5. **PEM cryptography support** in the JDK.
6. **Vector API** examples for data-parallel math.
7. Notes on removals and runtime improvements such as the Applet API removal and GC work.

## Project structure

```text
src/main/java/com/example/java26/
├── Http3Examples.java
├── Java26FeatureShowcase.java
├── LazyConstantExamples.java
├── PemExamples.java
├── PrimitivePatternSwitchExamples.java
├── StructuredConcurrencyExamples.java
└── VectorApiExamples.java
```

## Running the examples

Because this repository targets Java 26 features, use a **JDK 26** installation when you run it.

### Compile

```bash
javac \
  --release 26 \
  --enable-preview \
  --add-modules jdk.incubator.vector \
  -d out \
  $(find src/main/java -name '*.java')
```

### Run

```bash
java \
  --enable-preview \
  --add-modules jdk.incubator.vector \
  -cp out \
  com.example.java26.Java26FeatureShowcase
```

## Feature walkthrough

### 1) Structured Concurrency (Preview)

Structured concurrency lets you treat related concurrent tasks as one unit of work. That makes fan-out/fan-in workflows much easier to reason about than manually coordinating futures, cancellation, and error propagation.

Typical use cases:

- aggregate responses from multiple services;
- fetch user, payment, and order data in parallel;
- fail fast when one subtask breaks.

The example in `StructuredConcurrencyExamples` shows how to:

- fork subtasks inside a scope;
- wait for them together;
- keep cancellation/error management inside a clear lifecycle.

### 2) HTTP/3 support

Java's built-in `HttpClient` now supports **HTTP/3**, which means you can opt into QUIC-based communication from the standard library instead of relying on third-party clients for early experimentation.

The `Http3Examples` class demonstrates:

- creating an `HttpClient` configured for HTTP/3;
- sending a simple GET request;
- handling a response body using the standard client API.

### 3) Primitive-aware pattern matching for `switch`

Java 26 continues the pattern-matching story by extending pattern support to primitive selectors and primitive patterns. This helps reduce branching boilerplate and makes classification logic more expressive.

The `PrimitivePatternSwitchExamples` class demonstrates:

- switching on `float` values;
- using guards (`when`) for compact conditional matching;
- keeping business rules readable.

### 4) Lazy constants

Lazy constants are useful when you want a `static final`-style declaration but you **do not** want to pay initialization cost at startup.

The `LazyConstantExamples` class demonstrates:

- deferring expensive configuration loading;
- memoizing the result after the first access;
- keeping code intention obvious.

### 5) PEM cryptography support

Java 26 includes standard PEM APIs so common certificate/key workflows are easier to build without extra helper libraries.

The `PemExamples` class demonstrates:

- encoding a generated public key to PEM text;
- decoding PEM text back into a JDK key object.

### 6) Vector API (Incubator)

The Vector API remains a strong option for performance-sensitive workloads such as pricing engines, analytics, simulation, DSP, and certain ML/data-processing tasks.

The `VectorApiExamples` class demonstrates:

- loading arrays into vectors;
- applying SIMD-style addition;
- writing the result back efficiently.

## Short article version

If you want a ready-to-publish article draft, here is a polished version you can adapt.

---

# 🚀 Java 26 is Here! Top Features Every Developer Should Know (With Code Examples)

Java keeps evolving, and **JDK 26** brings useful improvements in concurrency, networking, cryptography, and performance-oriented APIs.

If you are a backend engineer, these features are worth testing early because they improve real-world code quality just as much as raw performance.

## 🧠 1. Structured Concurrency (Preview)

Structured concurrency simplifies parallel programming by letting related tasks live inside one scope.

**Why it matters**

- cleaner async orchestration;
- clearer cancellation rules;
- better failure handling in service aggregation.

## ⚡ 2. HTTP/3 Support

The standard Java HTTP client now supports **HTTP/3**, making it easier to build lower-latency clients for modern APIs.

**Why it matters**

- faster handshakes;
- improved performance on unreliable networks;
- future-ready networking without third-party libraries.

## 🧩 3. Primitive Pattern Matching for `switch`

Java 26 expands pattern matching to cover primitive patterns in `switch`, which helps you write more expressive classification logic.

**Why it matters**

- less branching boilerplate;
- more readable domain rules;
- simpler formatting and validation code.

## 🧪 4. Lazy Constants

Lazy constants help large apps avoid expensive initialization work until a value is truly needed.

**Why it matters**

- faster startup;
- lower eager memory cost;
- better control over initialization hotspots.

## 🔐 5. PEM Support for Cryptography

PEM support in the standard library reduces friction for key and certificate handling.

**Why it matters**

- easier key exchange workflows;
- fewer utility dependencies;
- cleaner security tooling code.

## 🧮 6. Vector API

The incubating Vector API remains one of the most exciting parts of the platform for CPU-bound workloads.

**Why it matters**

- faster numerical operations;
- more predictable data-parallel code;
- useful for finance, analytics, AI/ML preprocessing, and simulation.

## 🗑️ 7. Applet API Removal

The platform continues removing old baggage, making the JDK smaller and easier to maintain.

## ⚙️ 8. Runtime and GC Improvements

Java 26 also continues platform work around throughput, startup, and runtime optimization.

## 🎯 Final Thoughts

Java 26 is a practical release: not flashy for the sake of flash, but strongly aligned with the kinds of improvements backend teams actually benefit from.

If you only try three things first, start with:

1. Structured Concurrency
2. HTTP/3
3. Primitive pattern matching for `switch`

---

## Notes

- Preview and incubator features can change between releases.
- Some examples are intentionally small so they are easy to copy into articles or presentations.
- If you want to turn this into a Maven or Gradle sample once JDK 26 is installed locally, add your preferred build wrapper and keep the same compiler flags.
