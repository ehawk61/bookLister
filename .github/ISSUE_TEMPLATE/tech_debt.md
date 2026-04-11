---
name: Tech Debt / Refactor
about: Address technical debt, code smells, or architectural improvements
title: "[TECH DEBT] "
labels: tech-debt, refactor
assignees: ''
---

## Summary
<!-- One-sentence description of the debt or improvement. -->


## Current State
<!-- Describe how things work today. Be specific about the code, patterns, or architecture involved. -->
<!-- Example: "Book search queries are built with raw string concatenation in BookRepository, bypassing the Criteria API and making the code vulnerable to injection and hard to extend." -->


## Desired State
<!-- Describe the target architecture or code quality you want to reach. -->
<!-- Example: "All dynamic queries should use the JPA Criteria API or Spring Data Specifications for type safety, composability, and injection protection." -->


## Architectural Principle Violated
<!-- Which design principle or best practice is being broken? Check all that apply. -->
- [ ] Single Responsibility Principle
- [ ] Separation of Concerns
- [ ] Don't Repeat Yourself (DRY)
- [ ] Open/Closed Principle
- [ ] Dependency Inversion
- [ ] Encapsulation / Information Hiding
- [ ] Consistent error handling
- [ ] Proper layering (controller → service → repository)
- [ ] API contract stability
- [ ] Testability
- [ ] Other: <!-- specify -->

## Cost of Inaction
<!-- What happens if we don't address this? Be concrete. -->
<!-- Example: "Every new search filter requires modifying the same 200-line method, increasing bug risk. Estimated 2x developer time for each new filter vs. using Specifications." -->


## Proposed Approach
<!-- How would you refactor this? Outline the steps. -->
1. 
2. 
3. 

## Components Affected
- [ ] Controller / REST endpoints
- [ ] Service layer
- [ ] Repository / Data access
- [ ] Domain model / Entities
- [ ] DTOs / API contracts
- [ ] Security / Auth
- [ ] Configuration / Properties
- [ ] Build / CI pipeline
- [ ] Tests

## Migration & Rollback
<!-- Is this a breaking change? How do you migrate safely? Can you roll back? -->
- **Breaking change**: Yes / No
- **Migration strategy**: 
- **Rollback plan**: 

## Effort Estimate
<!-- T-shirt size or story points — helps with prioritization. -->
- [ ] Small (< 1 day)
- [ ] Medium (1–3 days)
- [ ] Large (3–5 days)
- [ ] Extra Large (1+ week)

## Acceptance Criteria
- [ ] 
- [ ] 
- [ ] 

