# arya.dev

A personal blog and newsletter platform, built from scratch as the vehicle for learning backend development, starting from zero Spring Boot experience.

## Tech Stack

- **Backend:** Java 21, Spring Boot 3.5
- **Auth:** JWT
- **Database:** PostgreSQL (via Supabase)
- **Containerization:** Docker
- **Hosting:** Render (backend) + Supabase (database) + Vercel (frontend)
- **Email:** Resend SMTP (newsletter)

## Architecture

```
Vercel (frontend) → Render (Spring Boot backend) → Supabase (PostgreSQL)
```

## Features

- Blog engine with published posts (deployment journey, Android sideloading policy, more in progress)
- JWT-based authentication
- Newsletter subscription system - built end-to-end (Subscriber/Newsletter entities, Resend SMTP integration). Currently unused in production: no domain to run it on yet, and free-tier email limits make it impractical at this stage. The code is live and ready to switch on.

## Deployment Journey

Deployment wasn't a straight line - the failures taught as much as the wins:

1. **First attempt failed.** Used the latest non-LTS versions of Java and other tooling instead of LTS releases, which broke the deployment.
2. **No Docker yet.** Hadn't used Docker before this project, it wasn't part of the stack for the first couple of deployment attempts.
3. **Docker adopted.** After repeated failures, containerized the app with Docker to get consistent, reproducible builds/deploys.
4. **Railway instability.** Initially deployed on Railway, but hit reliability issues.
5. **Migrated to a stable stack.** Moved to Render (backend) + Supabase (database) + Vercel (frontend). Database itself was migrated from Render's Postgres to Supabase.
6. **Debugged production issues.** Worked through CORS misconfigurations, Spring Security setup, and JPA/Hibernate quirks along the way.

## Design

Editorial, white, typography-first aesthetic, influenced by Paco Coursey and Rauno's design sensibilities. Content over chrome.

## Lessons Learned

- LTS versions exist for a reason. Bleeding-edge tooling is a liability in production, not a flex.
- Docker isn't optional infra ceremony; it's what makes deploys reproducible instead of "works on my machine."
- Platform reliability matters as much as feature set when picking where to host.
- Shipping something (the newsletter system) doesn't mean it has to be switched on immediately, learning things, infra readiness and feature readiness are separate milestones.

## Status

Actively maintained. Newsletter system built and ready, pending a domain and a viable email-sending tier.
