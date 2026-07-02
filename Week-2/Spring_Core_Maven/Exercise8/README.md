Exercise 8 - Basic Spring AOP

What is AOP Advice
Advice is the action taken by an aspect at a particular join point. Different types of advice include:

- Before Advice: Executed before the target method begins its execution. Annotated with @Before. It cannot stop the execution flow unless it throws an exception.
- After (Finally) Advice: Executed after the target method completes, regardless of whether it completed normally or threw an exception. Annotated with @After.
- After Returning Advice: Executed only if the target method completes successfully without throwing an exception.
- After Throwing Advice: Executed only if the target method throws an exception.
- Around Advice: Wraps the target method and can execute code both before and after the method. It can also choose whether to proceed with the method execution or return a custom value.

How it is Implemented here
In our LoggingAspect, we defined two advices:
1. logBefore: Executed before any method in BookService runs.
2. logAfter: Executed after any method in BookService completes.
AspectJ autoproxy is enabled in XML to apply these advices at runtime.
