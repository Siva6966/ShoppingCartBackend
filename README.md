# Shopping Cart API (Java 8) — Author: Cva

## Run
```bash
cd backend
mvn spring-boot:run
```

Endpoints:
- `GET /api/products`
- `GET /api/cart`
- `POST /api/cart/add` body: `{ "productId": 1, "quantity": 2 }`
- `POST /api/cart/clear`
- `DELETE /api/cart/{id}`
- `POST /api/cart/{id}/quantity/{qty}`

H2 Console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:shopdb`)
