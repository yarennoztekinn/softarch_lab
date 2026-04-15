# LAB 02 Report

## What was completed

- Filled in the catalog module repository logic with `findById` and `save`.
- Implemented constructor injection and stock validation in `CatalogServiceImpl`.
- Fixed `CatalogFactory` so it creates and returns the catalog API properly.
- Completed the orders module with constructor injection, order creation, and repository persistence.
- Added request handling with success/failure messages in `OrderController`.
- Wired the application from `Main.java` through the factories and added sample test calls.

## Architecture comparison: Lab 01 vs Lab 02

Lab 01 used a layered architecture. The flow was vertical in terms of technical layers: presentation, business, persistence, and domain. `OrderService` depended directly on `ProductRepository`, so the business logic knew about the storage details of products. That made the system simpler at first, but it also created tight coupling between layers and made the order logic aware of infrastructure details.

Lab 02 refactors the same business scenario into a modular monolith. The system is split by business capability into `catalog` and `orders`. Each module hides its internals using package-private classes, and other modules only see public APIs. The orders module no longer accesses product objects or repositories directly; it depends on the `CatalogService` interface instead. Factories are used to assemble each module internally while keeping implementation details hidden.

## Main differences

- Lab 01 is organized by technical layer; Lab 02 is organized by business module.
- Lab 01 exposes the repository to the service layer directly; Lab 02 hides repositories behind module factories.
- Lab 01 has tighter coupling; Lab 02 improves encapsulation and reduces cross-module knowledge.
- Lab 01 shares domain objects more openly; Lab 02 keeps internal model classes package-private.

## Result

The Lab 02 version is a cleaner example of information hiding and modular boundaries in plain Java. It keeps the module contracts small and makes internal refactoring safer.