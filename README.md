# 🔗 fisslink

A simple URL shortener web application built with React and Spring Boot.

---

## Overview

fisslink is a full-stack web application that allows users to shorten long URLs into compact, shareable links.

The name is inspired by *fission* — the idea of splitting something large into smaller parts (Physics), just like long URLs are converted into short links.

---

## eatures

- 🔗 Shorten long URLs into unique short links
- ⚡ Fast redirection to original URLs
- 🧹 Simple and clean user interface
- 📱 Responsive design (mobile-friendly)
- 🔒 Reliable backend storage

---

## Tech Stack

Frontend:
- JavaScript
- React

Backend:
- Java
- Spring Boot

Database (planned):
- PostgreSQL or MySQL

---

## Project Structure

fisslink/
├── frontend/
│   ├── src/
│   ├── public/
│   └── package.json
│
├── backend/
│   ├── src/
│   ├── pom.xml
│   └── application.properties
│
└── README.md

---

## Backend Architecture (Planned)

- REST API built with Spring Boot
- Generates unique short codes for URLs
- Stores mapping between original URL and short URL
- Handles redirection logic

---

## API Endpoints (Planned)

### Create Short URL
POST /api/urls

Request Body:
{
  "originalUrl": "https://example.com"
}

Response:
{
  "shortUrl": "https://fiss.link/abc123"
}

---

### Redirect to Original URL
GET /{shortCode}

Redirects user to the original URL.

---

## Database Schema (Planned)

Table: urls

- id (Long / UUID) → Primary key  
- original_url (String) → Original long URL  
- short_code (String) → Generated short code  
- created_at (Timestamp) → Creation time  

---

## Future Improvements

- User authentication
- Click analytics
- Custom short links
- QR code generation
- Link expiration feature

---

## Deployment Plan

- Frontend: Render / Vercel  
- Backend: Render  
- Database: Render PostgreSQL or external DB  

---

## Author

Built by Adamson  

---

## Status

Project is currently under development
