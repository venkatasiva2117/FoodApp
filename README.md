Foodie - Food Ordering App
==========================

Frontend: HTML/CSS/JS (no frameworks). Backend: Java (J2EE Servlets), JDBC, MySQL.

Run Frontend
------------
- Open `index.html` with Live Server or any static server.
- The UI works with mock data if backend is offline.

Database (MySQL)
----------------
1. Create DB and import schema:
```sql
CREATE DATABASE foodie;
USE foodie;
SOURCE db/schema.sql;
```
2. Update DB credentials in `backend/src/main/webapp/WEB-INF/web.xml` (`JDBC_URL`, `JDBC_USER`, `JDBC_PASS`).

Backend (Servlets)
------------------
- Requires Java 8+, Maven, and a Servlet container (Tomcat 9/10).

Build WAR:
```bash
cd backend
mvn clean package -DskipTests
```
Deploy `backend/target/foodie.war` to Tomcat webapps. The app exposes:
- `GET /api/menu` → list menu
- `POST /api/menu` → add menu item (admin)
- `POST /api/auth/login` → login
- `POST /api/auth/logout` → logout
- `GET /api/orders` → list my orders
- `POST /api/orders` → create order

CORS/Static: Serve `index.html` from any host. If hosting backend on another origin, add reverse proxy or enable CORS in container.

Default Admin
-------------
Insert an admin row in `users` with a bcrypt hash or plain temporary password. Example seed is in `db/schema.sql`.

Notes
-----
- Session-based auth via JSESSIONID; frontend requests use `credentials: 'include'`.
- If MySQL auth uses native password plugin, ensure connector compatibility.
