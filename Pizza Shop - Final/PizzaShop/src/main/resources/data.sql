-- Addresses
INSERT INTO addresses (id,city, neighborhood, street, street_number)
VALUES(1,'City','Center','street', 1);

INSERT INTO addresses (id, city, neighborhood, street, street_number)
VALUES(2,'City','Center','street', 2);

INSERT INTO addresses (id, city, neighborhood, street, street_number)
VALUES(3,'City','Center','street', 3);

INSERT INTO addresses (id, city, neighborhood, street, street_number)
VALUES(4,'City','Center','street', 4);

INSERT INTO addresses (id, city, neighborhood, street, street_number)
VALUES(5,'City','Center','street', 5);

-- some test users
INSERT INTO users (id, username, password, full_name, email, level, `address_id`)
VALUES (1, 'manager', 'manager', 'mr.Manager', 'manager@abv.bg', 'EMPLOYEE', 1);

INSERT INTO users (id, username, password, full_name, email, level, `address_id`)
VALUES (2,'staff', 'staff', 'mr.Staff', 'staff@abv.bg', 'EMPLOYEE', 2);

INSERT INTO users (id, username, password, full_name, email, level, `address_id`)
VALUES (3,'customer-new', 'customer-new', 'mr.Customer-new', 'customer-new@abv.bg', 'CUSTOMER', 3);

INSERT INTO users (id, username, password, full_name, email, level, `address_id`)
VALUES (4,'customer-regular', 'customer-regular', 'mr.Customer-regular', 'customer-regular@abv.bg', 'CUSTOMER', 4);

INSERT INTO users (id, username, password, full_name, email, level, `address_id`)
VALUES (5,'customer-vip', 'customer-vip', 'mr.Customer-vip', 'customer-vip@abv.bg', 'CUSTOMER', 5);

-- user roles

-- Manager
INSERT INTO users_roles (`user_id`, `roles_id`)
VALUES (1, 1);
INSERT INTO users_roles (`user_id`, `roles_id`)
VALUES (1, 2);
INSERT INTO users_roles (`user_id`, `roles_id`)
VALUES (1, 3);

-- Staff
INSERT INTO users_roles (`user_id`, `roles_id`)
VALUES (2, 2);
INSERT INTO users_roles (`user_id`, `roles_id`)
VALUES (2, 3);

-- Customer - new
INSERT INTO users_roles (`user_id`, `roles_id`)
VALUES (3, 3);

-- Customer - regular
INSERT INTO users_roles (`user_id`, `roles_id`)
VALUES (4, 3);

-- Customer - vip
INSERT INTO users_roles (`user_id`, `roles_id`)
VALUES (5, 3);

-- Ingredients
INSERT INTO ingredients (id, name, price, stock_in_kg, protein, carbohydrates, fat, calories,ingredient_type)
VALUES (1,'pizza sauce', 10, 10, 5, 45, 0, 200, 'MAIN');

INSERT INTO ingredients (id, name, price, stock_in_kg, protein, carbohydrates, fat, calories,ingredient_type)
VALUES (2,'mozzarella', 18, 5, 25, 6, 20, 304, 'MAIN');

INSERT INTO ingredients (id, name, price, stock_in_kg, protein, carbohydrates, fat, calories,ingredient_type)
VALUES (3,'tuna', 35, 5, 25, 0, 1, 104, 'MAIN');

INSERT INTO ingredients (id, name, price, stock_in_kg, protein, carbohydrates, fat, calories,ingredient_type)
VALUES (4,'red onions', 1.5, 10, 1, 9, 0, 40, 'MAIN');

INSERT INTO ingredients (id, name, price, stock_in_kg, protein, carbohydrates, fat, calories,ingredient_type)
VALUES (5,'sweetcorn', 9, 5, 2, 18, 0, 80, 'MAIN');

INSERT INTO ingredients (id, name, price, stock_in_kg, protein, carbohydrates, fat, calories,ingredient_type)
VALUES (6,'black olive', 10, 10, 1, 7, 6, 86, 'MAIN');

INSERT INTO ingredients (id, name, price, stock_in_kg, protein, carbohydrates, fat, calories,ingredient_type)
VALUES (7,'ham', 15, 10, 13, 3, 27, 309, 'MAIN');

INSERT INTO ingredients (id, name, price, stock_in_kg, protein, carbohydrates, fat, calories,ingredient_type)
VALUES (8,'bacon', 25, 10, 35, 1, 43, 531, 'MAIN');

INSERT INTO ingredients (id, name, price, stock_in_kg, protein, carbohydrates, fat, calories,ingredient_type)
VALUES (9,'white cheese', 13, 10, 22, 16, 17, 264, 'MAIN');

INSERT INTO ingredients (id, name, price, stock_in_kg, protein, carbohydrates, fat, calories,ingredient_type)
VALUES (10,'cheese', 19, 10, 25, 1, 30, 374, 'MAIN');

INSERT INTO ingredients (id, name, price, stock_in_kg, protein, carbohydrates, fat, calories,ingredient_type)
VALUES (11,'tomato', 4, 15, 1, 4, 0, 20, 'MAIN');

INSERT INTO ingredients (id, name, price, stock_in_kg, protein, carbohydrates, fat, calories,ingredient_type)
VALUES (12,'cucumber', 5, 20, 1, 2, 0, 12, 'MAIN');

INSERT INTO ingredients (id, name, price, stock_in_kg, protein, carbohydrates, fat, calories,ingredient_type)
VALUES (13,'dough', 8, 30, 8, 43, 1, 213, 'MAIN');