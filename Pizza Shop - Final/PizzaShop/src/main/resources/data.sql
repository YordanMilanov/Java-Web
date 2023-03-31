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
