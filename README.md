# travel-service-WEB

The project represents a website, which offers customers 3 types of services related to travelling:
- Tour agency
- Hotel room rental
- Car rental

User performs following functions:
- registration;
- logging in;
- browsing three catalogues: tour offers, apartments and cars;
- using multicriteria sorting in catalogues;
- choosing an offer and making an order;
- receiving a bill for the order;
- logging out.

Admin performs following functions:
- adding new offers to catalogues: tour offers, apartments and cars;
- marking damaged cars and creating a bill for the clients;
- fetching info about orders: by service, by user, by period.

Additional functions:
- Soon expiring offers are marked as "hot";
- Clients with more than 3 orders are marked as "vip".

Project realisation details:
- MySQL JDBC with connection pool;
- MVC model;
- Factory method, Command, Singletone;
- JSP with JSTL;
- sessions and filters.
