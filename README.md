# Choreographed Saga Pattern: An Approach for Orchestrating Distributed Transactions

## Introduction
Managing distributed transactions in complex systems is a common challenge faced by many organizations. The need to maintain data consistency and ensure transaction reliability in distributed environments has led to the development of various approaches. One of these approaches is the Choreographed Saga Pattern, which provides an efficient solution for orchestrating distributed transactions. In this technical text, we will discuss the concept of the Choreographed Saga Pattern, its characteristics, as well as its strengths and weaknesses.

## Definition of the Choreographed Saga Pattern
The Choreographed Saga Pattern is a design pattern used to handle distributed transactions in distributed systems. It allows a set of services to interact in a coordinated manner to execute complex transactions while maintaining data consistency throughout the process. Unlike the Orchestrated Saga Pattern, where there is a centralized component responsible for transaction orchestration, the Choreographed Saga Pattern involves direct collaboration among the participating services.

## Characteristics of the Choreographed Saga Pattern
1. Service Autonomy: Each service involved in the distributed transaction has its own compensation logic, ensuring greater autonomy and independence among the services.
2. Direct Collaboration: Services collaborate directly with each other by sending events and messages to coordinate transaction steps. This eliminates the need for a centralized orchestration component.
3. Fault Tolerance: The Choreographed Saga Pattern is designed to handle failures in distributed environments. If any service fails during the transaction, the participating services can execute the corresponding compensation steps to restore system consistency.

## Advantages of the Choreographed Saga Pattern
1. Decoupling: The pattern promotes decoupling among services, allowing them to evolve independently. This facilitates system maintenance and scalability.
2. Horizontal Scalability: The Choreographed Saga Pattern allows for the addition of new participating services without directly impacting existing services. This enables the system to scale horizontally to handle a higher volume of transactions.
3. Eventual Consistency: While the Choreographed Saga Pattern does not guarantee immediate transaction consistency, it provides eventual consistency by executing the necessary compensation steps to correct errors or failures.

## Disadvantages of the Choreographed Saga Pattern
1. Implementation Complexity: The direct collaboration among services can lead to increased implementation complexity, requiring a good understanding of the system architecture and interactions between services.
2. Asynchronous Messaging: Communication between services is based on asynchronous message exchange, which can increase the complexity of tracking and debugging transactions.
3. Race Conditions: In high-concurrency scenarios, there may be race conditions between services, resulting in unexpected behaviors.

# Success Flow

The image represents a successful flow of a distributed transaction. This image symbolizes the completion of transaction steps, where all involved services have executed their operations correctly, resulting in a consistent and reliable system state. The presence of the success image in the Choreographed Saga Pattern is an important visual indicator to verify the successful completion of a distributed transaction.

<br />

<p align="center">
  <img src="/img/success_flow.png" alt="success-flow" />
</p>

<p align="center">
  <img src="/img/postman.png" alt="success-flow" />
</p>

<p align="center">
  <img src="/img/case_success/sale_table.png" alt="success-flow" />
</p>

<p align="center">
  <img src="/img/case_success/inventories_table.png" alt="success-flow" />
</p>

<p align="center">
  <img src="/img/case_success/payment_table.png" alt="success-flow" />
</p>

<p align="center">
  <img src="/img/case_success/sale_table_2.png" alt="success-flow" />
</p>

# Fault Flow

In the Choreographed Saga Pattern, the failure flow represents a scenario where an issue occurred during the execution of a distributed transaction. This flow indicates the interruption or failure of one or more transaction steps, signaling that the transaction was not successfully completed. In the context of the Choreographed Saga Pattern, identifying the failure flow is crucial for participating services to recognize any problems or errors that may have arisen during the distributed transaction process. This enables them to take necessary measures to address the situation and restore system consistency.

<br />

<p align="center">
  <img src="/img/fault_flow.png" alt="fault-flow" />
</p>
