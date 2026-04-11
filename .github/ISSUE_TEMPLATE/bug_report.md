---
name: Bug Report
about: Report a defect in the Book Tracking API
title: "[BUG] "
labels: bug, needs-triage
assignees: ''
---

## Summary
<!-- One-sentence description of the defect. -->


## Environment
- **Java Version**: 
- **Spring Boot Version**: 
- **Database**: 
- **OS / Deployment**: 
- **Branch / Commit**: 

## Steps to Reproduce
1. 
2. 
3. 

## Expected Behavior
<!-- What should happen? -->


## Actual Behavior
<!-- What happens instead? Include error messages, status codes, stack traces. -->


## Architectural Analysis

### Root Cause Hypothesis
<!-- Where do you believe the defect originates? Be specific about the layer and component. -->
<!-- Example: "The BookService.updateReadingStatus() method does not validate that the book exists before updating, causing a NullPointerException in the repository layer." -->


### Affected Components
- [ ] Controller / REST endpoint
- [ ] Service layer
- [ ] Repository / Data access
- [ ] Domain model / Entity mapping
- [ ] DTO serialization/deserialization
- [ ] Security / Auth filter
- [ ] Configuration
- [ ] Database schema or migration

### Blast Radius
<!-- Who and what is impacted? Is this isolated or does it affect other features? -->
<!-- Example: "Isolated to the /api/books/{id}/progress endpoint. No downstream effects on other services." -->


### Systemic or One-Off?
<!-- Does this reveal a broader design weakness, or is it a localized mistake? -->
<!-- Example: "Systemic — we are missing null-safety checks across multiple service methods. Consider adding a base validation layer." -->


## Proposed Fix
<!-- Optional: describe your suggested approach to fixing the issue. -->


## Severity
<!-- Choose one -->
- [ ] **Critical** — System unusable, data loss, security vulnerability
- [ ] **High** — Major feature broken, no workaround
- [ ] **Medium** — Feature impaired, workaround exists
- [ ] **Low** — Minor inconvenience, cosmetic

## Supporting Evidence
<!-- Attach logs, screenshots, curl commands, Postman exports, etc. -->

