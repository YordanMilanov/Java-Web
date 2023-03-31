-- some test users
INSERT INTO users (id, username, password, full_name, email, level)
VALUES (1, 'manager', 'manager', 'mr.Manager', 'manager@abv.bg', 'EMPLOYEE');

INSERT INTO users (id, username, password, full_name, email, level)
VALUES (2,'staff', 'staff', 'mr.Staff', 'staff@abv.bg', 'EMPLOYEE');

INSERT INTO users (id, username, password, full_name, email, level)
VALUES (3,'customer-new', 'customer-new', 'mr.Customer-new', 'customer-new@abv.bg', 'CUSTOMER');

INSERT INTO users (id, username, password, full_name, email, level)
VALUES (4,'customer-regular', 'customer-regular', 'mr.Customer-regular', 'customer-regular@abv.bg', 'CUSTOMER');

INSERT INTO users (id, username, password, full_name, email, level)
VALUES (5,'customer-vip', 'customer-vip', 'mr.Customer-vip', 'customer-vip@abv.bg', 'CUSTOMER');

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



